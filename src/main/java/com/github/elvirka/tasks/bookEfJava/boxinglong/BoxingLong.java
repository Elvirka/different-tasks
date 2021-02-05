package com.github.elvirka.tasks.bookEfJava.boxinglong;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

public class BoxingLong {

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void boxingBenchmark() {
        Long sum = boxingIntSum();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void benchmark() {
        long sum1 = intSum();
    }

    private static Long boxingIntSum(){
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static long intSum(){
        long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

}