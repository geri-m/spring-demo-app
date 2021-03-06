package at.madlmayr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Taken from https://spring.io/guides/gs/rest-service/
 */

@RestController
public class SampleRestApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleRestApi.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        LOGGER.info("{} Count", counter);
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));

    }
}
