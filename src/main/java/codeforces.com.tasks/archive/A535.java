package codeforces.com.tasks.archive;

import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class A535 {

    private static Map<Integer, String> map = Map.ofEntries(
            entry(0, "zero"),
            entry(1, "one"),
            entry(2, "two"),
            entry(3, "three"),
            entry(4, "four"),
            entry(5, "five"),
            entry(6, "six"),
            entry(7, "seven"),
            entry(8, "eight"),
            entry(9, "nine"),
            entry(10, "ten"),
            entry(11, "eleven"),
            entry(12, "twelve"),
            entry(13, "thirteen"),
            entry(14, "fourteen"),
            entry(15, "fifteen"),
            entry(16, "sixteen"),
            entry(17, "seventeen"),
            entry(18, "eighteen"),
            entry(19, "nineteen"),
            entry(20, "twenty"),
            entry(30, "thirty"),
            entry(40, "forty"),
            entry(50, "fifty"),
            entry(60, "sixty"),
            entry(70, "seventy"),
            entry(80, "eighty"),
            entry(90, "ninety")
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String lettersNumber = "";
        if (number < 21) {
            lettersNumber = map.get(number);
        } else {
            var dozens = (number / 10) * 10;
            var units = number % 10;
            if (units == 0) {
                lettersNumber = map.get(dozens);
            } else {
                lettersNumber = map.get(dozens) + "-" + map.get(units);
            }
        }
        System.out.println(lettersNumber);
    }

}
