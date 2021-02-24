package com.github.elvirka.tasks;

import java.lang.reflect.Field;

public class StringInternals {

    public static void main(String[] args) {
        String one = "abc";
        System.out.println(showInternalCoder(one));
        //String two = "ab" + "c";
        String two = "?abc".substring(1).intern();
        System.out.println("one.value " + showInternalCharArrayHashCode(one));
        System.out.println("two.value " + showInternalCharArrayHashCode(two));
        System.out.println("one " + System.identityHashCode(one));
        System.out.println("two " + System.identityHashCode(two));
    }

    private static int showInternalCharArrayHashCode(String s){
        try {
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            return value.get(s).hashCode();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static byte showInternalCoder(String s){
        try {
            Field coder = String.class.getDeclaredField("coder");
            coder.setAccessible(true);
            return (byte) coder.get(s);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

}