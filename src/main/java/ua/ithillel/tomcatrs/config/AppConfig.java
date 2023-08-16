package ua.ithillel.tomcatrs.config;

import org.glassfish.jersey.server.ResourceConfig;
import ua.ithillel.tomcatrs.binder.MyAppBinder;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("ua.ithillel.tomcatrs");
        register(new MyAppBinder());
    }
}
