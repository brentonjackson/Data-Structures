import java.util.*;

public class MyLinkedList<AnyType> {
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int theSize;

    public MyLinkedList() {
        head = new Node<AnyType>(null, null, null);
        tail = new Node<AnyType>(null, head, null);
        head.next = tail;
        theSize = 0;
    }
    
    private static class Node<AnyType> {
        public AnyType value;
        public Node<AnyType> next;
        public Node<AnyType> prev;

        public Node(AnyType v, Node<AnyType> p, Node<AnyType> n) {
            value = v;
            prev = p;
            next = n;
        }
    }
    public int size(){
        return theSize;
    }
    private boolean isEmpty() {
        return (size() == 0);
    }
    private boolean isNextTail(Node<AnyType> current) {
        return current.next == tail;
    }
    private boolean isCurrentTail(Node<AnyType> current) {
        return current == tail;
    }
    public void print() {
        if (isEmpty()) {
            System.out.print(" [ ]\n");
            return;
        }

        Node<AnyType> current = head.next;
        System.out.print(" [ ");
        while (!isCurrentTail(current)) {
            if (isNextTail(current)) {
                System.out.print(current.value + " ] ");
                System.out.println();
                return;
            }
            System.out.print(current.value + " -> ");
            current = current.next;
        }

    }
    public void addFirst(AnyType value) {
        Node<AnyType> node = new Node<AnyType>(value, head, head.next);
        if (isEmpty()) {
            head.next = tail.prev = node;
        } else {
            head.next.prev = head.next = node;
        }
        theSize++;
    }
    public void addLast(AnyType value) {
        Node<AnyType> node = new Node<AnyType>(value, tail.prev, tail);
        if (isEmpty()) {
            head.next = tail.prev = node;
        } else {
            tail.prev.next = tail.prev = node;
        }
        theSize++;
    }
    public void add(AnyType[] valueArr) {
        for (int i = 0; i < valueArr.length; i++) {
            addLast(valueArr[i]);
        }
    }
    public int indexOf(AnyType value) {
        int index = 0;
        Node<AnyType> current = head.next;
        while(!isCurrentTail(current)) {
            if (current.value == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
    public boolean contains(AnyType value) {
        return (indexOf(value) != -1);
    }
    public void deleteFirst() {
        if (isEmpty()) {
            return;
        }
        head.next = head.next.next;
        theSize--;
    }
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        theSize--;
    }   
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        Node<AnyType> currentPos, nextPos, previousPos;

        previousPos = tail;
        currentPos = head.next;
        while( !isCurrentTail(currentPos)) {
            nextPos = currentPos.next;
            currentPos.next = previousPos;
            currentPos.prev = nextPos;
            previousPos = currentPos;
            currentPos = nextPos;
        }
        // swap head and tail
        tail.prev = head.next;
        head.next = previousPos;
    }   
}