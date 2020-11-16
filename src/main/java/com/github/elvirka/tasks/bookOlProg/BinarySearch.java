package com.github.elvirka.tasks.bookOlProg;

public class BinarySearch {

    private static int[] array = new int[]{1, 3, 3, 4, 5, 5, 6, 9, 10, 12, 12, 15};

    public static void main(String[] args) {
        int index = searchMy(9, array);
        int index2 = searchBook(9, array);
        int index3 = searchBook2(3, array);
        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);
    }

    public static int searchBook(int value, int[] array) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end)/2;
            if (value == array[mid])
                return mid;
            else if (value > array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static int searchBook2(int value, int[] array) {
        int k = 0;
        for (int b = array.length/2; b >=1 ; b /= 2) {
            while (k + b < array.length && array[k+b] <= value) k +=b;
        }
        if (array[k] == value)
            return k;
        return -1;
    }

    public static int searchMy(int value, int[] array) {
        return search(value, array, 0, array.length-1);
    }

    public static int search(int value, int[] array, int start, int end) {
        int mid = (end + start) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (value < array[mid]) {
            return search(value, array, start, mid-1);
        } else {
            return search(value, array, mid+1, end);
        }
    }
}
