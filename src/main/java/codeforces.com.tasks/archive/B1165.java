package codeforces.com.tasks.archive;

import java.util.Scanner;
import java.util.Arrays;

public class B1165 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Integer[] contests = new Integer[number];
        for (int i = 0; i < number; i++) {
            contests[i] = sc.nextInt();
        }
        Arrays.sort(contests);
        int dayNum = 1;
        for (int i = 0; i < number; i++) {
            if (contests[i] < dayNum) continue;
            dayNum++;
        }
        System.out.println(dayNum - 1);
    }
}
