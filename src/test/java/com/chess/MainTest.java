package com.chess;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;


public class MainTest {

    @Test
    void testMainExecution() {
        // Verificamos que la ejecución del método main no lanza ninguna excepción
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }

    @Test
    void testMain() {
        Main main;
        main = new Main();
    }

}