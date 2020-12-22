package com.todo.list.resources;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Tasks {

    private static final AtomicLong counter = new AtomicLong();
    private static final HashMap<Long,Task> tasks = new HashMap<>();

    public static Task add(Task task) {
        tasks.put(counter.incrementAndGet(), task);
        return task;
    }
    public static HashMap<Long,Task> getTasks() {
        return tasks;
    }
    public static Task update(long id, Task task) {
        tasks.put(id, task);
        return task;
    }
    public static Task remove(long id) {
        return tasks.remove(id);
    }


}
