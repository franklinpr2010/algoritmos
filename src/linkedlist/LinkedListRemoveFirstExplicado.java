package linkedlist;

/**
 * Classe que implementa uma lista encadeada simples
 * Class implementing a simple linked list
 */
class LinkedListRemoveFirstExplicado {
    private Node head;    // Referência para o primeiro nó / Reference to the first node
    private Node tail;    // Referência para o último nó / Reference to the last node
    private int length;   // Tamanho atual da lista / Current list length

    /**
     * Construtor da lista encadeada
     * Linked list constructor
     */
    public LinkedListRemoveFirstExplicado() {
        this.head = null;  // Lista inicia vazia / List starts empty
        this.tail = null;
        this.length = 0;
    }

    /**
     * Removes and returns the first node
     * Remove e retorna o primeiro nó
     * @return The removed node or null if empty
     *         O nó removido ou null se vazio
     */
    public Node removeFirst() {
        if (this.length == 0) {
            return null;  // Empty list case / Caso lista vazia
        }

        Node temp = this.head;    // Store node to be removed / Armazena nó a remover
        this.head = this.head.next;  // Move head pointer / Move ponteiro head
        temp.next = null;         // Isolate removed node / Isola nó removido
        this.length--;

        if (this.length == 0) {
            // If list became empty, update tail
            // Se lista ficou vazia, atualiza tail
            this.tail = null;
        }

        return temp;
    }

    /**
     * Adiciona um novo nó no FINAL da lista
     * Adds a new node at the END of the list
     * @param value Valor a ser adicionado / Value to be added
     */
    public void append(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            // Lista vazia: head e tail apontam para o novo nó
            // Empty list: head and tail point to the new node
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Lista não vazia: adiciona após o tail e atualiza tail
            // Non-empty list: add after tail and update tail
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;  // Incrementa o tamanho / Increment length
    }

    /**
     * Adiciona um novo nó no INÍCIO da lista
     * Adds a new node at the BEGINNING of the list
     * @param value Valor a ser adicionado / Value to be added
     */
    public void prepend(int value) {
        Node newNode = new Node(value);

        if (this.length == 0) {
            // Lista vazia: head e tail apontam para o novo nó
            // Empty list: head and tail point to the new node
            this.head = newNode;
            this.tail = newNode;
        } else {
            //Primeiro passa o primeiro para o segundo
            // Lista não vazia: novo nó aponta para head atual
            // Non-empty list: new node points to current head
            newNode.next = this.head;
            this.head = newNode;  // Atualiza head / Update head
        }
        this.length++;  // Incrementa o tamanho / Increment length
    }

    /**
     * Remove o ÚLTIMO nó da lista
     * Removes the LAST node from the list
     * @return Nó removido ou null se lista vazia / Removed node or null if empty
     */
    public Node removeLast() {
        if (this.length == 0) {
            return null;  // Lista vazia / Empty list
        }

        Node temp = this.head;
        Node pre = this.head;

        // Percorre até encontrar o último nó
        // Traverse until finding the last node
        while (temp.next != null) {
            pre = temp;        // Mantém referência ao nó anterior / Keeps reference to previous node
            temp = temp.next;  // Avança para o próximo nó / Moves to next node
        }

        this.tail = pre;        // Atualiza tail / Update tail
        this.tail.next = null;  // Remove referência ao último nó / Remove reference to last node
        this.length--;          // Decrementa tamanho / Decrement length

        if (this.length == 0) {
            // Se lista ficou vazia, reseta head e tail
            // If list became empty, reset head and tail
            this.head = null;
            this.tail = null;
        }

        return temp;  // Retorna nó removido / Return removed node
    }

    /**
     * Imprime os valores da lista
     * Prints the list values
     */
    public void printList() {
        Node current = this.head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Retorna o tamanho atual da lista
     * Returns the current list length
     * @return Tamanho da lista / List length
     */
    public int getLength() {
        return this.length;
    }

    public static void main(String[] args) {
        LinkedListRemoveFirstExplicado list = new LinkedListRemoveFirstExplicado();

        // Test cases
        System.out.println("Test 1: Remove from empty list");
        Node removed = list.removeFirst();
        System.out.println("Removed: " + (removed != null ? removed.value : "null"));

        System.out.println("\nTest 2: Remove from single-node list");
        list.append(10);
        removed = list.removeFirst();
        System.out.println("Removed: " + removed.value);
        list.printList();
        System.out.println("Length: " + list.length);

        System.out.println("\nTest 3: Remove from multi-node list");
        list.append(20);
        list.append(30);
        list.append(40);
        removed = list.removeFirst();
        System.out.println("Removed: " + removed.value);
        list.printList();
        System.out.println("Length: " + list.length);
    }
}
