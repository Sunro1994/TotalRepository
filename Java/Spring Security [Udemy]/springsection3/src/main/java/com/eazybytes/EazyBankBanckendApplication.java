package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
//@ComponentScan("com.eazybytes.controller") //parent 패키지 외부에 만든경우 이렇게 만들어야 스캔이 가능하다.
@EnableJpaRepositories("com.eazybytes.repository")//아래 두 패키지도 동일
@EntityScan(" com.eazybytes.model")
@EnableWebSecurity //만약 스프링없이 프로젝트를 생성시 필요한 태그
public class EazyBankBanckendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBanckendApplication.class, args);
	}

}
