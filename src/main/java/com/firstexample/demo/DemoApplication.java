package com.firstexample.demo;

import com.firstexample.demo.model.enumeration.Color;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// ArrayList list = new ArrayList<Color>(Arrays.asList(Color.values()));
		// System.out.println("color: " + list);
	}

}
