package stackqueue;
public class QueueDequeue {
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
     * Remove e retorna o primeiro nó da fila (dequeue)
     * @return Nó removido ou null se fila estiver vazia
     */
    public No dequeue() {
        // 1. Verifica se a fila está vazia
        if (tamanho == 0) {
            return null;
        }

        // 2. Armazena o primeiro nó em uma variável temporária
        No temp = primeiro;

        // 3. Verifica se há apenas um elemento na fila
        if (tamanho == 1) {
            primeiro = null;
            ultimo = null;
        } else {
            // 4. Caso com mais de um elemento:
            //    a) Atualiza o primeiro para apontar para o próximo nó
            primeiro = primeiro.proximo;
            //    b) Desconecta o nó removido da fila
            temp.proximo = null;
        }

        // 5. Decrementa o tamanho da fila
        tamanho--;

        // 6. Retorna o nó removido
        return temp;
    }

    /**
     * Construtor para fila vazia
     */
    public QueueDequeue() {
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
        QueueDequeue fila = new QueueDequeue();

        // 1. Testar desenfileirar de fila vazia
        System.out.println("Tentando desenfileirar de fila vazia...");
        No removido = fila.dequeue();
        System.out.println("Nó removido: " + removido);

        // 2. Enfileirar alguns elementos
        System.out.println("\nEnfileirando 10, 20, 30...");
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        System.out.println("Tamanho da fila: " + fila.tamanho);

        // 3. Desenfileirar primeiro elemento
        System.out.println("\nDesenfileirando primeiro elemento...");
        removido = fila.dequeue();
        System.out.println("Valor removido: " + removido.valor);
        System.out.println("Novo primeiro: " + fila.primeiro.valor);
        System.out.println("Tamanho da fila: " + fila.tamanho);

        // 4. Desenfileirar até ficar com um elemento
        System.out.println("\nDesenfileirando segundo elemento...");
        removido = fila.dequeue();
        System.out.println("Valor removido: " + removido.valor);
        System.out.println("Primeiro e último são iguais? " +
                (fila.primeiro == fila.ultimo));
        System.out.println("Tamanho da fila: " + fila.tamanho);

        // 5. Desenfileirar último elemento
        System.out.println("\nDesenfileirando último elemento...");
        removido = fila.dequeue();
        System.out.println("Valor removido: " + removido.valor);
        System.out.println("Fila vazia? " + (fila.tamanho == 0));

        // 6. Verificar estado final
        System.out.println("\nEstado final da fila:");
        System.out.println("Primeiro: " + fila.primeiro);
        System.out.println("Último: " + fila.ultimo);
        System.out.println("Tamanho: " + fila.tamanho);
    }
}
