package homework2;

import java.util.*;

public class Homework2<T> {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList<Integer>(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(random.nextInt(100));
        }
        myArrayList.add(-3);
        myArrayList.remove(0);
        myArrayList.add(9, -30);
        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }
        System.out.println("\nsorted:");
        Comparator myComparator = Comparator.naturalOrder();
        myArrayList.sort(myComparator);
        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }
    }

}
