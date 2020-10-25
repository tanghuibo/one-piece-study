package io.github.tanghuibo.onepiecestudyweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.github.tanghuibo.onepiecestudyweb.mapper")
public class OnePieceStudyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnePieceStudyWebApplication.class, args);
	}

}
