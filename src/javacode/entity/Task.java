package javacode.entity;


import javax.persistence.*;


@Entity
@Table (name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "state")
    private String state;


    public Task(String taskName, String taskAuthor, String taskAssignee, String taskState) {
        this.name = taskName;
        this.author = taskAuthor;
        this.assignee = taskAssignee;
        this.state = taskState;
    }

    public Task() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", assignee='" + assignee + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
