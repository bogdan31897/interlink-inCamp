package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class TestWordFrequency {

    @Test
    public void Test_WordFrequency_WhenWordsNoRepeat() {
        String testLine = "Hello world";
        HashMap<String, Integer> wordsCollection = Main.wordFrequency(testLine);

        StringBuilder st = new StringBuilder();
        wordsCollection.forEach((k,v) -> st.append(String.format("%s: %d; ",k,v)));
        Assertions.assertEquals("world: 1; hello: 1; ", st.toString());
    }

    @Test
    public void Test_WordFrequency_WhenWordsRepeat() {
        String testLine = "10 10 is is in";
        HashMap<String, Integer> wordsCollection = Main.wordFrequency(testLine);

        StringBuilder st = new StringBuilder();
        wordsCollection.forEach((k,v) -> st.append(String.format("%s: %d; ",k,v)));
        Assertions.assertEquals("in: 1; is: 2; 10: 2; ", st.toString());
    }
}