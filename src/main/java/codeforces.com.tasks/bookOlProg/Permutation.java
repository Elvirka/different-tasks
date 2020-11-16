package codeforces.com.tasks.bookOlProg;

import java.util.LinkedList;
import java.util.List;

public class Permutation {

    private static List<Integer> permutation = new LinkedList<>();
    private static int n = 3;
    private static boolean[] chosen = new boolean[n + 1];

    public static void main(String[] args) {
        search();
    }

    static void search() {
        if (permutation.size() == n) {
            System.out.println("-" + permutation);
        } else {
            for (int i = 1; i <= n; i++) {
                if (chosen[i]) continue;
                chosen[i] = true;
                permutation.add(i);
                search();
                chosen[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
