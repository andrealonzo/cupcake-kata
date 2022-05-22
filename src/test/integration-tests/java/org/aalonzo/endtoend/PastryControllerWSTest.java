package org.aalonzo.endtoend;

import org.aalonzo.controller.PastryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PastryControllerWSTest {
    @Autowired
    private PastryController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
