package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  // 스캔을 통해 모든 빈 객체를 컨테이너에 등록한다.
public class JpashopApplication {



		public static void main(String[] args) {
			SpringApplication.run(JpashopApplication.class, args);
		}
		@Bean
		Hibernate5Module hibernate5Module() {
			Hibernate5Module hibernate5Module = new Hibernate5Module();
			//강제 지연 로딩 설정
			//쓰지 않는 것을 추천
//			hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
			return hibernate5Module;
		}



}
