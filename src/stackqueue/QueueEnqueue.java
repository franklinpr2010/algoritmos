package stackqueue;
public class QueueEnqueue {
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
     * Construtor para fila vazia
     */
    public QueueEnqueue() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    /**
     * Adiciona um novo elemento ao final da fila (enqueue)
     * @param valor Valor inteiro a ser adicionado na fila
     */
    public void enqueue(int valor) {
        // 1. Cria um novo nó com o valor fornecido
        No novoNo = new No(valor);

        // 2. Verifica se a fila está vazia
        if (tamanho == 0) {
            // 3. Se vazia, primeiro e último apontam para o novo nó
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            // 4. Se não vazia:
            //    a) O próximo do último nó atual aponta para o novo nó
            ultimo.proximo = novoNo;
            //    b) Atualiza o último para apontar para o novo nó
            ultimo = novoNo;
        }

        // 5. Incrementa o tamanho da fila
        tamanho++;
    }

    /**
     * Método main para demonstrar o funcionamento da fila
     */
    public static void main(String[] args) {
        // 1. Criar uma fila vazia
        QueueEnqueue fila = new QueueEnqueue();
        System.out.println("Fila criada. Tamanho inicial: " + fila.tamanho);

        // 2. Adicionar primeiro elemento (10)
        System.out.println("\nEnfileirando 10...");
        fila.enqueue(10);
        System.out.println("Primeiro: " + fila.primeiro.valor);
        System.out.println("Último: " + fila.ultimo.valor);
        System.out.println("Tamanho: " + fila.tamanho);

        // 3. Adicionar segundo elemento (20)
        System.out.println("\nEnfileirando 20...");
        fila.enqueue(20);
        System.out.println("Primeiro: " + fila.primeiro.valor);
        System.out.println("Último: " + fila.ultimo.valor);
        System.out.println("Tamanho: " + fila.tamanho);
        System.out.println("Próximo do primeiro: " + fila.primeiro.proximo.valor);

        // 4. Adicionar terceiro elemento (30)
        System.out.println("\nEnfileirando 30...");
        fila.enqueue(30);
        System.out.println("Primeiro: " + fila.primeiro.valor);
        System.out.println("Último: " + fila.ultimo.valor);
        System.out.println("Tamanho: " + fila.tamanho);

        // 5. Verificar estrutura da fila
        System.out.println("\nEstrutura completa da fila:");
        No atual = fila.primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}
