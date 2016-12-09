package de.jonashackt.restexamples;

import static org.junit.Assert.assertEquals;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.apache.http.HttpStatus;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import de.jonashackt.restexamples.controller.Controller;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = RestexamplesApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class RestexamplesApplicationTests {
    
	@Test
	public void testWithSpringRestTemplate() {
	    // Given
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // When
	    String response = restTemplate.getForObject("http://localhost:8080/restexamples/hello", String.class);
	    
	    // Then
	    assertEquals(Controller.RESPONSE, response);
	}
	
	/**
	 * Using Restassured for elegant REST-Testing, see https://github.com/jayway/rest-assured
	 */
	@Test
    public void testWithRestAssured() {
	    
	    given() // can be ommited when GET only
        .when() // can be ommited when GET only
            .get("http://localhost:8080/restexamples/hello")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .assertThat()
                .equals(Controller.RESPONSE);
    }
	
	@Before
	public void setUp() {
	    
	}

}
