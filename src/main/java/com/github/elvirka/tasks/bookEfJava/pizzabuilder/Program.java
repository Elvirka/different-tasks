package com.github.elvirka.tasks.bookEfJava.pizzabuilder;

public class Program {

    public static void main(String[] args) {
        NyPizza pizza1 = new NyPizza.Builder(NyPizza.Size.SMALL)
            .addTopping(Pizza.Topping.ONION).build();
        System.out.println(pizza1.getSize());
        System.out.println(pizza1.toppings);

        Calzone pizza2 = new Calzone.Builder().sauceInside()
            .addTopping(Pizza.Topping.SAUSAGE).build();
        System.out.println(pizza2.getSauceLocation());
        System.out.println(pizza2.toppings);
    }
}
