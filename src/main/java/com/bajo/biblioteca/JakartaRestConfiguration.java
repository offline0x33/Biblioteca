package com.bajo.biblioteca;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 *
 * @author bajinho
 */
@ApplicationScoped
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
}
