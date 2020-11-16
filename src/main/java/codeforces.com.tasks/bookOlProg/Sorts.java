package codeforces.com.tasks.bookOlProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

public class Sorts {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 3, 8, 2, 9, 2, 5 ,6 ,11);
        //bubbleSort(arr);
        //System.out.println(arr);
        //mergeSort(arr);
        //System.out.println(arr);
        countSort(arr);
        System.out.println(arr);
    }
    static void countSort(List<Integer> arr){
        int[] tmp = new int[10];
        int size = 0;
        for (int val : arr) {
            size = Math.max(val, size);
            if (val >= tmp.length) {
                int[] biggerTmp = new int[Math.max(val + 1, tmp.length * 2)];
                System.arraycopy(tmp, 0, biggerTmp, 0, tmp.length);
                tmp = biggerTmp;
            }
            tmp[val] = tmp[val] + 1;
        }
        int k = 0;
        for (int i = 0; i < size; i++) {
            if(tmp[i] > 0) {
                for (int j = 0; j < tmp[i]; j++) {
                    arr.set(k, i);
                    k++;
                }
            }
        }
    }

    static void mergeSort(List<Integer> arr){
        if (arr.size() >= 2) {
            int mid = arr.size() / 2;
            List<Integer> l = new ArrayList<>(arr.subList(0, mid));
            List<Integer> r = new ArrayList<>(arr.subList(mid, arr.size()));
            mergeSort(l);
            mergeSort(r);
            int k = 0, i = 0, j = 0;
            while (i < l.size() && j < r.size()) {
                if (l.get(i) < r.get(j)) {
                    arr.set(k, l.get(i));
                    k++; i++;
                } else {
                    arr.set(k, r.get(j));
                    k++; j++;
                }
            }
            while (i < l.size()){
                arr.set(k, l.get(i));
                k++; i++;
            }
            while (j < r.size()){
                arr.set(k, r.get(j));
                k++; j++;
            }
        }
    }

    static void bubbleSort(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if(arr.get(j) > arr.get(j+1)) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

}
