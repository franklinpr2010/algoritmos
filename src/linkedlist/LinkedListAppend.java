package linkedlist;

class LinkedListAppend {
    private Node head;
    private Node tail;
    private int length;

    public LinkedListAppend() {
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


    // Helper method to print the list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Helper method to get length (for testing)
    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        LinkedListAppend list = new LinkedListAppend();

        // Test 1: Append to empty list
        System.out.println("Test 1: Append to empty list");
        list.append(10);
        list.printList();  // Expected: List: 10
        System.out.println("Length: " + list.getLength());  // Expected: 1

        // Test 2: Append to non-empty list
        System.out.println("\nTest 2: Append to non-empty list");
        list.append(20);
        list.append(30);
        list.printList();  // Expected: List: 10 20 30
        System.out.println("Length: " + list.getLength());  // Expected: 3

        // Test 3: Verify head and tail after multiple appends
        System.out.println("\nTest 3: Verify head and tail");
        list.append(40);
        list.printList();  // Expected: List: 10 20 30 40
        System.out.println("Length: " + list.getLength());  // Expected: 4

        // Test 4: Append negative numbers and zero
        System.out.println("\nTest 4: Append special values");
        list.append(-5);
        list.append(0);
        list.printList();  // Expected: List: 10 20 30 40 -5 0
        System.out.println("Length: " + list.getLength());  // Expected: 6
    }
}
