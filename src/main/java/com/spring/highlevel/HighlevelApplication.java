package com.spring.highlevel;

import com.spring.highlevel.app.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication
public class HighlevelApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighlevelApplication.class, args);
	}

}
