package candidate;


import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CandidateApplication {

	public static void main(String[] args) {
		startH2Server();
		SpringApplication.run(CandidateApplication.class, args);
	}

	private static void startH2Server() {
        try {
            Server.createTcpServer().start();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to start H2 server: ", e);
        }
    }
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
