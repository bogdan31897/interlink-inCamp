package com.company;

import java.time.LocalDate;


public class Main {


    public static void main(String[] args) {


        Grouping group = new Grouping();

        group.add(new Employee("Ваня Петров", LocalDate.of(1997,7,31)));
        group.add(new Employee("Николай Иванов", LocalDate.of(1995,2,13)));
        group.add(new Employee("Олег Домовой", LocalDate.of(1970,1,25)));
        group.add(new Employee("Петя Васильев", LocalDate.of(1999,12,1)));
        group.add(new Employee("Ваня Чистый", LocalDate.of(2000,1,7)));
        group.add(new Employee("Владисла Андреев", LocalDate.of(2002,12,22)));
        group.add(new Employee("Василий Иваненко", LocalDate.of(1976,2,17)));
        group.add(new Employee("Олександр Олександрович", LocalDate.of(1996,12,19)));
        group.add(new Employee("Богдан Ковтун", LocalDate.of(2002,12,31)));

        group.printGroups(group.grouping(2));











    }
}
