package com.jojoldu;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static final String PROPERTIES = "spring.config.location=classpath:/client.yml";

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
				.properties(PROPERTIES)
				.run(args);
	}
}
