package com.assignment.daofab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Application main class
 * Flow start from this class
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class DaofabAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaofabAssignmentApplication.class, args);
	}

}
