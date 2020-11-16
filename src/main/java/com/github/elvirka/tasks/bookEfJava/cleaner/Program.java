package com.github.elvirka.tasks.bookEfJava.cleaner;

public class Program {

    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("GoodBye!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------");
        new Room(99);
        System.gc();
        System.out.println("Peace out");
    }

}
