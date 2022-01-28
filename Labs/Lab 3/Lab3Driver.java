/**
 * Lab3Driver
 */
import java.util.*;
public class Lab3Driver {

    public static void main(String[] args) {
        String test = "brenton";
        System.out.println(test);
        System.out.println(reverseString(test));
        MyLinkedList2<Integer> list1 = new MyLinkedList2<>();
        Integer[] arr = {1, 2, 3, 4, 5};
        MyLinkedList2<Integer> list2 = new MyLinkedList2<>();
        Integer[] arr2 = {1, 2, 2, 1};
        list1.add(arr);
        list2.add(arr2);
        list1.print();
        System.out.println("Is Palindrome: " + list1.isPalindrome());
        list2.print();
        System.out.println("Is Palindrome: " + list2.isPalindrome());
        System.out.println(list1.getKthNodeFromTheEnd(6));
        

    }
    
    public static String reverseString(String str) {
        Stack<Character> myStack = new Stack<Character>();
        for (char c : str.toCharArray()) {
            myStack.push(c);
        }
        char[] reversed = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            reversed[i] = myStack.pop();
        }
        String reversedString = new String(reversed);
        return reversedString;
    }
}