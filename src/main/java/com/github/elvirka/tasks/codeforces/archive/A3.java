package com.github.elvirka.tasks.codeforces.archive;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class A3 {

    static class Point {
        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point point) {
            return x == point.x &&
                    y == point.y;
        }
    }

    private static Map<Character, Integer> letters =
        Map.of('a',1, 'b', 2, 'c', 3, 'd', 4,
            'e', 5, 'f', 6, 'g', 7, 'h', 8);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var a = sc.nextLine();
        var b = sc.nextLine();
        var pointA = new Point(letters.get(a.charAt(0)), Character.getNumericValue(a.charAt(1)));
        var pointB = new Point(letters.get(b.charAt(0)), Character.getNumericValue(b.charAt(1)));
        var path = new ArrayList<String>();
        while (!pointA.equals(pointB)){
            var diffH = pointA.x - pointB.x;
            var diffV = pointA.y - pointB.y;
            if (diffH > 0) {
                pointA.x--;
                if (diffV > 0) {
                    path.add("LD");
                    pointA.y--;
                } else if (diffV == 0) {
                    path.add("L");
                } else {
                    path.add("LU");
                    pointA.y++;
                }
            } else if (diffH == 0) {
                if (diffV > 0) {
                    path.add("D");
                    pointA.y--;
                } else if (diffV == 0) {
                    // place is found
                    break;
                } else {
                    path.add("U");
                    pointA.y++;
                }
            } else{
                pointA.x++;
                if (diffV > 0) {
                    path.add("RD");
                    pointA.y--;
                } else if (diffV == 0) {
                    path.add("R");
                } else {
                    path.add("RU");
                    pointA.y++;
                }
            }
        }
        System.out.println(path.size());
        path.forEach(System.out::println);
    }
}
