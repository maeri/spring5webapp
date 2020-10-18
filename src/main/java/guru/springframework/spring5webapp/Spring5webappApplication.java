package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Spring5webappApplication {

	private static Logger logger = LoggerFactory.getLogger(Spring5webappApplication.class);

	public static void main(String[] args) {
		logger.debug("start Spring5webappApplication application...");
		SpringApplication.run(Spring5webappApplication.class, args);
	}

}
