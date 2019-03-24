package ru.gotoqa.sp2.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * @author Muflikhunov Roman
 */
@Configuration
@ApplicationPath("/controllers")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("ru.gotoqa.sp2.controllers");
    }

}
