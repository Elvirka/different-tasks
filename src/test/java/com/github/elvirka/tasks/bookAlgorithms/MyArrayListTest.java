package com.github.elvirka.tasks.bookAlgorithms;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class MyArrayListTest {

    protected List<Integer> myList;
    protected List<Integer> list;

    @BeforeEach
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        myList = new MyArrayList<>();
        myList.addAll(list);
    }

    @Test
    public void testMyList() {
        assertThat(myList.size(), is(3));
    }

    @Test
    public void testAddT() {
        for (int i = 4; i < 20; i++) {
            myList.add(i);
        }
        assertThat(myList.get(18), is(19));
    }

    @Test
    public void testAddIntT() {
        myList.add(1, 5);
        assertThat(myList.get(1), is(5));
        assertThat(myList.size(), is(4));

        try {
            myList.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            myList.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        myList.add(0, 6);
        assertThat(myList.get(0), is(6));

        myList.add(7);
        assertThat(myList.get(5), is(7));
    }

    @Test
    public void testAddAllCollectionOfQextendsT() {
        myList.addAll(list);
        myList.addAll(list);
        myList.addAll(list);
        assertThat(myList.size(), is(12));
        assertThat(myList.get(5), is(3));
    }

    @Test
    public void testClear() {
        myList.clear();
        assertThat(myList.size(), is(0));
    }

    @Test
    public void testContains() {
        assertThat(myList.contains(1), equalTo(true));
        assertThat(myList.contains(4), equalTo(false));
        assertThat(myList.contains(null), equalTo(false));
        myList.add(null);
        assertThat(myList.contains(null), equalTo(true));
    }

    @Test
    public void testContainsAll() {
        assertThat(myList.containsAll(list), equalTo(true));
    }

    @Test
    public void testGet() {
        assertThat(myList.get(1), is(2));
    }

    @Test
    public void testIndexOf() {
        assertThat(myList.indexOf(1), is(0));
        assertThat(myList.indexOf(2), is(1));
        assertThat(myList.indexOf(3), is(2));
        assertThat(myList.indexOf(4), is(-1));
    }

    @Test
    public void testIndexOfNull() {
        assertThat(myList.indexOf(null), is(-1));
        myList.add(null);
        assertThat(myList.indexOf(null), is(3));
    }

    @Test
    public void testIsEmpty() {
        assertThat(myList.isEmpty(), equalTo(false));
        myList.clear();
        assertThat(myList.isEmpty(), equalTo(true));
    }

    @Test
    public void testIterator() {
        Iterator<Integer> iter = myList.iterator();
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), equalTo(false));
    }

    @Test
    public void testLastIndexOf() {
        myList.add(2);
        assertThat(myList.lastIndexOf(2), is(3));
    }

    @Test
    public void testRemoveObject() {
        boolean flag = myList.remove(Integer.valueOf(2));
        assertThat(flag, equalTo(true));
        assertThat(myList.size(), is(2));
        assertThat(myList.get(1), is(3));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = myList.remove(Integer.valueOf(1));
        assertThat(flag, equalTo(true));
        assertThat(myList.size(), is(1));
        assertThat(myList.get(0), is(3));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = myList.remove(Integer.valueOf(5));
        assertThat(flag, equalTo(false));
        assertThat(myList.size(), is(1));
        assertThat(myList.get(0), is(3));
        //System.out.println(Arrays.toString(mal.toArray()));

        flag = myList.remove(Integer.valueOf(3));
        assertThat(flag, equalTo(true));
        assertThat(myList.size(), is(0));
        //System.out.println(Arrays.toString(mal.toArray()));
    }

    @Test
    public void testRemoveInt() {
        Integer val = myList.remove(1);
        assertThat(val, is(2));
        assertThat(myList.size(), is(2));
        assertThat(myList.get(1), is(3));
    }

    @Test
    public void testRemoveAll() {
        myList.removeAll(list);
        assertThat(myList.size(), is(0));
    }

    @Test
    public void testSet() {
        Integer val = myList.set(1, 5);
        assertThat(val, is(2));

        val = myList.set(0, 6);
        assertThat(val, is(1));

        val = myList.set(2, 7);
        assertThat(val, is(3));

        assertThat(myList.get(0), is(6));
        assertThat(myList.get(1), is(5));
        assertThat(myList.get(2), is(7));

        try {
            myList.set(-1, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good

        try {
            myList.set(4, 0);
            fail();
        } catch (IndexOutOfBoundsException e) {} // good
    }

    @Test
    public void testSize() {
        assertThat(myList.size(), is(3));
    }

    @Test
    public void testSubList() {
        myList.addAll(list);
        List<Integer> sub = myList.subList(1, 4);
        assertThat(sub.get(1), is(3));
    }

    @Test
    public void testToArray() {
        Object[] array = myList.toArray();
        assertThat((Integer)array[0], is(1));
    }

}
