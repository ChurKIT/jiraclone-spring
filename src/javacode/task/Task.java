package javacode.task;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Scope("prototype")
public class Task {

    private AtomicInteger taskId;
    private String taskName;
    private String taskAuthor;
    private String taskAssignee;
    private String taskState;

    public Task(String taskName, String taskAuthor, String taskAssignee, String taskState) {
        taskId.getAndIncrement();
        this.taskName = taskName;
        this.taskAuthor = taskAuthor;
        this.taskAssignee = taskAssignee;
        this.taskState = taskState;
    }

    public int getTaskId() {
        return taskId.get();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskAuthor() {
        return taskAuthor;
    }

    public void setTaskAuthor(String taskAuthor) {
        this.taskAuthor = taskAuthor;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }
}
