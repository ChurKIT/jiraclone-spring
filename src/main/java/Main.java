import configs.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import user.User;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        User testUser = context.getBean("user", User.class);
    }
}
