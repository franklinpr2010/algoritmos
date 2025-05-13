package stackqueue;

    /**
     * Classe que implementa uma estrutura de pilha (Stack)
     * - Segue o princípio LIFO (Last In, First Out)
     * - Operações principais ocorrem no topo da pilha
     */
    class StackConstructor {
        private Node top;    // Referência para o nó no topo da pilha
        private int height;  // Contador de elementos na pilha

        /**
         * Construtor da pilha
         * @param value Valor do primeiro elemento da pilha
         */
        public StackConstructor(int value) {
            // Cria um novo nó com o valor fornecido
            Node newNode = new Node(value);

            // Inicializa o topo da pilha com o novo nó
            this.top = newNode;

            // Inicializa a altura como 1 (único elemento)
            this.height = 1;
        }

        // Métodos adicionais da pilha seriam implementados aqui
        // (push, pop, peek, etc.)

        /**
         * Método auxiliar para imprimir a pilha
         */
        public void printStack() {
            Node current = top;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }

        /**
         * Método auxiliar para obter a altura atual
         * @return Número de elementos na pilha
         */
        public int getHeight() {
            return height;
        }

        /**
         * Método auxiliar para obter o topo atual
         * @return Referência para o nó no topo
         */
        public Node getTop() {
            return top;
        }

        public static void main(String[] args) {
            // Exemplo de uso
            StackConstructor myStack = new StackConstructor(10);
            myStack.printStack();  // Saída: 10

            System.out.println("Topo: " + myStack.getTop().value);  // 10
            System.out.println("Altura: " + myStack.getHeight());   // 1
        }
}
