package fr.edu.aix.yuccaspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/*@Configuration*/
public class DerbyConfig { 
	
	    /*@Bean*/
	    public EmbeddedDatabase dataSource() {
	        return new EmbeddedDatabaseBuilder()
	                   .addScripts("classpath:/derby/test.sql")
	                   .setType(EmbeddedDatabaseType.DERBY)
	                   .build();
	    }
}
