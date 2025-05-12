package linkedlist;

public class LinkedListConstructor {

    // Classe interna para representar um nó
    private class Node {
        int value; // Valor armazenado no nó
        Node next; // Referência para o próximo nó

        // Construtor da classe Node
        public Node(int value) {
            this.value = value;
            this.next = null; // Inicialmente, o próximo nó é nulo
        }
    }

    private Node head; // Referência para o primeiro nó da lista
    private Node tail; // Referência para o último nó da lista
    private int length; // Comprimento da lista

    // Construtor da classe LinkedList
    public LinkedListConstructor(int value) {
        Node newNode = new Node(value); // Cria um novo nó com o valor fornecido
        head = newNode; // O primeiro nó é o cabeçalho
        tail = newNode; // O último nó também é o cabeçalho, pois é o único nó
        length = 1; // Inicializa o comprimento da lista como 1
    }

    // Métodos adicionais podem ser implementados aqui (ex: adicionar, remover, etc.)

    // Método para obter o comprimento da lista
    public int getLength() {
        return length;
    }

    // Método para obter o valor do primeiro nó (cabeça)
    public int getHeadValue() {
        return head.value;
    }

    // Método para obter o valor do último nó (cauda)
    public int getTailValue() {
        return tail.value;
    }
}
