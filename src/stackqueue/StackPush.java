package stackqueue;

    /**
     * Classe que implementa uma estrutura de pilha (Stack)
     * - Segue o princípio LIFO (Last In, First Out)
     * - Operações principais ocorrem no topo da pilha
     */
    class StackPush {
        private Node top;    // Referência para o nó no topo da pilha
        private int height;  // Contador de elementos na pilha


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
                * Adiciona um novo nó no topo da pilha
     * @param value Valor inteiro a ser adicionado na pilha
     */
        public void push(int value) {
            // 1. Cria um novo nó com o valor fornecido
            Node newNode = new Node(value);

            // 2. Verifica se a pilha está vazia (height == 0)
            if (height == 0) {
                // 3. Se vazia, o novo nó se torna o topo
                top = newNode;
            } else {
                // 4. Se não vazia:
                //    a) O próximo do novo nó aponta para o atual topo
                newNode.next = top;
                //    b) O novo nó se torna o novo topo
                top = newNode;
            }

            // 5. Incrementa a altura da pilha
            height++;
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

        /**
         * Método main para demonstrar o funcionamento da pilha
         */
        public static void main(String[] args) {
            StackPush pilha = new StackPush();

            System.out.println("Empilhando valores 10, 20 e 30...");
            pilha.push(10);
            pilha.push(20);
            pilha.push(30);

            System.out.println("\nEstado da pilha após empilhamento:");
            System.out.println("Topo: " + pilha.top.value);
            System.out.println("Próximo do topo: " + pilha.top.next.value);
            System.out.println("Altura da pilha: " + pilha.height);

            System.out.println("\nEmpilhando mais valores 40 e 50...");
            pilha.push(40);
            pilha.push(50);

            System.out.println("\nEstado final da pilha:");
            System.out.println("Topo: " + pilha.top.value);
            System.out.println("Próximo do topo: " + pilha.top.next.value);
            System.out.println("Altura da pilha: " + pilha.height);
        }
}
