package ua.ithillel.tomcatrs.config;

import org.glassfish.jersey.server.ResourceConfig;
import ua.ithillel.tomcatrs.UserResource;
import ua.ithillel.tomcatrs.binder.MyAppBinder;
import ua.ithillel.tomcatrs.service.UserServiceDefault;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("ua.ithillel.tomcatrs");
        register(new MyAppBinder());
    }
}
