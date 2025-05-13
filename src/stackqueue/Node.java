package stackqueue;

/**
 * Classe que representa um nó da pilha
 * - Armazena um valor inteiro
 * - Mantém uma referência para o próximo nó
 */
class Node {
    int value;    // Valor armazenado no nó
    Node next;    // Referência para o próximo nó

    /**
     * Construtor do nó
     * @param value Valor a ser armazenado no nó
     */
    public Node(int value) {
        this.value = value;
        this.next = null;  // Novo nó inicia sem ligação
    }
}