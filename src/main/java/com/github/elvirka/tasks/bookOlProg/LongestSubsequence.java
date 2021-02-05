package com.github.elvirka.tasks.bookOlProg;

public class LongestSubsequence {

    public static void main(String[] args) {
        int N = 16;
        int[] A={0,8,4,12,2,10,6,14,1,9,5, 13,3,11,7,15};
        int res = longestSubsequence(N, A);
        System.out.println(res);
    }

    static int longestSubsequence(int size, int a[]){
        int[] length = new int[size];
        int max = 0;
        for (int k = 0; k < size; k++) {
            length[k] = 1;
            for (int j = 0; j < k; j++) {
                if(a[j] < a[k]){
                    length[k] = Math.max(length[k], length[j] + 1);
                }
            }
            max = Math.max(max, length[k]);
        }
        return max;
    }
}
