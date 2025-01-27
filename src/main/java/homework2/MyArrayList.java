package homework2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<T> implements MyList<T> {
    //значения по умолчанию
    private int size = 0;//рабочий размер массива, при этом фактическая вместимость выделена больше
    private Object[] array = new Object[10];//инициализация массива
    //инициализация со значениями по умолчанию
    public MyArrayList() {
    }

    //инициализация с заданной вместимостью
    //capacity - заданная вместимость
    //throws IllegalArgumentException - вместимость не должна быть отрицательной
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.array = new Object[capacity];
        } else if (capacity == 0) {
            new MyArrayList<>();//пустой массив, если вместимость 0
        }
        else throw new IllegalArgumentException("Capacity must not be less than 0");
    }

    //получить размер
    public int getSize() {
        return this.size;
    }
    //получить массив
    public Object[] getArray() {
        return this.array;
    }

    //element - элемент добавления в коллекцию
    @Override
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    //увеличить вместимость при необходимости
    private void ensureCapacity() {
        if (size == array.length) {//если достигнута текущая потенциальная вместимость
            int newCapacity = size + (size>>1);//размер + размер, делённый на 2 (увеличить в половину текущего размера)
            array = Arrays.copyOf(array, newCapacity);//копирование массива в массив большей вместимости
        }
    }

    //index - индекс, на место которого добавляется элемент
    //element - элемент добавления в коллекцию
    //throws IndexOutOfBoundsException - индекс не должен быть отрицательным и равняться или превышать размер массива
    @Override
    public void add(int index, T element) {
        ensureCapacity();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(array, index, array, index+1, size-index);//сдвиг (через копирование) элементов в массиве следующих за индексом
        array[index] = element;//установить по требуемому индексу элемент
        size++;//увеличить размер
    }

    //index - индекс, по которому получить элемент
    //throw IndexOutOfBoundsException - индекс не должен быть отрицательным и равняться или превышать размер массива
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) array[index];
    }

    //index - индекс, по которому получить элемент
    //throw IndexOutOfBoundsException - индекс не должен быть отрицательным и равняться или превышать размер массива
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(array, index+1, array, index, size-index-1);//сдвиг (через копирование) элементов начиная с индекса, на месте которого удалён элемент
        array[--size] = null;//уменьшить размер, поставить null на место последнего элемента
    }


    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            array[i] = null;//поставить элементы null и уменьшить размер
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
        if (size < 0 || start >= end) return array;//если размер массив не содержит элементы, завершить сортировку
        int i = start;//маркеры, прохождения по элементам массива
        int j = end;
        T border = array[(i+j)/2];//опорный элемент - середина массива
        while (i <= j) {
            while (comparator.compare(array[i], border) < 0) i++;//пока не будет найден элемент слева, превышающий опорный
            while (comparator.compare(array[j], border) > 0) j--;//пока не будет найден элемент слева, меньше опорного
            if (i <= j) {//если маркер слева меньше маркера справа, то переставить элементы и изменить значения маркеров
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }//рекрсивный вызов метода на левую и правую части
            if (start < j) sort(array, start, j, comparator);//начальный индекс меньше индекса, пришедшего справа
            if (i < end) sort(array, i, end, comparator);//индекс пришедший слева меньше конечного индекса
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
