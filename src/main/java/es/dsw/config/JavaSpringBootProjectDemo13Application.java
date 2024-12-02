package es.dsw.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"es.dsw"})
public class JavaSpringBootProjectDemo13Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBootProjectDemo13Application.class, args);
	}

}
