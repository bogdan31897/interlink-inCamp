package com.company;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {



    @Test
    public void Create__Game__When__Fieldsize__Out__Of_Range() {
        int fieldSize = 3;
        Game game = new Game(fieldSize);
        Assertions.assertTrue(3 <= fieldSize && fieldSize <= 9);
    }


}