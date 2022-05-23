package org.aalonzo.controller;

import org.aalonzo.domain.Topping;
import org.aalonzo.repository.ToppingRepository;
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
public class ToppingControllerIntegrationTest {

    @Autowired
    private ToppingRepository repository;
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
    public void addChocolateAndShow() throws Exception {
        addAndVerifyTopping(new Topping("Chocolate", 2.0));
    }

    @Test
    public void addNutsAndShow() throws Exception {
        addAndVerifyTopping(new Topping("Nuts", 1.0));
    }

    @Test
    public void deleteAllToppings() throws Exception {
        Topping topping = new Topping("Nuts", 1.0);

        //add topping
        repository.save(topping);
        assertEquals(1, repository.count());

        //delete all cupcakes
        this.mockMvc.perform(delete("/v1/topping/delete/all"));

        //checks everything is empty
        assertEquals(0, repository.count());
    }

    @Test
    public void deleteOneTopping() throws Exception {
        Topping topping = new Topping("Nuts", 1.0);

        repository.save(topping);
        assertEquals(1, repository.count());

        this.mockMvc.perform(delete("/v1/topping/delete/").param("id", topping.getId().toString()));

        assertEquals(0, repository.count());
    }

    private void addAndVerifyTopping(Topping topping) throws Exception {
        assertEquals(0, repository.count());
        this.mockMvc.perform(post("/v1/topping")
                .param("name", topping.getName())
                .param("price", String.valueOf(topping.getPrice())));
        assertEquals(1, repository.count());
    }
}
