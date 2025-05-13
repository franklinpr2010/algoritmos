package tree;

public class TreeContains {
    private Node raiz;  // Raiz da árvore

    // Classe que representa cada nó da árvore
    class Node {
        int valor;
        Node esquerda;
        Node direita;

        Node(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    /**
     * Verifica se um valor existe na árvore (método iterativo)
     * @param valor Valor a ser buscado
     * @return true se o valor existe, false caso contrário
     */
    public boolean contains(int valor) {
        Node temp = raiz;  // Começa pela raiz

        while (temp != null) {  // Percorre enquanto houver nós
            if (valor < temp.valor) {
                temp = temp.esquerda;  // Vai para esquerda se valor menor
            } else if (valor > temp.valor) {
                temp = temp.direita;   // Vai para direita se valor maior
            } else {
                return true;  // Valor encontrado
            }
        }
        return false;  // Valor não encontrado
    }

    // Métodos auxiliares (já implementados anteriormente)
    public void inserir(int valor) {
        // Implementação existente do insert
    }

    public void emOrdem() {
        // Implementação existente do percurso em ordem
    }

    public static void main(String[] args) {
        TreeContains arvore = new TreeContains();

        // Construindo a árvore de exemplo
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Árvore construída:");
        arvore.emOrdem();

        // Testando o método contains
        System.out.println("\nTestando contains:");
        System.out.println("Contém 50? " + arvore.contains(50));  // true
        System.out.println("Contém 30? " + arvore.contains(30));  // true
        System.out.println("Contém 70? " + arvore.contains(70));  // true
        System.out.println("Contém 20? " + arvore.contains(20));  // true
        System.out.println("Contém 40? " + arvore.contains(40));  // true
        System.out.println("Contém 60? " + arvore.contains(60));  // true
        System.out.println("Contém 80? " + arvore.contains(80));  // true
        System.out.println("Contém 25? " + arvore.contains(25));  // false
        System.out.println("Contém 55? " + arvore.contains(55));  // false
        System.out.println("Contém 90? " + arvore.contains(90));  // false

        // Testando com árvore vazia
        TreeContains arvoreVazia = new TreeContains();
        System.out.println("\nTestando árvore vazia:");
        System.out.println("Contém 10? " + arvoreVazia.contains(10));  // false
    }
}