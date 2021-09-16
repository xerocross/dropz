package com.adamfgcross.dropz.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.

public class DropTest {


    @Test
    void canCreateDropText() {
        Drop drop = new Drop();
        drop.setText("apple");
        assertEquals("apple", drop.getText());
    }
}
