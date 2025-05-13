package treetransversal;

import java.util.ArrayList;

public class TreeInOrder {
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
     * Método DFS In-Order usando classe interna Traverse
     * @return ArrayList com os valores dos nós na ordem de visita in-order
     */
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> resultados = new ArrayList<>();

        // Classe interna para realizar o percurso
        class Traverse {
            Traverse(Node noAtual) {
                // 1. Percorre subárvore esquerda (se existir)
                if (noAtual.esquerda != null) {
                    new Traverse(noAtual.esquerda);
                }

                // 2. Visita o nó atual (in-order)
                resultados.add(noAtual.valor);

                // 3. Percorre subárvore direita (se existir)
                if (noAtual.direita != null) {
                    new Traverse(noAtual.direita);
                }
            }
        }

        if (raiz != null) {
            new Traverse(raiz);  // Inicia o percurso pela raiz
        }

        return resultados;
    }

    /**
     * Versão alternativa usando método recursivo auxiliar
     * @return ArrayList com os valores dos nós na ordem de visita in-order
     */
    public ArrayList<Integer> DFSInOrderAlt() {
        ArrayList<Integer> resultados = new ArrayList<>();
        DFSInOrderRec(raiz, resultados);
        return resultados;
    }

    // Método auxiliar recursivo para a versão alternativa
    private void DFSInOrderRec(Node no, ArrayList<Integer> resultados) {
        if (no == null) return;

        DFSInOrderRec(no.esquerda, resultados);  // Percorre esquerda
        resultados.add(no.valor);                // Visita o nó
        DFSInOrderRec(no.direita, resultados);   // Percorre direita
    }

    // Métodos auxiliares para construção e teste da árvore
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

    public static void main(String[] args) {
        TreeInOrder arvore = new TreeInOrder();

        // Construindo a árvore de exemplo
        int[] valores = {50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45, 65};
        for (int valor : valores) {
            arvore.inserir(valor);
        }

        System.out.println("Árvore construída:");
        System.out.println("      50");
        System.out.println("    /    \\");
        System.out.println("   30     70");
        System.out.println("  /  \\   /  \\");
        System.out.println("20   40 60   80");
        System.out.println("/ \\  / \\  /");
        System.out.println("15 25 35 45 65");

        // Testando DFS In-Order (versão com classe interna)
        System.out.println("\nPercurso DFS In-Order (classe interna):");
        ArrayList<Integer> resultadoDFS1 = arvore.DFSInOrder();
        System.out.println(resultadoDFS1);

        // Testando DFS In-Order (versão alternativa recursiva)
        System.out.println("\nPercurso DFS In-Order (método recursivo):");
        ArrayList<Integer> resultadoDFS2 = arvore.DFSInOrderAlt();
        System.out.println(resultadoDFS2);

        // Verificando a ordem correta
        System.out.println("\nOrdem esperada: [15, 20, 25, 30, 35, 40, 45, 50, 60, 65, 70, 80]");
    }
}
