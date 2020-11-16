package com.github.elvirka.tasks.bookEfJava.trywithresource;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException {
        String path = "/tmp/tryWithResource";
        writeLineToFile(path);
        String str = firstLineOfFile(path);
        System.out.println(str);
        String newPath = path + 1;
        copy(path, newPath);
        str = firstLineOfFile(newPath);
        System.out.println(str);
    }

    static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static void writeLineToFile(String path) throws IOException {
        try(OutputStream out = new FileOutputStream(path)) {
            String line = "qwerty";
            out.write(line.getBytes());
        }
    }

    static void copy(String src, String dst) throws IOException {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)
        ) {
            byte[] buf = new byte[20];
            int n;

            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
