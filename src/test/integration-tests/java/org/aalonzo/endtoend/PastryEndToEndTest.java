package org.aalonzo.endtoend;

import org.aalonzo.controller.PastryController;
import org.aalonzo.domain.Pastry;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PastryEndToEndTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PastryController controller;

//    @AfterEach
//    public void clearRepository() {
//        repository.deleteAll();
//    }
    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }
    @Test
    @Disabled
    public void endpointExists() {
        String url = "http://localhost:" + port + "/v1/pastry";

        assertThat(this.restTemplate.getForObject("http://localhost:" + port+ "/v1/pastry",
                String.class)).contains("[]");
    }

    @Test
    @Disabled
    public void addPastryAndShow(){
       Pastry pastry = new Pastry("Cookie", .1);
//        HttpHeaders headers = new HttpHeaders();
//      //  headers.setContentType(MediaType.APPLICATION_JSON);
//        personJsonObject = new JSONObject();
//        personJsonObject.put("id", 1);
//        personJsonObject.put("name", "John");
//        HttpEntity<String> request =
//                new HttpEntity<String>(personJsonObject.toString(), headers);

//        String personResultAsJsonStr =
//                restTemplate.postForObject(createPersonUrl, request, String.class);
//        JsonNode root = objectMapper.readTree(personResultAsJsonStr);
    //    HttpEntity<String> request =  this.restTemplate.postForObject("http://localhost:" + port + "/v1/pastry",pastry,String.class);

        Pastry[] response = this.restTemplate.getForObject("http://localhost:" + port + "/v1/pastry",
                Pastry[].class);
        assertEquals(2,response.length);
//        assertEquals("Cookie",response.get(0).generateName());
//        assertEquals("Cupcake",response.get(0).generateName());
    }




}
