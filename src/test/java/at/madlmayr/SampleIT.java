package at.madlmayr;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDemoApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// Disable Listens to have less logging
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class SampleIT {


    private static final Logger LOGGER = LoggerFactory.getLogger(SampleIT.class);

    @LocalServerPort
    int port;

    private String getLocalUrl() {
        // ATTENTION: Make sure there is no "/" at the end of the URL!
        final String url = String.format("http://localhost:%s", port);
        LOGGER.info("###### test url: '{}'", url);
        return url;
    }

    @Test
    public void test01_validateStandardResponse() {
        try {
            given().expect()
                    .statusCode(HttpStatus.OK.value())
                    .body("content", IsEqual.equalTo("Hello, World!"))
                    .when()
                    .get(getLocalUrl() + "/greeting");
        } catch (final Exception e) {
            LOGGER.error("Test Failed {}", e.getMessage());
            Assert.fail();
        }
    }

    @Test
    public void test02_validateCustomResponse() {
        try {
            given().expect()
                    .statusCode(HttpStatus.OK.value())
                    .body("content", IsEqual.equalTo("Hello, Spring!"))
                    .when()
                    .get(getLocalUrl() + "/greeting?name=Spring");
        } catch (final Exception e) {
            LOGGER.error("Test Failed {}", e.getMessage());
            Assert.fail();
        }
    }
}
