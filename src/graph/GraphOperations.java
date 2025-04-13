package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphOperations {

    private HashMap<String, ArrayList<String>> adjList;

    public GraphOperations() {
        this.adjList = new HashMap<>();
    }

    public boolean addEdge(String vertex1, String vertex2) {
        // Verifica se ambos os vértices existem na lista de adjacência
        if (!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) {
            return false; // Um ou ambos os vértices não foram encontrados
        }

        // Adiciona vertex2 à lista de adjacência de vertex1
        // Aqui, opcionalmente, você pode verificar se a aresta já existe para evitar duplicatas
        if (!adjList.get(vertex1).contains(vertex2)) {
            adjList.get(vertex1).add(vertex2);
        }

        // Adiciona vertex1 à lista de adjacência de vertex2
        if (!adjList.get(vertex2).contains(vertex1)) {
            adjList.get(vertex2).add(vertex1);
        }

        return true; // A aresta foi adicionada com sucesso
    }

    public boolean addVertex(String vertex) {
        // Verifica se o vértice já existe na lista de adjacência
        if (adjList.containsKey(vertex)) {
            return false; // Vértice já presente, não será adicionado
        }

        // Adiciona o vértice com uma nova lista vazia de arestas
        adjList.put(vertex, new ArrayList<String>());
        return true; // Vértice adicionado com sucesso
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        // Verifica se ambos os vértices existem na lista de adjacência
        if (!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) {
            return false; // Um ou ambos os vértices não foram encontrados
        }

        // Remove vertex2 da lista de adjacência de vertex1
        adjList.get(vertex1).remove(vertex2);

        // Remove vertex1 da lista de adjacência de vertex2
        adjList.get(vertex2).remove(vertex1);

        return true; // A aresta foi removida com sucesso
    }

    // Método auxiliar para imprimir o grafo (lista de adjacência)
    public void printGraph() {
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    public static void main(String[] args) {
        GraphOperations graph = new GraphOperations();

        // Adicionando vértices
        System.out.println("Adicionando vértices...");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // Adicionando arestas
        System.out.println("Adicionando arestas...");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        System.out.println("\nGrafo após adição de vértices e arestas:");
        graph.printGraph();

        // Removendo a aresta entre A e C
        System.out.println("\nRemovendo a aresta entre A e C...");
        graph.removeEdge("A", "C");

        System.out.println("\nGrafo após remoção da aresta entre A e C:");
        graph.printGraph();

        // Tentando remover uma aresta com um vértice inexistente
        System.out.println("\nTentando remover a aresta entre A e E (vértice inexistente)...");
        boolean removed = graph.removeEdge("A", "E");
        if (!removed) {
            System.out.println("Não foi possível remover a aresta entre A e E, pois um dos vértices não existe.");
        }
    }
}
