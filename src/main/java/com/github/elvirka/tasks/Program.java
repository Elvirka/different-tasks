package com.github.elvirka.tasks;


public class Program extends Thread {
    @Override
    public void run() {
        System.out.println("run");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            new Program().start();
            System.out.println("main");
        } catch (RuntimeException e) {
            System.out.println("catch");
        }
    }
}