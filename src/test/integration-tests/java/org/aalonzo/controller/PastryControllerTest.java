package org.aalonzo.controller;

import org.aalonzo.domain.Pastry;
import org.aalonzo.repository.PastryRepository;
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
public class PastryControllerTest {

    @Autowired
    private PastryRepository repository;
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
        addAndVerifyPastry(new Pastry("Cookie", 2.0));
    }

    @Test
    public void addCupcakeAndShow() throws Exception {
        addAndVerifyPastry(new Pastry("Cupcake", 1.0));
    }

    @Test
    public void deleteAllPastries() throws Exception {
        Pastry pastry = new Pastry("Cupcake", 1.0);

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
        Pastry pastry = new Pastry("Cupcake", 1.0);

        repository.save(pastry);
        assertEquals(1, repository.count());

        this.mockMvc.perform(delete("/v1/pastry/delete/").param("id", pastry.getId().toString()));

        assertEquals(0, repository.count());
    }

    private void addAndVerifyPastry(Pastry pastry) throws Exception {
        assertEquals(0, repository.count());
        this.mockMvc.perform(post("/v1/pastry").param("type", pastry.getName()));
        assertEquals(1, repository.count());
    }
}
