package fr.edu.aix.yuccaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * SpringBootApplication contient déjà 
 * l'annotation EnableAutoConfiguration
 * @author omignot
 *
 */
@SpringBootApplication
public class YuccaApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuccaApiDataApplication.class, args);
	}

}
