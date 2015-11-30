package de.jonashackt.restexamples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import de.jonashackt.restexamples.controller.Controller;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestexamplesApplication.class)
@WebIntegrationTest
public class RestexamplesApplicationTests {
    
	@Test
	public void contextLoads() {
	    // Given
	    RestTemplate restTemplate = new RestTemplate();
	    
	    // When
	    String response = restTemplate.getForObject("http://localhost:8080/restexamples/hello", String.class);
	    
	    // Then
	    assertEquals(Controller.RESPONSE, response);
	}

}
