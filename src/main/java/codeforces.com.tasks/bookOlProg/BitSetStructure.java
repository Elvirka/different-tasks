package codeforces.com.tasks.bookOlProg;

import org.openjdk.jol.info.ClassLayout;

import java.util.BitSet;

import static java.lang.System.out;

public class BitSetStructure {

    public static void main(String[] args) {
        boolean[] bits = new boolean[1024];
        out.println(ClassLayout.parseInstance(bits).toPrintable());
        BitSet bitset = new BitSet(1024);
        out.println(ClassLayout.parseInstance(bitset).toPrintable());
    }
}

