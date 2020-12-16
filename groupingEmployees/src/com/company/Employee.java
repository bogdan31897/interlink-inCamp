package com.company;

import java.time.LocalDate;
import java.time.Period;

public class Employee implements Comparable<Employee> {

    private final String name;
    private final LocalDate birthday;

    Employee(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;

    }

    public LocalDate getBirthday() {
        return birthday;
    }
    private int getAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }


    private static String pluramWords(int countWords) {
        return correctString(countWords, "год","года", "лет");
    }
    private static String correctString(int countWords, String one, String few, String many) {
        var newWord = countWords + " ";
        int lastDegit = countWords % 10;
        int lastTwoDegits = countWords % 100;

        if (lastTwoDegits > 10 & lastTwoDegits < 20) {
            newWord += many;
        } else {
            if (lastDegit == 1) newWord += one;
            else if(lastDegit > 1 & lastDegit <= 4) newWord += few;
            else if(lastDegit > 4 & lastDegit <= 9 | lastDegit == 0) newWord += many;
        }

        return newWord;
    }

    @Override
    public String toString() {
        return String.format("(%d) - %s (%s)",this.birthday.getDayOfMonth(), this.name, pluramWords(this.getAge()+1));
    }

    @Override
    public int compareTo(Employee o) {
        return this.birthday.getDayOfMonth() - o.getBirthday().getDayOfMonth();
    }
}
    

