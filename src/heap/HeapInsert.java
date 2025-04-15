package heap;

import java.util.ArrayList;

public class HeapInsert {
    private ArrayList<Integer> heap;

    public HeapInsert() {
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
        // Adiciona o novo valor ao final do heap
        heap.add(value);

        // Restaura a propriedade do Max Heap
        int current = heap.size() - 1; // Índice do elemento recém-inserido
        while (current > 0) {
            int parentIndex = parent(current);
            if (heap.get(current) > heap.get(parentIndex)) {
                // Troca com o pai caso o valor atual seja maior que o do pai
                swap(current, parentIndex);
                current = parentIndex;
            } else {
                // Se a propriedade de Max Heap for satisfeita, interrompe o loop
                break;
            }
        }
    }

    public static void main(String[] args) {
        HeapInsert heap = new HeapInsert();
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);

        System.out.println(heap.getHeap()); // Saída: [30, 20, 5, 10]
    }
}

