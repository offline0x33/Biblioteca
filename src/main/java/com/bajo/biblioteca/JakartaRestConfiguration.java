package com.bajo.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
//import org.eclipse.microprofile.auth.LoginConfig;
import org.jboss.logging.Logger;

/**
 * Configures Jakarta RESTful Web Services for the application.
 *
 * @author bajinho
 */
//@LoginConfig(authMethod = "MP-JWT")
@ApplicationScoped
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {

    private final Logger log = Logger.getLogger(JakartaRestConfiguration.class);

    public JakartaRestConfiguration() {
        log.trace("called method with: %s");

        log.info("returning: %s");
    }
}
