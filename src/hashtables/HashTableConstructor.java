package hashtables;

public class HashTableConstructor {
    private int tamanho = 7;          // Tamanho padrão da tabela
    private Node[] mapaDeDados;       // Array para armazenar os nós

    // Construtor da HashTable
    public HashTableConstructor() {
        mapaDeDados = new Node[tamanho];  // Inicializa o array com o tamanho definido
    }

    // Classe interna Node para armazenar pares chave-valor
    public class Node {
        private String chave;         // Chave do tipo String
        private int valor;           // Valor do tipo int
        private Node proximo;        // Referência para o próximo nó (encadeamento)

        // Construtor do Node
        public Node(String chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

}
