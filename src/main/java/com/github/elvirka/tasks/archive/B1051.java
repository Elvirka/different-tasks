package com.github.elvirka.tasks.archive;

import java.util.Scanner;

public class B1051 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        var l = sc.nextLong();
        var r = sc.nextLong();
        System.out.println("YES");
        for (long i = l; i < r; i += 2) {
            System.out.println(i + " " + (i+1));
        }
    }
}
