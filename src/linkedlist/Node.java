package linkedlist;
/**
 * Classe que representa um nó da lista encadeada
 * Class representing a node in the linked list
 */
class Node {
    int value;    // Valor armazenado no nó / Value stored in the node
    Node next;    // Referência para o próximo nó / Reference to the next node

    /**
     * Construtor do nó
     * Node constructor
     * @param value Valor a ser armazenado no nó / Value to be stored in the node
     */
    public Node(int value) {
        this.value = value;
        this.next = null;  // Inicialmente não aponta para nenhum nó / Initially points to no node
    }
}