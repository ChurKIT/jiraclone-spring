package javacode.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("prototype")
public class User {

    private String login;
    private char[] password;
    private String firstName;
    private String lastName;
    private UserRole role;
    private static boolean isLogIn = false;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public static boolean isIsLogIn() {
        return isLogIn;
    }

    public static void setIsLogIn(boolean isLogIn) {
        User.isLogIn = isLogIn;
    }


}
