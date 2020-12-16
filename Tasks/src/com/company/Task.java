package com.company;

import java.time.LocalDate;

public class Task {
    public String title;
    public String description;
    public boolean isDone;
    public LocalDate dueDate;

    public Task(String title, String description, boolean isDone, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.dueDate = dueDate;
    }
}
