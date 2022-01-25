import java.util.*;

public class LinkedListDriver {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(8);
        list1.print();
        list1.addFirst(-2);
        list1.addFirst(-8);        
        list1.print();
        list1.addLast(9);
        list1.print();
        System.out.println("Index of 4: " + list1.indexOf(4));
        list1.print();
        System.out.println("Contains 9: " + list1.contains(9));
        int listSize = list1.size();
        for (int i = 0; i < listSize; i++) {
            list1.deleteLast();
            list1.print();
        }  

        MyLinkedList<String> list2 = new MyLinkedList<String>();
        list2.add(new String[] {"a", "b", "c", "d", "e"});
        list2.print();
        list2.reverse();
        list2.print();
    }
}
