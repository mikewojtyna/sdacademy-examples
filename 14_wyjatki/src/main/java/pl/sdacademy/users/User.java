package pl.sdacademy.users;


import pl.sdacademy.exception.BadEmailException;

public class User {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    //nasza klasa posiada dwa konstruktory - jeden domyślny (i bezpieczny)...
    public User() {
    }

    // ... a drugi rzuca wyjątkiem!
    public User(String name, String email) throws BadEmailException {
        if (!isEmailValid(email)) {
            throw new BadEmailException("Adres email jest niepoprawny!");
        }
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws BadEmailException{ //poniważ nasza metoda setEmail może rzucić wyjątek (dziedziczący z klasy Exception), musimy jawnie zadeklarować, że ta metoda może taki wyjątek obsłużyć. Inaczej byłoby, gdyby mogłą rzucić RuntimeExcetpion.
        if (!isEmailValid(email)) {
            throw new BadEmailException("Adres email jest niepoprawny!");
        }
        this.email = email;
    }

    private boolean isEmailValid(String email) { //kod walidujący (sprawdzający poprawność) adres email umieszczamy w metodzie prywatnej - tak jest czyściej
        return email.contains("@"); //jeśli adres email zawiera znak '@', metoda zwróci prawdę. W przeciwnym razie zwróci fałsz
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}
