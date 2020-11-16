package codeforces.com.tasks;

import java.util.*;

class MyRegex {
    String pattern = "(25[0-5]|2[0-4]\\d|[0-1]?\\d{1,2})\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d{1,2})\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d{1,2})\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d{1,2})";
}

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
