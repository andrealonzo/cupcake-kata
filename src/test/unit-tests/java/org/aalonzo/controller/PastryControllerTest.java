package org.aalonzo.controller;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PastryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }


    @Test
    public void addCookieAndShow() throws Exception {
        this.mockMvc.perform(post("/v1/pastry"));
        Pastry pastry = new Cookie();
        this.mockMvc.perform(get("/v1/pastry")).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value(pastry.getName()));

    }
    @Test
    public void addCupcakeAndShow() throws Exception {
        this.mockMvc.perform(post("/v1/pastry"));
        Pastry pastry = new Cupcake();
        this.mockMvc.perform(get("/v1/pastry")).andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value(pastry.getName()));

//        this.mockMvc.perform(get("/v1/pastry")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().json("[]"));
    }
}
