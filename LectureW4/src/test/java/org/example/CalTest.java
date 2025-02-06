package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalTest {
    Cal cal = new Cal();


    @Test
    void sum() {
        assertEquals(12, cal.sum(10, 2));
    }

    @Test
    void sub() {
        assertEquals(8, cal.sub(10, 2));
    }

    @Test
    void mul() {
        assertEquals(20, cal.mul(10, 2));
    }

    @Test
    void div() {
        assertEquals(5, cal.div(10, 2));
    }
}