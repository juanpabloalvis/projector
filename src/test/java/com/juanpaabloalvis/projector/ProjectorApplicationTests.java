package com.juanpaabloalvis.projector;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles(value = "test")
class ProjectorApplicationTests {

    @Test
    void contextLoads() {
        String a = "jklj";
        String b = "jklj";
        System.out.println("***************TEST");
        assertEquals(a, b);
    }

}
