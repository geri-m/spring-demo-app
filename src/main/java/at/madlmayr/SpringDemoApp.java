package at.madlmayr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApp {

    public static void main(final String[] args) {
        new SpringApplication(SpringDemoApp.class).run(args);

    }

}