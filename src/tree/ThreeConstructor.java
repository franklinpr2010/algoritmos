package tree;

public class ThreeConstructor {
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
    public ThreeConstructor() {
        this.raiz = null;
    }

    /**
     * Insere um novo valor na árvore
     * @param valor Valor a ser inserido
     */
    public void inserir(int valor) {
        raiz = inserirNo(raiz, valor);
    }

    // Método auxiliar recursivo para inserção
    private Node inserirNo(Node no, int valor) {
        // Caso base: chegamos a um nó nulo, criamos um novo nó
        if (no == null) {
            return new Node(valor);
        }

        // Insere na subárvore esquerda se o valor for menor
        if (valor < no.valor) {
            no.esquerda = inserirNo(no.esquerda, valor);
        }
        // Insere na subárvore direita se o valor for maior
        else if (valor > no.valor) {
            no.direita = inserirNo(no.direita, valor);
        }

        // Retorna o nó (sem alteração se o valor já existir)
        return no;
    }

    /**
     * Percorre a árvore em ordem (esquerda, raiz, direita)
     */
    public void emOrdem() {
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
        ThreeConstructor arvore = new ThreeConstructor();

        System.out.println("Construindo BST...");
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Percurso em ordem:");
        arvore.emOrdem();

        System.out.println("\nEstrutura da BST:");
        System.out.println("      50");
        System.out.println("    /    \\");
        System.out.println("   30     70");
        System.out.println("  /  \\   /  \\");
        System.out.println("20   40 60   80");
    }
}
