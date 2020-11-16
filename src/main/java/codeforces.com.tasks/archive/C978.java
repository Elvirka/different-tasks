package codeforces.com.tasks.archive;

import java.util.Scanner;

public class C978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int houses = sc.nextInt(), letters = sc.nextInt();
        long[] flatsInHouse = new long[houses];
        for (int i = 0; i < houses; i++)
            flatsInHouse[i] = sc.nextLong();

        long flatsSum = 0;
        int houseNumber = 0;
        for (int i = 0; i < letters; i++) {
            long flat = sc.nextLong();
            while (flatsSum + flatsInHouse[houseNumber] < flat)
                flatsSum += flatsInHouse[houseNumber++];
            System.out.println(houseNumber + 1 + " " + (flat - flatsSum));
        }
    }
}
