package com.wesley.stock;

import com.wesley.stock.aop.TraceAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Import(TraceAspect.class)
@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Spring Security 기능 비활성화
public class StockApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

}
