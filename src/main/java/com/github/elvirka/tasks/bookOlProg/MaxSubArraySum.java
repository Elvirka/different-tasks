package com.github.elvirka.tasks.bookOlProg;

import java.util.Arrays;

public class MaxSubArraySum {

    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 2, 4, -3, 5, 2, -5, 2};
        int[] arr = new int[]{-1, 2, 4, -3, 5, 2, -5, 58};
        myWay(arr);
        bookWay(arr);
    }
    static void bookWay(int[] arr){
        int n = arr.length;
        int sum = 0, best = 0;
        for (int a = 0; a < n; a++) {
            sum = Math.max(arr[a], sum + arr[a]);
            best = Math.max(best,sum);
        }
        System.out.println(best);
    }

    static void myWay(int[] arr){
        int n = arr.length;
        int best = Arrays.stream(arr).sum();
        int sum = best;
        for (int a = 0; a < n; a++) {
            sum -= arr[a];
            if (sum > best) {
                best = sum;
            }
        }
        sum = best;
        for (int b = n - 1; b >= 0; b--) {
            sum -= arr[b];
            if (sum > best) {
                best = sum;
            }
        }
        System.out.println(best);
    }

}
