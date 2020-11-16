package codeforces.com.tasks.bookOlProg;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import static java.lang.Math.abs;
import static java.util.Map.entry;

public class MaxClientsAtTheSameTime {

    private static List<Entry<Integer, Integer>> clientsVisits = Arrays.asList(
            entry(1000, 1700),
            entry(1200, 1600),
            entry(1500, 1900),
            entry(1800, 2000)
    );

    public static void main(String[] args) {
        Integer[] events = new Integer[clientsVisits.size()*2];
        for (int i = 0, j = 0; i < clientsVisits.size(); i++) {
            var entry = clientsVisits.get(i);
            events[j] = entry.getKey();
            events[j+1] = -entry.getValue();
            j += 2;
        }
        Arrays.sort(events,
            (Integer o1, Integer o2) -> Integer.valueOf(abs(o1)).compareTo(abs(o2))
        );
        int max = 0, count = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i] >= 0) {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
