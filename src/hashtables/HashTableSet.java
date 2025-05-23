package hashtables;

public class HashTableSet {
    private int tamanho = 7;          // Tamanho padrão da tabela
    private Node[] dataMap;       // Array para armazenar os nós

    // Construtor da HashTable
    public HashTableSet() {
        dataMap = new Node[tamanho];  // Inicializa o array com o tamanho definido
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

    public Node[] getDataMap() {
        return dataMap;
    }

    public void printTable() {
        for(int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.chave + "= " + temp.valor + "}");
                temp = temp.proximo;
            }
        }
    }

    // Método para calcular o índice (hash)
    private int hash(String chave) {
        int hash = 0;
        char[] chars = chave.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int valorAscii = chars[i];
            hash = (hash + valorAscii * 23) % dataMap.length;
        }
        return hash;
    }

    // Método set (inserir/atualizar)
    public void set(String chave, int valor) {
        int indice = hash(chave); // Calcula o índice
        Node novoNo = new Node(chave, valor); // Cria novo nó

        // Se a posição estiver vazia, insere diretamente
        if (dataMap[indice] == null) {
            dataMap[indice] = novoNo;
        } else {
            Node temp = dataMap[indice];
            while (true) {
                // Se a chave já existe, ATUALIZA o valor (diferente do vídeo)
                if (temp.chave.equals(chave)) {
                    temp.valor = valor; // Sobrescreve o valor
                    return;
                }
                // Se chegou no final da lista, adiciona o novo nó
                if (temp.proximo == null) {
                    temp.proximo = novoNo;
                    return;
                }
                temp = temp.proximo; // Avança para o próximo nó
            }
        }
    }

}
