package pl.sdacademy;

import pl.sdacademy.annotations.MyClassAnnotation;
import pl.sdacademy.annotations.MyFieldAnnotation;
import pl.sdacademy.annotations.MyMethodAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest {
    public static void main(String[] args) {

        Class<User> userObj = User.class;
        //adnotacje klasy
        if(userObj.isAnnotationPresent(MyClassAnnotation.class)) {
            MyClassAnnotation myClassAnnotation = (MyClassAnnotation) userObj.getAnnotation(MyClassAnnotation.class);
            System.out.println("Author of the class " + userObj.getSimpleName() + " is " + myClassAnnotation.author());
        }

        //adnotacje metody
        for(Method method : userObj.getDeclaredMethods()) {
            if(method.isAnnotationPresent(MyMethodAnnotation.class)) {
                MyMethodAnnotation myMethodAnnotation = (MyMethodAnnotation) method.getAnnotation(MyMethodAnnotation.class);
                System.out.println("Method " + method.getName() + " is depracated: "
                                + myMethodAnnotation.isDeprecated() + ", in polish it is called: "
                                + myMethodAnnotation.inPolish());
            }
            else {
                System.out.println("Method " + method.getName() + " does not have any annotations");
            }
        }

        //adnotacje pól
        for(Field field : userObj.getDeclaredFields()) {
            if(field.isAnnotationPresent(MyFieldAnnotation.class)) {
                MyFieldAnnotation myFieldAnnotation = (MyFieldAnnotation) field.getAnnotation(MyFieldAnnotation.class);
                System.out.println("Field " + field.getName() + " is in database: " + myFieldAnnotation.isInDatabase());
            }
            else {
                System.out.println("FIeld " + field.getName() + " does not have any annotations");
            }
        }
    }
}
