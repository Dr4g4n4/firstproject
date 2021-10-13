package com.firstexample.demo;

import com.firstexample.demo.model.enumeration.Color;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// ArrayList list = new ArrayList<Color>(Arrays.asList(Color.values()));
		// System.out.println("color: " + list);
	}
}
