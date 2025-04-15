package heap;

import java.util.ArrayList;

import java.util.ArrayList;

public class HeapRemove {
    private ArrayList<Integer> heap;

    public HeapRemove() {
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

    public void sinkDown(int index) {
        // Implementação fictícia para ilustrar: substitua pelo método correto
        int largest = index;
        while (true) {
            int left = leftChild(largest);
            int right = rightChild(largest);

            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != index) {
                swap(largest, index);
                index = largest;
            } else {
                break;
            }
        }
    }

    public Integer remove() {
        // Caso o heap esteja vazio
        if (heap.isEmpty()) {
            return null;
        }

        // Caso o heap tenha apenas um elemento
        if (heap.size() == 1) {
            return heap.remove(0);
        }

        // Remover o elemento raiz (maior elemento no Max Heap)
        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1)); // Move o último elemento para a raiz
        sinkDown(0); // Restaura a propriedade do Max Heap

        return maxValue;
    }

    public static void main(String[] args) {
        HeapRemove heap = new HeapRemove();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);

        System.out.println("Heap antes da remoção: " + heap.getHeap()); // [30, 20, 5, 10]

        int removido = heap.remove();
        System.out.println("Elemento removido: " + removido); // 30
        System.out.println("Heap após a remoção: " + heap.getHeap()); // [20, 10, 5]
    }
}
