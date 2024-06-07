package com.novatech.aquamarine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class AquamarineApplication {

	@GetMapping
	public ResponseEntity<String> getResponse(){
		return ResponseEntity.ok("Aquamarine online! Acesse a documentação em:https://aquamarine-springboot-api-production.up.railway.app/swagger-ui/index.html");
	}

	public static void main(String[] args) {
		SpringApplication.run(AquamarineApplication.class, args);
	}
}