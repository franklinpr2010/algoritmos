package tree;

public class TreeDelete {
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
     * Método público para remover um nó com valor específico
     * @param valor Valor do nó a ser removido
     */
    public void deleteNode(int valor) {
        raiz = deleteNode(raiz, valor);
    }

    /**
     * Método privado recursivo para remoção de nó
     * @param noAtual Nó atual sendo analisado
     * @param valor Valor a ser removido
     * @return Nó modificado após a remoção
     */
    private Node deleteNode(Node noAtual, int valor) {
        // Caso base: nó não encontrado ou árvore vazia
        if (noAtual == null) {
            return null;
        }

        // Busca pelo nó a ser removido
        if (valor < noAtual.valor) {
            // Valor menor, busca na subárvore esquerda
            noAtual.esquerda = deleteNode(noAtual.esquerda, valor);
        } else if (valor > noAtual.valor) {
            // Valor maior, busca na subárvore direita
            noAtual.direita = deleteNode(noAtual.direita, valor);
        } else {
            // Nó encontrado - verificar casos de remoção

            // Caso 1: Nó folha (sem filhos)
            if (noAtual.esquerda == null && noAtual.direita == null) {
                return null;
            }

            // Caso 2: Nó com apenas um filho (direito)
            else if (noAtual.esquerda == null) {
                return noAtual.direita;
            }

            // Caso 3: Nó com apenas um filho (esquerdo)
            else if (noAtual.direita == null) {
                return noAtual.esquerda;
            }

            // Caso 4: Nó com dois filhos
            else {
                // Encontra o menor valor na subárvore direita (sucessor in-order)
                int menorValor = minValue(noAtual.direita);
                // Substitui o valor do nó atual pelo menor valor encontrado
                noAtual.valor = menorValor;
                // Remove o nó que continha o menor valor (agora duplicado)
                noAtual.direita = deleteNode(noAtual.direita, menorValor);
            }
        }

        return noAtual;
    }

    /**
     * Encontra o menor valor a partir de um nó específico
     * @param no Nó inicial para busca
     * @return O menor valor na subárvore
     */
    private int minValue(Node no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no.valor;
    }

    // Métodos auxiliares para teste
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private Node inserirRec(Node no, int valor) {
        if (no == null) {
            return new Node(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRec(no.direita, valor);
        }

        return no;
    }

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(Node no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public static void main(String[] args) {
        TreeDelete arvore = new TreeDelete();

        // Construindo a árvore de exemplo
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45, 65};
        for (int valor : valores) {
            arvore.inserir(valor);
        }

        System.out.println("Árvore inicial:");
        arvore.emOrdem();

        // Testando remoção de nó folha
        System.out.println("\nRemovendo 15 (nó folha):");
        arvore.deleteNode(15);
        arvore.emOrdem();

        // Testando remoção de nó com um filho
        System.out.println("\nRemovendo 20 (nó com um filho):");
        arvore.deleteNode(20);
        arvore.emOrdem();

        // Testando remoção de nó com dois filhos
        System.out.println("\nRemovendo 30 (nó com dois filhos):");
        arvore.deleteNode(30);
        arvore.emOrdem();

        // Testando remoção da raiz
        System.out.println("\nRemovendo 50 (raiz):");
        arvore.deleteNode(50);
        arvore.emOrdem();

        // Testando remoção de valor não existente
        System.out.println("\nTentando remover 99 (valor não existente):");
        arvore.deleteNode(99);
        arvore.emOrdem();
    }
}
