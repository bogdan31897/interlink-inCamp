package com.todo.list.resources;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class Task {

    private final String title;
    private final String description;
    private final boolean isDone;
    private final LocalDate dueDate;

    public Task(long id, String title, String description, boolean isDone, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

}