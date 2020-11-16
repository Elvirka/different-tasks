package com.github.elvirka.tasks.bookOlProg;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.toBinaryString;

public class BitSetByInt {

    public static void main(String[] args) {
        // {1,3,4,8}
        int x = (1<<1) | (1<<3) | (1<<4) | (1<<8);
        //{3,6,8,9}
        int y = (1<<3) | (1<<6) | (1<<8) | (1<<9);
        System.out.println(toBinaryString(x));
        System.out.println(toBinaryString(y));
        System.out.println(toBinaryString(x | y));
        System.out.println(toBinaryString(x & y));
        System.out.println(toBinaryString(~x));
        System.out.println(toBinaryString(x & ~y));
        System.out.println(bitCount(x));
        System.out.println("-------------------");
        int n = 5;
        for (int b = 0; b < (1 << n); b++) {
            System.out.println(toBinaryString(b));
        }
        System.out.println("-------------------");
        for (int b = 0; b < (1 << n); b++) {
            if(bitCount(b) == 4)
                System.out.println(toBinaryString(b));
        }
        System.out.println("-------------------");
        System.out.println(toBinaryString(x));
        System.out.println("-------------------");
        int b = 0;
        do {
            System.out.println(toBinaryString(b));
        } while ((b = (b - x) & x) != 0);

    }
}
