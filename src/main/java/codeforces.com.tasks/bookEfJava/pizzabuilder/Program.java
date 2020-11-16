package codeforces.com.tasks.bookEfJava.pizzabuilder;

import static codeforces.com.tasks.bookEfJava.pizzabuilder.NyPizza.Size.SMALL;
import static codeforces.com.tasks.bookEfJava.pizzabuilder.Pizza.Topping.ONION;
import static codeforces.com.tasks.bookEfJava.pizzabuilder.Pizza.Topping.SAUSAGE;

public class Program {

    public static void main(String[] args) {
        NyPizza pizza1 = new NyPizza.Builder(SMALL)
            .addTopping(ONION).build();
        System.out.println(pizza1.getSize());
        System.out.println(pizza1.toppings);

        Calzone pizza2 = new Calzone.Builder().sauceInside()
            .addTopping(SAUSAGE).build();
        System.out.println(pizza2.getSauceLocation());
        System.out.println(pizza2.toppings);
    }
}
