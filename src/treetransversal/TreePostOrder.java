package treetransversal;

import java.util.ArrayList;

import java.util.ArrayList;

public class TreePostOrder {
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
     * Método DFS Pós-Ordem usando classe interna Traverse
     * @return ArrayList com os valores dos nós na ordem de visita pós-ordem
     */
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> resultados = new ArrayList<>();

        // Classe interna para realizar o percurso
        class Traverse {
            Traverse(Node noAtual) {
                // 1. Percorre subárvore esquerda (se existir)
                if (noAtual.esquerda != null) {
                    new Traverse(noAtual.esquerda);
                }

                // 2. Percorre subárvore direita (se existir)
                if (noAtual.direita != null) {
                    new Traverse(noAtual.direita);
                }

                // 3. Visita o nó atual (pós-ordem)
                resultados.add(noAtual.valor);
            }
        }

        if (raiz != null) {
            new Traverse(raiz);  // Inicia o percurso pela raiz
        }

        return resultados;
    }

    /**
     * Versão alternativa usando método recursivo auxiliar
     * @return ArrayList com os valores dos nós na ordem de visita pós-ordem
     */
    public ArrayList<Integer> DFSPostOrderAlt() {
        ArrayList<Integer> resultados = new ArrayList<>();
        DFSPostOrderRec(raiz, resultados);
        return resultados;
    }

    // Método auxiliar recursivo para a versão alternativa
    private void DFSPostOrderRec(Node no, ArrayList<Integer> resultados) {
        if (no == null) return;

        DFSPostOrderRec(no.esquerda, resultados);  // Percorre esquerda
        DFSPostOrderRec(no.direita, resultados);   // Percorre direita
        resultados.add(no.valor);                  // Visita o nó
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
        TreePostOrder arvore = new TreePostOrder();

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

        // Testando DFS Pós-Ordem (versão com classe interna)
        System.out.println("\nPercurso DFS Pós-Ordem (classe interna):");
        ArrayList<Integer> resultadoDFS1 = arvore.DFSPostOrder();
        System.out.println(resultadoDFS1);

        // Testando DFS Pós-Ordem (versão alternativa recursiva)
        System.out.println("\nPercurso DFS Pós-Ordem (método recursivo):");
        ArrayList<Integer> resultadoDFS2 = arvore.DFSPostOrderAlt();
        System.out.println(resultadoDFS2);

        // Verificando a ordem correta
        System.out.println("\nOrdem esperada: [15, 25, 20, 35, 45, 40, 30, 65, 60, 80, 70, 50]");
    }
}