package com.github.elvirka.tasks.hakerrankJava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IterateOverRanges {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] arr = new long[n + 1];

        int maxB1 = 0;
        int minA = Integer.MAX_VALUE;
        String[] query; int a = 0; int b = 0; long k = 0L; int b1 = 0;
        for (int i = 0; i < m; i++) {
            query = scanner.nextLine().split(" ");
            a = Integer.parseInt(query[0]);
            b = Integer.parseInt(query[1]);
            k = Long.parseLong(query[2]);
            arr[a] = arr[a] + k;
            b1 = b + 1;
            maxB1 = Math.max(maxB1, b1);
            minA = Math.min(minA, a);
            if (b1 <= n) arr[b1] = arr[b1] - k;
        }

        long max = 0L; long sum = 0L;
        for (int i = minA; i < maxB1; i++) {
            if (arr[i] == 0L) continue;
            sum += arr[i];
            max = Math.max(max, sum);
        }

        bufferedWriter.write(String.valueOf(max));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

