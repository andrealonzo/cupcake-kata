package org.aalonzo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//@TestPropertySource(properties = {
//        "spring.jpa.hibernate.ddl-auto=create-drop",
//        "spring.flyway.enabled=false"
//})
public class OrderRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

//    @Disabled
//    @Test
//    void orderRepoIsEmpty() {
//        // when
//        long count = orderRepository.count();
//
//        // then
//        assertEquals(0, count);
//    }
//    @Test
//    public void whenFindByName_thenReturnEmployee() {
//        // given
//        Order order = new Order();
//        entityManager.persist(order);
//        entityManager.flush();
//
//        // when
//        long count = orderRepository.count();
//
//        // then
//        assertEquals(0, count);
//    }
}
