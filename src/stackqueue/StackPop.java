package stackqueue;

    /**
     * Classe que implementa uma estrutura de pilha (Stack)
     * - Segue o princípio LIFO (Last In, First Out)
     * - Operações principais ocorrem no topo da pilha
     */
    class StackPop {
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
         * Remove e retorna o nó do topo da pilha.
         * @return O nó removido do topo, ou null se a pilha estiver vazia
         */
        public Node pop() {
            // 1. Verifica se a pilha está vazia
            if (height == 0) {
                return null;
            }

            // 2. Armazena o nó do topo atual em uma variável temporária
            Node temp = top;

            // 3. Atualiza o topo para apontar para o próximo nó
            top = top.next;

            // 4. Desconecta o nó removido da pilha
            temp.next = null;

            // 5. Decrementa a altura da pilha
            height--;

            // 6. Retorna o nó removido
            return temp;
        }

        /**
         * Método main para demonstrar o funcionamento da pilha
         */
        public static void main(String[] args) {
            // 1. Criar uma pilha e adicionar elementos
            StackPop minhaPilha = new StackPop();
            System.out.println("Criando pilha e empilhando 10, 20, 30...");
            minhaPilha.push(10);
            minhaPilha.push(20);
            minhaPilha.push(30);

            // 2. Mostrar o topo da pilha (sem remover)
            System.out.println("\nTopo da pilha: " + minhaPilha.top.value);

            // 3. Desempilhar um elemento
            Node removido = minhaPilha.pop();
            System.out.println("\nElemento removido: " + removido.value);
            System.out.println("Novo topo da pilha: " + minhaPilha.top.value);

            // 4. Desempilhar até esvaziar a pilha
            System.out.println("\nDesempilhando todos os elementos...");
            while (minhaPilha.pop() != null) {
                if (minhaPilha.top != null) {
                    System.out.println("Removido. Próximo topo: " + minhaPilha.top.value);
                } else {
                    System.out.println("Removido. Pilha vazia!");
                }
            }

            // 5. Tentar desempilhar de pilha vazia
            System.out.println("\nTentando desempilhar de pilha vazia...");
            Node resultado = minhaPilha.pop();
            System.out.println("Resultado: " + resultado);
        }

    }
