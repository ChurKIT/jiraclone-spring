package javacode.task;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope("prototype")
public class Task {

    private AtomicInteger id;
    private String name;
    private String author;
    private String assignee;
    private String state;

    public Task(String taskName, String taskAuthor, String taskAssignee, String taskState) {
        id.getAndIncrement();
        this.name = taskName;
        this.author = taskAuthor;
        this.assignee = taskAssignee;
        this.state = taskState;
    }

    public Task() {
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
