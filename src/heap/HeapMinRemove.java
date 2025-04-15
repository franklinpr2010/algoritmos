package heap;

import java.util.ArrayList;

public class HeapMinRemove {
    private ArrayList<Integer> heap;

    public HeapMinRemove() {
        heap = new ArrayList<>();
    }

    public ArrayList<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void sinkDown(int index) {
        int largest = index; // Começamos assumindo que o maior está no índice atual
        int left = leftChild(index);
        int right = rightChild(index);

        // Verifica se o filho esquerdo existe e é maior que o elemento atual
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        // Verifica se o filho direito existe e é maior que o maior elemento encontrado até agora
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // Se o maior elemento não está na posição atual, troque e continue afundando
        if (largest != index) {
            swap(index, largest);
            sinkDown(largest); // Recursivamente processa o novo índice do elemento
        }
    }


    public Integer remove() {
        // Caso especial: Se o heap estiver vazio, retorne null
        if (heap.isEmpty()) {
            return null;
        }

        // Caso especial: Se o heap tiver apenas um elemento, remova e retorne esse elemento
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        // Passo 1: Armazenar o elemento da raiz (mínimo valor)
        int minValue = heap.get(0);

        // Passo 2: Substituir a raiz pelo último elemento
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));

        // Remover o último elemento do heap
        heap.remove(lastIndex);

        // Passo 3: Ajustar o novo elemento da raiz para restaurar a propriedade de MinHeap
        sinkDown(0);

        // Passo 4: Retornar o valor original da raiz
        return minValue;
    }

    public void insert(int value) {
        // Passo 1: Adicionar o novo valor ao final do heap
        heap.add(value);

        // Passo 2: Recuperar o índice do elemento inserido
        int currentIndex = heap.size() - 1;

        // Passo 3: Restaurar a propriedade do MinHeap
        while (currentIndex > 0) {
            // Determinar o índice do pai
            int parentIndex = parent(currentIndex);

            // Verificar se o valor inserido é menor que o pai
            if (heap.get(currentIndex) < heap.get(parentIndex)) {
                // Trocar os elementos usando o método swap
                swap(currentIndex, parentIndex);

                // Atualizar o índice atual para o índice do pai
                currentIndex = parentIndex;
            } else {
                // Se o valor não for menor que o pai, o heap já está correto
                break;
            }
        }
    }

    public static void main(String[] args) {
        HeapMinRemove minHeap = new HeapMinRemove();
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(2);

        System.out.println(minHeap.remove()); // Deve imprimir 2
        System.out.println(minHeap.remove()); // Deve imprimir 5
        System.out.println(minHeap.remove()); // Deve imprimir 10
        System.out.println(minHeap.remove()); // Deve imprimir 20
        System.out.println(minHeap.remove()); // Deve imprimir null
    }
}
