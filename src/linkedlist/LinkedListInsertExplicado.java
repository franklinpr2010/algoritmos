package linkedlist;

/**
 * Classe que implementa uma lista encadeada simples
 * Class implementing a simple linked list
 */
class LinkedListInsertExplicado {
    private Node head;    // Referência para o primeiro nó / Reference to the first node
    private Node tail;    // Referência para o último nó / Reference to the last node
    private int length;   // Tamanho atual da lista / Current list length

    /**
     * Construtor da lista encadeada
     * Linked list constructor
     */
    public LinkedListInsertExplicado() {
        this.head = null;  // Lista inicia vazia / List starts empty
        this.tail = null;
        this.length = 0;
    }

    /**
     * Insere um novo nó em uma posição específica da lista
     * @param index Posição de inserção (0-based)
     * @param value Valor a ser inserido
     * @return true se inseriu com sucesso, false se índice inválido
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == this.length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node pre = get(index - 1);
        newNode.next = pre.next;
        pre.next = newNode;
        this.length++;

        return true;
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
     * Obtém o nó em uma posição específica da lista
     * @param index Índice do nó a ser recuperado (começa em 0)
     * @return Nó na posição especificada ou null se índice inválido
     */
    public Node get(int index) {
        // Verifica se o índice é válido
        if (index < 0 || index >= this.length) {
            return null;
        }

        Node temp = this.head;  // Começa no primeiro nó

        // Percorre a lista até chegar no índice desejado
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * Atualiza o valor de um nó em uma posição específica
     * @param index Posição do nó a ser atualizado
     * @param value Novo valor para o nó
     * @return true se atualizou com sucesso, false se índice inválido
     */
    public boolean set(int index, int value) {
        Node node = get(index);  // Reaproveita o método get existente

        if (node != null) {
            node.value = value;  // Atualiza o valor se o nó existe
            return true;
        }

        return false;  // Retorna false se índice inválido
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
        LinkedListInsertExplicado lista = new LinkedListInsertExplicado();

        // Preenche a lista inicialmente
        lista.append(10);
        lista.append(20);
        lista.append(30);

        System.out.println("Lista original:");
        lista.printList();  // Lista: 10 20 30

        // Testes do método insert
        System.out.println("\nInserindo no início (índice 0):");
        lista.insert(0, 5);
        lista.printList();  // Lista: 5 10 20 30

        System.out.println("\nInserindo no meio (índice 2):");
        lista.insert(2, 15);
        lista.printList();  // Lista: 5 10 15 20 30

        System.out.println("\nInserindo no final (índice igual ao tamanho):");
        lista.insert(5, 35);
        lista.printList();  // Lista: 5 10 15 20 30 35

        System.out.println("\nTentando inserir em índice inválido (6):");
        boolean resultado = lista.insert(6, 40);
        System.out.println("Resultado: " + resultado);  // false
    }
}
