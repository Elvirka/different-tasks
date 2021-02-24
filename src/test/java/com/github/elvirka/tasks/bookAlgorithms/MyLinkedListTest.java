package com.github.elvirka.tasks.bookAlgorithms;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

/**
 * @auth or downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

    /**
     * @throws Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        myList = new MyLinkedList<Integer>();
        myList.addAll(list);
    }
}
