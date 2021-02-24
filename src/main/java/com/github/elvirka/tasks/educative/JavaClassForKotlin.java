package com.github.elvirka.tasks.educative;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class JavaClassForKotlin {
    public int getZero() { return 0; }

    public List<String> convertToUpper(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .collect(toList());
    }
    public void suspend() {
        System.out.println("suspending...");
    }

    public String when() {
        return "Now!";
    }
}
