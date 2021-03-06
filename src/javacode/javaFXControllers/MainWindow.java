package javacode.javaFXControllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javacode.configs.SpringConfig;
import javacode.entity.Task;
import javacode.service.TaskService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWindow {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField taskAuthorField;

        @FXML
        private Button newTaskButton;

        @FXML
        private TextField taskAssigneeField;

        @FXML
        private TextField taskStateField;

        @FXML
        private Button taskReadButton;

        @FXML
        private TextField taskIdField;

        @FXML
        private TextField taskNameField;

        @FXML
        void initialize() {

            newTaskButton.setOnAction(event -> {

                Task task = new Task(taskNameField.getText(), taskAuthorField.getText(),
                        taskAssigneeField.getText(), taskStateField.getText());
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
                TaskService taskService = context.getBean(TaskService.class);
                taskService.add(task);

                task.setName(taskNameField.getText());
                task.setAuthor(taskAuthorField.getText());
                task.setAssignee(taskAssigneeField.getText());
                task.setState(taskStateField.getText());


            });

            taskReadButton.setOnAction(event -> {

                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
                TaskService taskService = context.getBean(TaskService.class);
                try {
                    Task task = taskService.getById(Integer.parseInt(taskIdField.getText()));
                    taskNameField.setText(task.getName());
                    taskAuthorField.setText(task.getAuthor());
                    taskAssigneeField.setText(task.getAssignee());
                    taskStateField.setText(task.getState());
                } catch (Exception e){
                    System.out.println("Exception in MainWindow, getTask");
                }


            });


        }

        public void clearTextFields(){
            taskIdField.clear();
            taskNameField.clear();
            taskAuthorField.clear();
            taskAssigneeField.clear();
            taskStateField.clear();
        }
    }


