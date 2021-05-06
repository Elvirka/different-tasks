package com.github.elvirka.tasks;

public class Program {

    public static void main(String[] args) {
        int n = 10; // O(time complexity of the called function)
        int sum = 0; //O(1)
        double pie = 3.14; //O(1)

        for (int var = n; var >= 1; var = var - 3) {
            System.out.println("Pie: " + pie);
            for (int j = n; j >= 0; j = j - 1) {
                sum++;
                System.out.println("Sum: " + sum);//O(1)
            }
        }
    }
}