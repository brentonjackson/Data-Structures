public class MyLinkedList2<AnyType> {
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int theSize;

    public MyLinkedList2() {
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
    private AnyType remove( Node<AnyType> node )
    {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        theSize--;
        
        return node.value;
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

    public AnyType getKthNodeFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        if ((k <= 0) || (k >= size())) throw new IllegalArgumentException("Invalid value of k.");
        Node<AnyType> first = head.next;
        Node<AnyType> second = head.next;
        // go to kth node
        for (int i = 0; i < k - 1; i++) {
            if (first.next == tail) throw new IllegalArgumentException();
            first = first.next;
        }
        while (!isNextTail(first)) {
            first = first.next;
            second = second.next;
        }
        return second.value;
    }
    private boolean isListEven() {
        return size() % 2 == 0;
    }
    public boolean isPalindrome() {
        if (isEmpty()) return false;
        if (head.next.value != tail.prev.value) {
            // System.out.println("Size: " + size() + " Head: " + head.next.value + " Tail: " + tail.prev.value);
            return false;
        }
        if (size() == 1) return true;
        int listSize = size();
        Node<AnyType> currentLeft = head.next;
        Node<AnyType> currentRight = tail.prev;
        if (isListEven()) {
            // System.out.println("Size: " + size() + " Head: " + head.next.value + " Tail: " + tail.prev.value);
            // even num of elements
            int evenHalf = listSize / 2;
            for (int i = 0; i < evenHalf; i++) {
                // System.out.println("Left: " + currentLeft.value + " Right: " + currentRight.value);
                if (!currentLeft.value.equals(currentRight.value)) {
                    return false;
                }
                currentLeft =  currentLeft.next;
                currentRight = currentRight.prev;
            }
        } else {
            // odd num of elements
            // System.out.println("Head: " + head.next.value + " Tail: " + tail.prev.value);
            int oddHalf = (int) Math.floor(listSize / 2);
            for (int i = 0; i < oddHalf; i++) {
                // System.out.println("Left: " + currentLeft.value + " Right: " + currentRight.value);
                if (!currentLeft.value.equals(currentRight.value)) {
                    return false;
                }
                currentLeft =  currentLeft.next;
                currentRight = currentRight.prev;
            }
        }
        return true;
    }
        
}