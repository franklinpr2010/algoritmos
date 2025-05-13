package treetransversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBreadthFirstSerach {
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
     * Realiza uma busca em largura (BFS) na árvore
     * @return ArrayList com os valores dos nós na ordem de visita
     */
    public ArrayList<Integer> BFS() {
        ArrayList<Integer> resultados = new ArrayList<>();
        if (raiz == null) {
            return resultados;  // Retorna lista vazia se árvore vazia
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);  // Inicia a fila com a raiz

        while (!fila.isEmpty()) {
            Node noAtual = fila.remove();  // Remove o primeiro nó da fila
            resultados.add(noAtual.valor);  // Adiciona o valor ao resultado

            // Adiciona filhos à fila se existirem
            if (noAtual.esquerda != null) {
                fila.add(noAtual.esquerda);
            }
            if (noAtual.direita != null) {
                fila.add(noAtual.direita);
            }
        }

        return resultados;
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
        TreeBreadthFirstSerach arvore = new TreeBreadthFirstSerach();

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

        // Testando BFS
        System.out.println("\nPercurso BFS (em largura):");
        ArrayList<Integer> resultadoBFS = arvore.BFS();
        System.out.println(resultadoBFS);

        // Verificando a ordem correta
        System.out.println("\nOrdem esperada: [50, 30, 70, 20, 40, 60, 80, 15, 25, 35, 45, 65]");
    }
}