/*
 * Copyright (c) 2017. Gloagen Software
 */

package io.gloagen.web.dak;

//import io.gloagen.web.hibernate.DataStore;
//import io.gloagen.web.hibernate.HibernateConfiguration;
//import io.gloagen.web.session.HibernateSessionFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by raphaelmathieu on 16/07/2017.
 */
@ApplicationPath("/")
public class App extends Application {

//    @Inject
//    private DataStore dataStore;

    static final Logger logger = LogManager.getLogger(App.class);

    public App() {
        try {

            logger.info("Initialising the App loading context ...");
//            setApplicationName("DAK - WEB application");

//            HibernateConfiguration.initialiseSession();

            System.out.println(">>>>>> TESTING THIS ... <<<<<<");

//            registerClasses(HibernateSessionFilter.class);
        }
        catch (Exception e) {
            throw new RuntimeException("Unable to initialise the application ~ " + e.getMessage(), e);
        }
    }
}
