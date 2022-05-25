package org.aalonzo.controller;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.PastryTypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PastryTypeControllerTest {


    @Autowired
    private PastryRepository repository;
    @Autowired
    private PastryTypeRepository pastryTypeRepository;
    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    public void clearRepository() {
        repository.deleteAll();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }


    @Test
    public void addCookieAndShow() throws Exception {
        addAndVerifyPastry(new Pastry(new PastryType("Cookie", 2.0)));
    }

    @Test
    public void addCupcakeAndShow() throws Exception {

        PastryType pastryType = pastryTypeRepository.save(new PastryType("Cupcake", 1.0));
        addAndVerifyPastry(new Pastry(pastryType));
    }

    @Test
    public void deleteAllPastries() throws Exception {

        PastryType pastryType = pastryTypeRepository.save(new PastryType("Cupcake", 1.0));
        Pastry pastry = new Pastry(pastryType);

        //add pastry
        repository.save(pastry);
        assertEquals(1, repository.count());

        //delete all cupcakes
        this.mockMvc.perform(delete("/v1/pastry/delete/all"));

        //checks everything is empty
        assertEquals(0, repository.count());
    }

    @Test
    public void deleteOnePastry() throws Exception {
        PastryType pastryType = pastryTypeRepository.save(new PastryType("Cupcake", 1.0));
        Pastry pastry = new Pastry(pastryType);

        repository.save(pastry);
        assertEquals(1, repository.count());

        this.mockMvc.perform(delete("/v1/pastry/delete/").param("id", pastry.getId().toString()));

        assertEquals(0, repository.count());
    }

    private void addAndVerifyPastry(Pastry pastry) throws Exception {
        assertEquals(0, repository.count());
        this.mockMvc.perform(post("/v1/pastry")
                .param("name", pastry.getPastryType().getName())
                .param("price", String.valueOf(pastry.getPastryType().getPrice())));
        assertEquals(1, repository.count());
    }
}
