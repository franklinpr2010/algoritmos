package linkedlist;

class LinkedListRemoveLast {
    private Node head;
    private Node tail;
    private int length;

    public LinkedListRemoveLast() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        Node temp = head;
        Node pre = head;

        // Traverse until temp reaches the last node
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        // Update tail and break the link
        tail = pre;
        tail.next = null;
        length--;

        // If list is now empty, update head
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public static void main(String[] args) {
        LinkedListRemoveLast list = new LinkedListRemoveLast();
        list.append(10);
        list.append(20);
        list.append(30);

        Node removed = list.removeLast(); // Removes 30
        System.out.println(removed.value); // Prints 30
    }
}
