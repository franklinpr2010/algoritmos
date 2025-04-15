package heap;

import java.util.ArrayList;

public class SinkDownMinHeap {
    private ArrayList<Integer> heap;

    public SinkDownMinHeap() {
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
        int leftChildIndex, rightChildIndex, smallestIndex;

        // Continue until the node is a leaf or the min-heap property is satisfied
        while (true) {
            // Get the indices of the left and right children
            leftChildIndex = leftChild(index);
            rightChildIndex = rightChild(index);

            // Assume the smallest index is the current index
            smallestIndex = index;

            // Check if the left child exists and is smaller
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallestIndex)) {
                smallestIndex = leftChildIndex;
            }

            // Check if the right child exists and is smaller
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallestIndex)) {
                smallestIndex = rightChildIndex;
            }

            // If the smallest value is not the current node, swap and continue
            if (smallestIndex != index) {
                swap(index, smallestIndex);
                index = smallestIndex; // Move down to the child node
            } else {
                // If the min-heap property is satisfied, stop the process
                break;
            }
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
        SinkDownMinHeap minHeap = new SinkDownMinHeap();
        minHeap.insert(2);
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(15);

// Simulate removal of the root
        minHeap.getHeap().set(0, 25); // Manually violate min-heap property
        minHeap.sinkDown(0);          // Restore min-heap property

        System.out.println(minHeap.getHeap()); // Output should be: [5, 15, 10, 20]
    }
}
