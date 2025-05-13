package tree;

public class TreeMinimumValue {
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
     * Encontra o menor valor a partir de um nó específico
     * @param noAtual Nó inicial para busca
     * @return O menor valor na subárvore
     */
    public int minValue(Node noAtual) {
        // Percorre para a esquerda até encontrar o nó mais à esquerda
        while (noAtual.esquerda != null) {
            noAtual = noAtual.esquerda;
        }
        return noAtual.valor;
    }

    /**
     * Método público para encontrar o menor valor da árvore inteira
     * @return O menor valor na árvore
     * @throws IllegalStateException se a árvore estiver vazia
     */
    public int minValue() {
        if (raiz == null) {
            throw new IllegalStateException("Árvore vazia - não há valor mínimo");
        }
        return minValue(raiz);
    }

    // Métodos auxiliares (já implementados anteriormente)
    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return;
        }

        Node atual = raiz;
        while (true) {
            if (valor < atual.valor) {
                if (atual.esquerda == null) {
                    atual.esquerda = new Node(valor);
                    return;
                }
                atual = atual.esquerda;
            } else if (valor > atual.valor) {
                if (atual.direita == null) {
                    atual.direita = new Node(valor);
                    return;
                }
                atual = atual.direita;
            } else {
                return;  // Valor duplicado, não insere
            }
        }
    }

    public void emOrdem() {
        System.out.print("Percurso em ordem: ");
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
        TreeMinimumValue arvore = new TreeMinimumValue();

        // Construindo a árvore de exemplo
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45};
        for (int valor : valores) {
            arvore.inserir(valor);
        }

        System.out.println("Árvore construída:");
        arvore.emOrdem();

        // Testando o método minValue()
        System.out.println("\nTestando minValue():");
        System.out.println("Menor valor da árvore toda: " + arvore.minValue());

        // Testando a partir de subárvores
        System.out.println("\nTestando a partir de subárvores:");
        System.out.println("Menor valor da subárvore esquerda (30): " +
                arvore.minValue(arvore.raiz.esquerda));
        System.out.println("Menor valor da subárvore direita (70): " +
                arvore.minValue(arvore.raiz.direita));
        System.out.println("Menor valor da subárvore (40): " +
                arvore.minValue(arvore.raiz.esquerda.direita));

        // Testando com árvore vazia
        try {
            TreeMinimumValue arvoreVazia = new TreeMinimumValue();
            System.out.println("\nTestando árvore vazia:");
            System.out.println("Menor valor: " + arvoreVazia.minValue());
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}




