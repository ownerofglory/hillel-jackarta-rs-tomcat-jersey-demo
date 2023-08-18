package ua.ithillel.tomcatrs.binder;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import ua.ithillel.tomcatrs.service.UserService;
import ua.ithillel.tomcatrs.service.UserServiceDefault;

public class MyAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
//        bindFactory(new UserServiceFactory())
//                .to(UserService.class)
//                .in(Singleton.class);

        bind(UserServiceDefault.class)
                .to(UserService.class)
                .in(Singleton.class);
    }

}
