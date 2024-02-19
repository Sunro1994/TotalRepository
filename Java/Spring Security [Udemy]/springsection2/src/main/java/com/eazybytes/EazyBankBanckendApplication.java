package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.eazybytes.controller") //parent 패키지 외부에 만든경우 이렇게 만들어야 스캔이 가능하다.
public class EazyBankBanckendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBanckendApplication.class, args);
	}

}
