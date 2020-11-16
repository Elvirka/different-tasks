package com.github.elvirka.tasks.bookEfJava;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparingInt;

public class CompareObjects {

    public static void main(String[] args) {
        Point a = new Point(1,3);
        Point b = new Point(1,4);
        System.out.println(Objects.compare(a, b, Point::compareTo));
        PhoneNumber c = new PhoneNumber(915,185, 7345);
        PhoneNumber d = new PhoneNumber(915,185, 7344);
        System.out.println(Objects.compare(c, d, PhoneNumber::compareTo));
    }

    private static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull Point o) {
            return Integer.compare(x + y, o.x + o.y);
        }
    }

    private static class PhoneNumber implements Comparable<PhoneNumber> {

        private static final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

        private final int areaCode;
        private final int prefix;
        private final int lineNum;

        PhoneNumber(int areaCode, int prefix, int lineNum){
            this.areaCode = areaCode;
            this.prefix = prefix;
            this.lineNum = lineNum;
        }

        @Override
        public int compareTo(@NotNull PhoneNumber o) {
            return COMPARATOR.compare(this, o);
        }

        /*@Override
        public int compareTo(@NotNull PhoneNumber o) {
            int result = Integer.compare(areaCode, o.areaCode);
            if (result == 0) {
                result = Integer.compare(prefix, o.prefix);
                if (result == 0) {
                    result = Integer.compare(lineNum, o.lineNum);
                }
            }
            return result;
        }*/
    }

}
