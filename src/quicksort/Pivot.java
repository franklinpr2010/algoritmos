package quicksort;

import java.util.Arrays;

public class Pivot {

    // Método principal de pivot/partição
    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        // Inicializa o swapIndex com o pivotIndex
        int swapIndex = pivotIndex;

        // Percorre o array da posição após o pivô até o endIndex
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            // Se o elemento atual for menor que o pivô
            if (array[i] < array[pivotIndex]) {
                swapIndex++; // Avança o swapIndex
                swap(array, i, swapIndex); // Troca os elementos
            }
        }

        // Coloca o pivô na posição correta
        swap(array, pivotIndex, swapIndex);

        // Retorna o novo índice do pivô
        return swapIndex;
    }

    // Método auxiliar para trocar elementos do array
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static void main(String[] args) {
        // Teste 1: Array básico
        int[] array1 = {4, 8, 2, 1, 5, 7, 6, 3};
        System.out.println("Array original: " + Arrays.toString(array1));

        int pivotIndex1 = pivot(array1, 0, array1.length - 1);
        System.out.println("Após pivot (índice 0): " + Arrays.toString(array1));
        System.out.println("Novo índice do pivô: " + pivotIndex1);
        System.out.println();

        // Teste 2: Pivô no meio do array
        int[] array2 = {7, 3, 5, 1, 9, 4, 2};
        System.out.println("Array original: " + Arrays.toString(array2));

        int pivotIndex2 = pivot(array2, 2, array2.length - 1); // Pivô é o 5 (índice 2)
        System.out.println("Após pivot (índice 2): " + Arrays.toString(array2));
        System.out.println("Novo índice do pivô: " + pivotIndex2);
        System.out.println();

        // Teste 3: Array já ordenado
        int[] array3 = {1, 2, 3, 4, 5};
        System.out.println("Array original: " + Arrays.toString(array3));

        int pivotIndex3 = pivot(array3, 1, array3.length - 1); // Pivô é o 2 (índice 1)
        System.out.println("Após pivot (índice 1): " + Arrays.toString(array3));
        System.out.println("Novo índice do pivô: " + pivotIndex3);
    }
}