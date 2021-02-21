package javacode.dao;

import javacode.entity.Task;

import java.util.List;

public interface TaskDAO {

    public void add(Task task);
    public List<Task> getAll();
    public Task getOne(int id);

}
