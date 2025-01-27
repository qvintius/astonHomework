package homework2;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] array = new Object[DEFAULT_CAPACITY];

    public MyArrayList() {
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.array = new Object[capacity];
        } else if (capacity == 0) {
            new MyArrayList<>();
        }
        else throw new IllegalArgumentException("Capacity must be greater than 0");
    }
    public int getSize() {
        return this.size;
    }

    public Object[] getArray() {
        return this.array;
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = size + (size>>1);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public void add(int index, T element) {
        ensureCapacity();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(array, index, array, index+1, size-index);
        array[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(array, index+1, array, index, size-index-1);
        array[--size] = null;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    //    Реализовать алгоритм quicksort для реализованного вами MyArrayList.
    //    Ваш QuickSort должен принимать список любого типа и сортировать его.
    //    Использовать: Java generics, Comparable, Comparator
    @Override
    public T[] sort(Comparator<T> comparator){

        return sort((T[]) array, 0, size-1, comparator);
    }

    private T[] sort(T[] array, int start, int end, Comparator<T> comparator) {
        if (size < 0 || start >= end) return array;
        int i = start;
        int j = end;
        T border = array[(i+j)/2];
        while (i <= j) {
            while (comparator.compare(array[i], border) < 0) i++;
            while (comparator.compare(array[j], border) > 0) j--;
            if (i <= j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            if (start < j) sort(array, start, j, comparator);
            if (i < end) sort(array, i, end, comparator);
        }
        return array;
    }

    @Override
    public String toString() {
        String array = ", array=";
        for (int i = 0; i < size; i++)
            array = array + this.array[i] + " ";
        return "size=" + size + array;
    }

}
