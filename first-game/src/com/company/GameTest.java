package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


//    @BeforeAll
//    public static void createField() {
//    }

    @Test
    public void Create__Game__When__Fieldsize__Out__Of_Range() {
        int fieldSize = 3;
        Game game = new Game(fieldSize);
        Assertions.assertTrue(3 <= fieldSize && fieldSize <= 9);
    }


}