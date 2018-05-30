package pl.sdacademy;

import pl.sdacademy.annotations.MyClassAnnotation;
import pl.sdacademy.annotations.MyFieldAnnotation;
import pl.sdacademy.annotations.MyMethodAnnotation;

@MyClassAnnotation(author = "Paweł")
public class User {

    @MyFieldAnnotation(isInDatabase = true)
    private String name;

    @MyFieldAnnotation
    private String lastname;

    @MyFieldAnnotation(isInDatabase = false)
    private int age;

    private boolean isAdmin;

    public User(String name, String lastname, int age, boolean isAdmin) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    @MyMethodAnnotation(isDeprecated = false, inPolish = "dodajWiek")
    public void addAge(int agesToAdd) {
        this.age += agesToAdd;
    }
}
