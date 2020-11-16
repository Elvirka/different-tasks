package codeforces.com.tasks.bookAlgorithms;

import java.util.ArrayList;

import codeforces.com.tasks.bookAlgorithms.MyArrayListTest;
import codeforces.com.tasks.bookAlgorithms.MyLinkedList;
import org.junit.Before;


/**
 * @auth or downey
 *
 */
public class MyLinkedListTest extends MyArrayListTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyLinkedList<Integer>();
        mylist.addAll(list);
    }
}
