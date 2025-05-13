package tree;

public class TreeInsert {
    private Node raiz;  // Raiz da árvore

    // Classe que representa cada nó da árvore
    class Node {
        int valor;      // Valor armazenado no nó
        Node esquerda;  // Referência para o filho esquerdo
        Node direita;   // Referência para o filho direito

        /**
         * Construtor do nó
         * @param valor Valor a ser armazenado no nó
         */
        Node(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    /**
     * Construtor da BST (árvore vazia)
     */
    public TreeInsert() {
        this.raiz = null;
    }

    /**
     * Insere um novo valor na árvore (método iterativo)
     * @param valor Valor a ser inserido
     * @return true se inserção foi bem sucedida, false se valor já existia
     */
    public boolean inserir(int valor) {
        Node novoNo = new Node(valor);  // 1. Cria novo nó

        // 2. Se árvore está vazia, novo nó vira raiz
        if (raiz == null) {
            raiz = novoNo;
            return true;
        }

        Node temp = raiz;  // 3. Nó temporário para percorrer a árvore

        while (true) {  // 4. Loop de travessia
            // 5. Verifica duplicata
            if (valor == temp.valor) {
                return false;
            }

            // 6. Verifica lado esquerdo (valores menores)
            if (valor < temp.valor) {
                if (temp.esquerda == null) {
                    temp.esquerda = novoNo;
                    return true;
                }
                temp = temp.esquerda;
            }
            // 7. Verifica lado direito (valores maiores)
            else {
                if (temp.direita == null) {
                    temp.direita = novoNo;
                    return true;
                }
                temp = temp.direita;
            }
        }
    }

    /**
     * Percorre a árvore em ordem (esquerda, raiz, direita)
     */
    public void emOrdem() {
        System.out.print("Percurso em ordem: ");
        emOrdem(raiz);
        System.out.println();
    }

    // Método auxiliar recursivo para percurso em ordem
    private void emOrdem(Node no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        TreeInsert arvore = new TreeInsert();

        System.out.println("Testando inserção na BST:");

        // Teste 1: Inserir na árvore vazia
        System.out.println("\nInserindo 50 (árvore vazia): " + arvore.inserir(50));
        arvore.emOrdem();

        // Teste 2: Inserir menor que raiz
        System.out.println("\nInserindo 30 (menor que raiz): " + arvore.inserir(30));
        arvore.emOrdem();

        // Teste 3: Inserir maior que raiz
        System.out.println("\nInserindo 70 (maior que raiz): " + arvore.inserir(70));
        arvore.emOrdem();

        // Teste 4: Inserir duplicata
        System.out.println("\nTentando inserir 50 novamente: " + arvore.inserir(50));
        arvore.emOrdem();

        // Teste 5: Inserir outros valores
        System.out.println("\nInserindo outros valores:");
        System.out.println("Inserindo 20: " + arvore.inserir(20));
        System.out.println("Inserindo 40: " + arvore.inserir(40));
        System.out.println("Inserindo 60: " + arvore.inserir(60));
        System.out.println("Inserindo 80: " + arvore.inserir(80));
        arvore.emOrdem();

        // Mostrar estrutura da árvore
        System.out.println("\nEstrutura final da BST:");
        System.out.println("      50");
        System.out.println("    /    \\");
        System.out.println("   30     70");
        System.out.println("  /  \\   /  \\");
        System.out.println("20   40 60   80");
    }
}
