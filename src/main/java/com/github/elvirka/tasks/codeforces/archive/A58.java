package com.github.elvirka.tasks.codeforces.archive;

import java.util.Scanner;

public class A58 {

    private static char[] hello = new char[]{'h','e','l','l','o'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int helloIndex = 0;
        var letters = sc.nextLine();
        for (char letter : letters.toCharArray()) {
            if (letter == hello[helloIndex]) {
                helloIndex++;
                if (helloIndex == hello.length) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
