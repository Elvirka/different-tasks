package codeforces.com.tasks.bookOlProg;

public class Queens {

    private static int n = 8;
    private static int count = 0;
    private static boolean[] col = new boolean[n];
    private static boolean[] diag1 = new boolean[n * 2];
    private static boolean[] diag2 = new boolean[n * 2];

    public static void main(String[] args) {
        search(0);
        System.out.println(count);
    }

    static void search(int y) {
        if (y == n) {
            count++;
            return;
        } else {
            for (int x = 0; x < n; x++) {
                if (col[x] || diag1[x+y] || diag2[x-y+n-1]) continue;
                col[x] = diag1[x+y] = diag2[x-y+n-1] = true;
                search(y + 1);
                col[x] = diag1[x+y] = diag2[x-y+n-1] = false;
            }
        }
    }
}
