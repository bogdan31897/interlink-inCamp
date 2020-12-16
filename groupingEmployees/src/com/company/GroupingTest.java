package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GroupingTest {

    @Test
    public void groupingTest__DateGrouping() {
        Grouping group = new Grouping();
        Assertions.assertEquals(group.grouping(0).size(), 1);
        Assertions.assertEquals(group.grouping(2).size(), 3);

    }

    @Test
    public void groupingTest__WhenGroupNotFound() {
        Grouping group = new Grouping();
        group.add(new Employee("Ваня Петров", LocalDate.of(1997,1,31)));
        Assertions.assertEquals(group.grouping(0).get(YearMonth.of(2020,12)).size(), 0);
    }

    @Test
    public void groupingTest__WhenOneGroupFound() {
        Grouping group = new Grouping();
        group.add(new Employee("Ваня Петров", LocalDate.of(1997,12,31)));
        Assertions.assertEquals(group.grouping(0).get(YearMonth.of(2020,12)).size(), 1);
    }
    @Test
    public void groupingTest__WhenSomeGroupFound() {
        Grouping group = new Grouping();
        group.add(new Employee("Ваня Петров", LocalDate.of(1997,12,31)));
        group.add(new Employee("Ваня Иванов", LocalDate.of(1786,1,25)));
        group.add(new Employee("Ваня Богданов", LocalDate.of(1997,1,31)));
        group.add(new Employee("Ваня Ваненко", LocalDate.of(1997,12,31)));

        int firstGroup = group.grouping(1).get(YearMonth.of(2020,12)).size();
        int secondGroup = group.grouping(1).get(YearMonth.of(2020,12)).size();

        Assertions.assertEquals(firstGroup + secondGroup, 4);
    }
}