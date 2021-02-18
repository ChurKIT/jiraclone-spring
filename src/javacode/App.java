package javacode;

import javacode.configs.SpringConfig;
import javacode.task.TaskDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App extends Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TaskDAO taskDAO = context.getBean("taskDAO", TaskDAO.class);
        launch(args);
        taskDAO.getTasksFromDB();


        taskDAO.saveTasksInDB();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/mainWindow.fxml"));
        stage.setTitle("JiraClone by ChurKIT");
        stage.setScene(new Scene(root, 800, 400));
        stage.show();
    }
}
