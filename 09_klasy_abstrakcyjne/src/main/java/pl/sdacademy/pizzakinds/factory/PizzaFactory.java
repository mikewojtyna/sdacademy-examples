package pl.sdacademy.pizzakinds.factory;


import pl.sdacademy.pizzakinds.AmericanPizza;
import pl.sdacademy.pizzakinds.ItalianPizza;
import pl.sdacademy.pizzakinds.Pizza;

public class PizzaFactory { //banalna/naiwna implementacja wzorca fabryka

    public Pizza wloskaKlasycznaPizza() {
        return new ItalianPizza(35, 2, "Mozarella", "Bazylia");
    }

    public Pizza wloskaBezSeraPizza() {
        return new ItalianPizza(35,2,"Brak", "Oregano");
    }

    public Pizza amerykanskaBardzoGrubaPizza() {
        return new AmericanPizza(50,5,4);
    }

    public Pizza amerykanskaNormalnaPizza() {
        return new AmericanPizza(50,5,2);
    }


}
