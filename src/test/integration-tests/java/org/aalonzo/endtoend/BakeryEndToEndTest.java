package org.aalonzo.endtoend;

import org.aalonzo.controller.PastryController;
import org.aalonzo.controller.ToppingController;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.ToppingRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BakeryEndToEndTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PastryController controller;
    @Autowired
    private ToppingController toppingController;
    @Autowired
    private BakeryRepository bakeryRepository;
    @Autowired
    private PastryRepository pastryRepository;
    @Autowired
    private ToppingRepository toppingRepository;


    @Test
    public void contextLoads() {
        assertNotNull(controller);
    }
    @Test
    @Disabled
    public void endpointExists() {
        String url = "http://localhost:" + port + "/v1/pastry";
        System.out.println("url: " + url);

        assertThat(this.restTemplate.getForObject("http://localhost:" + port,
                String.class)).contains("Hello");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port+ "/v1/hi",
                String.class)).contains("Hello");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port+ "/v1/pastry",
                String.class)).contains("[]");
    }
    @Sql({"/data.sql2"})
    @Test
    @Disabled
    public void customerCanSeeAllPastriesThatCanBePurchased(){
        List<Pastry> response = this.restTemplate.getForObject("http://localhost:" + port + "/v1/pastry",
                List.class);
        assertEquals(2,response.size());
        assertEquals("Cookie",response.get(0).getName());
        assertEquals("Cupcake",response.get(0).getName());
    }




}
