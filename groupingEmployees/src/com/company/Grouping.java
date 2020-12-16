package com.company;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Grouping {

    ArrayList<Employee> Employees = new ArrayList<>();

    public void add(Employee employee) {
        Employees.add(employee);
    }

    public HashMap<YearMonth, ArrayList<Employee>> grouping(int horizonPlanning) {
        HashMap<YearMonth, ArrayList<Employee>> employeesGroupingMap = new HashMap<>();

        for (int i = 0; i < horizonPlanning+1; i++) {
            LocalDate currentDateGroup = LocalDate.now().plusMonths(i);
            ArrayList<Employee> currentEmployees = new ArrayList<>();
            Employees.forEach(employee -> {
                if(employee.getBirthday().getMonth() == currentDateGroup.getMonth()) currentEmployees.add(employee);
            });
            Collections.sort(currentEmployees);
            employeesGroupingMap.put(YearMonth.of(currentDateGroup.getYear(), currentDateGroup.getMonth()),currentEmployees);
        }
        return employeesGroupingMap;
    }
    public void printGroups(HashMap<YearMonth, ArrayList<Employee>> map) {

        map.forEach((yearMonth, employees) -> {
            System.out.printf("\n%s %s\n", Months.values()[yearMonth.getMonthValue()-1], yearMonth.getYear());
            employees.forEach(System.out::println);
        });

    }

}
