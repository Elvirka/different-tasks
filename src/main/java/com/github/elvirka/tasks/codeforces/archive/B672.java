package com.github.elvirka.tasks.codeforces.archive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B672 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var number = sc.nextInt(); sc.nextLine();
        var str = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < number; i++) {
            var sym = Character.valueOf(str.charAt(i));
            map.merge(sym, 1, Integer::sum);
        }
        int symbolsToChange = 0;
        for (var value : map.values()) {
            if (value > 1) {
                symbolsToChange += value - 1;
            }
            if (symbolsToChange > 26 - map.values().size()){
                symbolsToChange = -1;
                break;
            }
        }
        System.out.println(symbolsToChange);
    }
}
