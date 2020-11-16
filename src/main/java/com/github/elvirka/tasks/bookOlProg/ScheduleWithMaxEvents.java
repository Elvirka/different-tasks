package com.github.elvirka.tasks.bookOlProg;

import java.util.*;

import static java.util.Map.entry;

public class ScheduleWithMaxEvents {

    private static List<Map.Entry<Integer, Integer>> events = Arrays.asList(
            entry(1000, 2000),
            entry(1100, 1400),
            entry(1500, 1600)
    );

    public static void main(String[] args) {
        events.sort(Comparator.comparing(Map.Entry::getValue));
        List<Map.Entry<Integer, Integer>> schedule = new ArrayList<>();
        int endOfLast = 0;
        for (var event : events) {
            if (event.getKey() > endOfLast) {
                schedule.add(event);
                endOfLast = event.getValue();
            }
        }
        System.out.println(schedule);
    }
}
