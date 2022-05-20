package org.aalonzo.controller;

import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PastryControllerTest {
    @Autowired
    private PastryController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }


}
