package com.company;

import java.time.LocalDate;

public class Main {

    public static class Tasks {

        public int CountTasks = 0;

        public Tasks() {};
        public void addTask(Task task) {
            this.CountTasks ++;
            printTask(task);
        }
        public void printTask(Task task) {
            System.out.println(String.format("\n[%d] Title: %s\n\tDescription: %s\n\tStatus: %s\n\tDate: %s", this.CountTasks, task.title, task.description, task.isDone, task.dueDate));
        }
    }

    public static void main(String[] args) {

        Tasks monday = new Tasks();
        monday.addTask(new Task("Read information", "Read and leard text", false, LocalDate.of(2020,12,31)));
        monday.addTask(new Task("Read information", "Read and leard text", false, LocalDate.of(2020,12,31)));
    }

}
