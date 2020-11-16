package codeforces.com.tasks.bookOlProg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class ScheduleWorks {
    private static List<Map.Entry<Integer, Integer>> worksTime = Arrays.asList(
            entry(4, 2),
            entry(3, 10),
            entry(2, 8),
            entry(4, 15)
    );

    public static void main(String[] args) {
        worksTime.sort(Comparator.comparing(Map.Entry::getKey));
        int time = 0;
        int score = 0;
        for (var work : worksTime) {
            time += work.getKey();
            var workScore = work.getValue() - time;
            System.out.println(workScore);
            score += workScore;
        }
        System.out.println("----------------------");
        System.out.println(score);
        System.out.println(worksTime);
    }

}
