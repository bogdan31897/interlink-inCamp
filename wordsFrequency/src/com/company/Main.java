package com.company;

import java.util.HashMap;
import java.util.Locale;

public class Main {

    public static HashMap<String, Integer> wordFrequency(String string) {
        string = string.toLowerCase(Locale.ROOT);
        String[] words = string.split("\\s+");
        HashMap<String, Integer> wordsMap = new HashMap<>();

        for(String word: words) {
            if (wordsMap.containsKey(word)) wordsMap.replace(word, wordsMap.get(word) + 1);
            else wordsMap.put(word, 1);
        }
        return wordsMap;
    }

    public static void main(String[] args) {

        String testLine = "hello World my name is bogdan is";
        HashMap<String, Integer> wordsCollection = wordFrequency(testLine);

        System.out.printf("TestLine: %s\n\n", testLine);
        wordsCollection.forEach((k, v) -> System.out.printf("Word: %s: %d \n", k, v));

    }
}
