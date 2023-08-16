package ua.ithillel.tomcatrs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.ithillel.tomcatrs.model.User;
import ua.ithillel.tomcatrs.service.UserService;
import ua.ithillel.tomcatrs.util.TestUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class UserResourceTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserResource userResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        List<User> mockUsers = TestUtil.getMockUsers();

        when(userService.getUsers()).thenReturn(mockUsers);
        when(userService.getUserById(anyInt())).thenAnswer(inv -> {
            Integer id = (Integer) inv.getArgument(0);
            User user = new User();
            user.setId(id);
            return user;
        });

        doNothing().when(userService).addUser(any());
        // return given user
        doAnswer(inv -> inv.getArgument(1)).when(userService).updateUser(anyInt(), any());
        // return given user
        doAnswer(inv -> {
            Integer id = (Integer) inv.getArgument(0);
            User deletedUser = new User();
            deletedUser.setId(id);
            return deletedUser;
        }).when(userService).deleteUser(any());
    }

    @Test
    public void getAllTest_returnsListOfUsers() {
        List<User> all = userResource.getAll();

        assertNotNull(all);
        assertNotEquals(all.size(), 0);
    }

    @Test
    public void getById_returnsUser() {
        Integer testId = 1000;
        User user = userResource.getById(testId);

        assertNotNull(user);
        assertEquals(testId, user.getId());
    }

    @Test
    public void addTest_returnsNothing() {
        User testUser = new User();
        userResource.add(testUser);
    }

    @Test
    public void updateTest_returnsUpdatedUser() {
        Integer testId = 1000;
        User testUser = new User();
        User updatedUser = userResource.update(testId, testUser);

        assertNotNull(updatedUser);
        assertEquals(testUser, updatedUser);
    }

    @Test
    public void deleteTest_returnsUpdatedUser() {
        Integer testId = 1000;
        User deletedUser = userResource.delete(testId);

        assertNotNull(deletedUser);
        assertEquals(testId, deletedUser.getId());
    }
}
