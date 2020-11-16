package codeforces.com.tasks.bookAlgorithms;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author downey
 * @param <T>
 *
 */
public class MyArrayList<T> implements List<T> {
    private int size;                 // keeps track of the number of elements
    private Object[] array;           // stores the elements

    /**
     *
     */
    public MyArrayList() {
        // You can't instantiate an array of T[], but you can instantiate an
        // array of Object and then typecast it.  Details at
        // http://www.ibm.com/developerworks/java/library/j-jtp01255/index.html
        this.array = new Object[10];
        size = 0;
    }

    /**
     * @param args console arguments
     */
    public static void main(String[] args) {
        // run a few simple tests
        MyArrayList<Integer> mal = new MyArrayList();
        mal.add(1);
        mal.add(2);
        mal.add(3);
        System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);

        mal.remove(Integer.valueOf(2));
        System.out.println(Arrays.toString(mal.toArray()) + " size = " + mal.size);
    }

    @Override
    public boolean add(T element) {
        if (size >= array.length) {
            T[] biggerArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, biggerArray, 0, array.length);
            array = biggerArray;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index, size);
        add(element);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T element: collection) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        // note: this version does not actually null out the references
        // in the array, so it might delay garbage collection.
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element: collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public T get(int index) {
        checkIndex(index, size);
        return getCastElement(index);
    }

    @Override
    public int indexOf(Object target) {
        for (int i = 0; i < size; i++) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    /** Checks whether an element of the array is the target.
     *
     * Handles the special case that the target is null.
     *
     * @param target
     * @param element
     */
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        // make a copy of the array
        T[] copy = getCastArrayCopy();
        // make a list and return an iterator
        return Arrays.asList(copy).iterator();
    }

    @Override
    public int lastIndexOf(Object target) {
        // see notes on indexOf
        for (int i = size-1; i>=0; i--) {
            if (equals(target, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator() {
        // make a copy of the array
        T[] copy = getCastArrayCopy();
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator();
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        // make a copy of the array
        T[] copy = getCastArrayCopy();
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator(index);
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public T remove(int index) {
        checkIndex(index, size);
        var old = getCastElement(index);
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        return old;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj: collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index, size);
        var old = getCastElement(index);
        array[index] = element;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @NotNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        T[] copy = (T[]) Arrays.copyOfRange(array, fromIndex, toIndex);
        return Arrays.asList(copy);
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @NotNull
    @Override
    public <U> U[] toArray(@NotNull U[] array) {
        throw new UnsupportedOperationException();
    }

    private void checkIndex(int index, int size){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    private T getCastElement(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    private T[] getCastArrayCopy() {
        return (T[]) Arrays.copyOf(array, size);
    }
}