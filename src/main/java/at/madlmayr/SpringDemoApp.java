package at.madlmayr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringDemoApp.class);

    public static void main(final String[] args) {
        LOGGER.info("Application started");
        new SpringApplication(SpringDemoApp.class).run(args);

    }

}