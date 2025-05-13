package stackqueue;

public class QueueConstructor {
    private No primeiro;  // Referência ao primeiro nó da fila
    private No ultimo;    // Referência ao último nó da fila
    private int tamanho;  // Tamanho atual da fila

    // Classe interna que representa um nó da fila
    class No {
        int valor;       // Valor armazenado no nó
        No proximo;      // Referência ao próximo nó na fila

        /**
         * Construtor do nó
         * @param valor Valor inteiro a ser armazenado no nó
         */
        No(int valor) {
            this.valor = valor;
        }
    }

    /**
     * Construtor da fila que cria uma fila com um elemento
     * @param valor Valor do primeiro elemento da fila
     */
    public QueueConstructor(int valor) {
        No novoNo = new No(valor);  // Cria um novo nó com o valor fornecido
        primeiro = novoNo;          // O primeiro nó aponta para o novo nó
        ultimo = novoNo;            // O último nó também aponta para o novo nó (único elemento)
        tamanho = 1;                // Inicializa o tamanho como 1
    }

    /**
     * Método main para demonstrar o funcionamento da fila
     */
    public static void main(String[] args) {
        // 1. Criar uma fila com valor inicial 10
        System.out.println("Criando fila com valor inicial 10...");
        QueueConstructor minhaFila = new QueueConstructor(10);

        // 2. Verificar estado inicial da fila
        System.out.println("\nEstado inicial da fila:");
        System.out.println("Primeiro elemento: " + minhaFila.primeiro.valor);
        System.out.println("Último elemento: " + minhaFila.ultimo.valor);
        System.out.println("Tamanho da fila: " + minhaFila.tamanho);

        // 3. Verificar que primeiro e último apontam para o mesmo nó
        System.out.println("\nVerificando referências:");
        System.out.println("Primeiro e último são o mesmo nó? " +
                (minhaFila.primeiro == minhaFila.ultimo));
        System.out.println("Próximo do primeiro é null? " +
                (minhaFila.primeiro.proximo == null));
    }
}
