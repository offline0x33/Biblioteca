package com.bajo.biblioteca;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@LoginConfig(authMethod = "MP-JWT", realmName = "Packt")
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    
}
