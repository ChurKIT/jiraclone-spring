package javacode.service;

import javacode.dao.TaskDAOImpl;
import javacode.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDAOImpl taskDAOImpl;

    public void add(Task task){
        taskDAOImpl.add(task);
    }

    public Task getById(int id){
        Task task = taskDAOImpl.getOne(id);
        return task;
    }
}
