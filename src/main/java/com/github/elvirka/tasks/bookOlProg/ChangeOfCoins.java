package com.github.elvirka.tasks.bookOlProg;

import static java.lang.Math.min;

public class ChangeOfCoins {

    private static boolean[] ready = new boolean[20];
    private static int[] values = new int[20];
    private static int[] usedCoins = new int[20];
    private static int[] waysToChange = new int[20];

    public static void main(String[] args) {
        int[] coins = new int[]{1, 3, 4};
        int[] rCoins = new int[]{4, 3, 1};
        int sum = 6;
        int number = greedyCount(sum, rCoins);
        int number1 = recursiveCount(sum, coins);
        int number2 = iterCount(sum, coins);
        System.out.println(number);
        System.out.println(number1);
        System.out.println(number2);

        System.out.println("---------------------");
        int number3 = iterCountWithCoins(sum, coins);
        System.out.println(number3);
        printCoins(sum);

        System.out.println("---------------------");
        int number4 = iterCountWaysToChange(5, coins);
        System.out.println(number4);
    }

    public static int recursiveCount(int sum, int[] coins) {
        if (sum < 0) return Integer.MAX_VALUE - 1;
        if (sum == 0) return 0;
        if (ready[sum]) return values[sum];
        int best = Integer.MAX_VALUE;
        for (var c : coins) {
            best = min(best, recursiveCount(sum - c, coins) + 1);
        }
        ready[sum] = true;
        values[sum] = best;
        return best;
    }

    public static int iterCountWaysToChange(int sum, int[] coins) {
        waysToChange[0] = 1;
        for (int i = 1; i <= sum ; i++) {
            for (var c : coins) {
                if (i - c >= 0) {
                    waysToChange[i] += waysToChange[i - c];
                }
            }
        }
        return waysToChange[sum];
    }

    public static int iterCountWithCoins(int sum, int[] coins) {
        values[0] = 0;
        for (int i = 1; i <= sum ; i++) {
            values[i] = Integer.MAX_VALUE - 1;
            for (var c : coins) {
                if (i - c >= 0 && values[i - c] + 1 < values[i]) {
                    values[i] = values[i - c] + 1;
                    usedCoins[i] = c;
                }
            }
        }
        return values[sum];
    }

    public static void printCoins(int sum) {
        var coins = new StringBuilder();
        while (sum > 0) {
            coins.append(usedCoins[sum] + " ");
            sum -= usedCoins[sum];
        }
        System.out.println(coins.toString().trim());
    }

    public static int iterCount(int sum, int[] coins) {
        values[0] = 0;
        for (int i = 1; i <= sum ; i++) {
            values[i] = Integer.MAX_VALUE - 1;
            for (var c : coins) {
                if (i - c >= 0) {
                    values[i] = min(values[i], values[i - c] + 1);
                }
            }
        }
        return values[sum];
    }

    //not correct
    public static int greedyCount(int sum, int[] coins) {
        int allNumber = 0;
        for (int coin : coins) {
            int number = sum / coin;
            sum %= coin;
            allNumber += number;
            if (number > 0)
                System.out.println( coin + " " + number);
        }
        return allNumber;
    }
}
