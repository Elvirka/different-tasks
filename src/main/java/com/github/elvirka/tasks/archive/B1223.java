package com.github.elvirka.tasks.archive;

import java.util.*;

public class B1223 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String[] sa = new String[q];
        String[] ta = new String[q];
        for (int i = 0; i < q; i++) {
            sa[i] = sc.next();
            ta[i] = sc.next();
        }
        for (int i = 0; i < q; i++) {
            Set<Character> sSet = new HashSet<>();
            Set<Character> tSet = new HashSet<>();
            var s = sa[i].toCharArray();
            var t = ta[i].toCharArray();
            for (int j = 0; j < s.length; j++) {
                sSet.add(s[j]);
                tSet.add(t[j]);
            }
            sSet.retainAll(tSet);
            if(!sSet.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
