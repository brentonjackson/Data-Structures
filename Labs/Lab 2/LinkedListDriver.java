import java.util.*;

public class LinkedListDriver {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(8);
        list1.addFirst(-2);
        list1.addFirst(-8);
        list1.addLast(9);
        list1.print();
        System.out.println("Index of 4: " + list1.indexOf(4));
        System.out.println("Contains 9: " + list1.contains(9));
        int listSize = list1.size();
        list1.print();
        for (int i = 0; i < listSize; i++) {
            list1.deleteLast();
            list1.print();
        }
        Integer[] arr = {1, 2, 3, 4, 5};
        list1.add(arr);  
        list1.print();
        list1.reverse();
        list1.print();
    }
}
