package fr.edu.aix.yuccaspringboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="${application.server.config.url}/application.properties")
public class YuccaConfig {

}
