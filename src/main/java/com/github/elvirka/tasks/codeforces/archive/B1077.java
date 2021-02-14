package com.github.elvirka.tasks.codeforces.archive;

import java.util.Scanner;

public class B1077 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var number = sc.nextInt();
        var flats = new int[number];
        for (var i=0; i < number; i++){
            flats[i] = sc.nextInt();
        }
        var k = 0;
        for (var i=1; i < number-1; i++){
            if (flats[i] == 0
                && flats[i + 1] == 1
                && flats[i - 1] == 1
            ){
                k++;
                flats[i + 1] = 0;
            }
        }
        System.out.println(k);
    }

}
