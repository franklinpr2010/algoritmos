package quicksort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        // Testes do QuickSort
        int[] array1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original 1: " + Arrays.toString(array1));
        quickSort(array1);
        System.out.println("Array ordenado 1: " + Arrays.toString(array1));
        System.out.println();

        int[] array2 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original 2: " + Arrays.toString(array2));
        quickSort(array2);
        System.out.println("Array ordenado 2: " + Arrays.toString(array2));
        System.out.println();

        int[] array3 = {5, 1, 4, 2, 8};
        System.out.println("Array original 3: " + Arrays.toString(array3));
        quickSort(array3);
        System.out.println("Array ordenado 3: " + Arrays.toString(array3));
    }

    // Método público para iniciar o QuickSort
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    // Método helper recursivo do QuickSort
    private static void quickSortHelper(int[] array, int left, int right) {
        // Caso base: se o subarray tem 0 ou 1 elemento, já está ordenado
        if (left < right) {
            // Obtém o índice do pivô após a partição
            int pivotIndex = pivot(array, left, right);

            // Ordena recursivamente os elementos antes e depois do pivô
            quickSortHelper(array, left, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, right);
        }
    }

    // Método de partição (pivot)
    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, i, swapIndex);
            }
        }

        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    // Método auxiliar para trocar elementos
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}