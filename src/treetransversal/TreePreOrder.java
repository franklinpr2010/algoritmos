package treetransversal;

import java.util.ArrayList;

public class TreePreOrder {
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
     * Método DFS Pré-Ordem usando classe interna Traverse
     * @return ArrayList com os valores dos nós na ordem de visita pré-ordem
     */
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> resultados = new ArrayList<>();

        // Classe interna para realizar o percurso
        class Traverse {
            Traverse(Node noAtual) {
                // 1. Visita o nó atual (pré-ordem)
                resultados.add(noAtual.valor);

                // 2. Percorre subárvore esquerda
                if (noAtual.esquerda != null) {
                    new Traverse(noAtual.esquerda);
                }

                // 3. Percorre subárvore direita
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
     * @return ArrayList com os valores dos nós na ordem de visita pré-ordem
     */
    public ArrayList<Integer> DFSPreOrderAlt() {
        ArrayList<Integer> resultados = new ArrayList<>();
        DFSPreOrderRec(raiz, resultados);
        return resultados;
    }

    // Método auxiliar recursivo para a versão alternativa
    private void DFSPreOrderRec(Node no, ArrayList<Integer> resultados) {
        if (no == null) return;

        resultados.add(no.valor);            // Visita o nó
        DFSPreOrderRec(no.esquerda, resultados);  // Percorre esquerda
        DFSPreOrderRec(no.direita, resultados);   // Percorre direita
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
        TreePreOrder arvore = new TreePreOrder();

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

        // Testando DFS Pré-Ordem (versão com classe interna)
        System.out.println("\nPercurso DFS Pré-Ordem (classe interna):");
        ArrayList<Integer> resultadoDFS1 = arvore.DFSPreOrder();
        System.out.println(resultadoDFS1);

        // Testando DFS Pré-Ordem (versão alternativa recursiva)
        System.out.println("\nPercurso DFS Pré-Ordem (método recursivo):");
        ArrayList<Integer> resultadoDFS2 = arvore.DFSPreOrderAlt();
        System.out.println(resultadoDFS2);

        // Verificando a ordem correta
        System.out.println("\nOrdem esperada: [50, 30, 20, 15, 25, 40, 35, 45, 70, 60, 65, 80]");
    }
}