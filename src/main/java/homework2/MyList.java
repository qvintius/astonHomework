package homework2;

import java.util.Comparator;

public interface MyList<T> {
    public void add(T element);//добавить элемент
    public void add(int index, T element);//добавить элемент по индексу
    public T get(int index);//получить элемент
    public void remove(int index);//удалить элемент
    public void clear();//очистить всю коллекцию
    public T[] sort(Comparator<T> comparator);//отсортировать коллекцию
}
