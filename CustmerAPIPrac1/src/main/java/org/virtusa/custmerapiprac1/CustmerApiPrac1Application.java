package org.virtusa.custmerapiprac1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef="auditAware")
@SpringBootApplication
public class CustmerApiPrac1Application {

	public static void main(String[] args) {
		SpringApplication.run(CustmerApiPrac1Application.class, args);
	}

}
