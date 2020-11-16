package codeforces.com.tasks.bookOlProg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {

    private static List<Integer> subset = new LinkedList();
    private static Integer n = 4;

    public static void main(String[] args) {
        var list = subsetsList(List.of(1,4,9));
        System.out.println(list);
        //subsetsNumber(1);
    }

    static void subsetsNumber(int k) {
        if (k == n + 1) {
            System.out.println("-" + k + " " + subset);
        } else {
            //System.out.println("*" + k + " " + subset);
            subset.add(k);
            subsetsNumber(k + 1);
            subset.remove(subset.size() - 1);
            subsetsNumber(k + 1);
        }
    }

    static List<List<Integer>> subsetsList(List<Integer> k) {
        if (k.isEmpty()) {
            List<List<Integer>> ans = List.of(List.of());
            return ans;
        } else {
            var first = k.get(0);
            var rest = k.subList(1, k.size());
            var subAns = subsetsList(rest);
            var subAns2 = insertAll(first, subAns);
            return concat(subAns, subAns2);
        }
    }

    static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists){
        List<List<Integer>> result = new ArrayList();
        for (var list : lists) {
            List<Integer> copy = new ArrayList();
            copy.add(first);
            copy.addAll(list);
            result.add(copy);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b){
        List<List<Integer>> result = new ArrayList<>(a);
        result.addAll(b);
        return result;
    }

}