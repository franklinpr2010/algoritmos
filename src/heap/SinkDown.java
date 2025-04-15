package heap;

import java.util.ArrayList;

public class SinkDown {
    private ArrayList<Integer> heap;

    public SinkDown() {
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

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;
        while (current > 0) {
            int parentIndex = parent(current);
            if (heap.get(current) > heap.get(parentIndex)) {
                swap(current, parentIndex);
                current = parentIndex;
            } else {
                break;
            }
        }
    }

    public Integer remove() {
        if (heap.isEmpty()) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

    public static void main(String[] args) {
        SinkDown heap = new SinkDown();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);

        System.out.println("Heap inicial: " + heap.getHeap()); // [30, 20, 5, 10]

        heap.remove();
        System.out.println("Heap após remoção: " + heap.getHeap()); // [20, 10, 5]
    }
}
