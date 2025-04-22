package mergesort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        int[] sortedArray = mergeSort(array);

        System.out.print("Array ordenado: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
    public static int[] mergeSort(int[] array) {
        // Caso base: array com 1 elemento já está ordenado
        if (array.length <= 1) {
            return array;
        }

        // Calcula o índice do meio
        int midIndex = array.length / 2;

        // Divide o array em duas metades
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[array.length - midIndex];

        // Preenche as metades
        System.arraycopy(array, 0, leftHalf, 0, midIndex);
        System.arraycopy(array, midIndex, rightHalf, 0, array.length - midIndex);

        // Ordena recursivamente cada metade
        int[] leftSorted = mergeSort(leftHalf);
        int[] rightSorted = mergeSort(rightHalf);

        // Combina as metades ordenadas
        return merge(leftSorted, rightSorted);
    }

    private static int[] merge(int[] left, int[] right) {
        // Array resultante com tamanho da soma dos dois arrays
        int[] merged = new int[left.length + right.length];

        int leftIndex = 0, rightIndex = 0, mergedIndex = 0;

        // Enquanto houver elementos em ambos arrays
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                merged[mergedIndex++] = left[leftIndex++];
            } else {
                merged[mergedIndex++] = right[rightIndex++];
            }
        }

        // Copia os elementos restantes do array esquerdo (se houver)
        while (leftIndex < left.length) {
            merged[mergedIndex++] = left[leftIndex++];
        }

        // Copia os elementos restantes do array direito (se houver)
        while (rightIndex < right.length) {
            merged[mergedIndex++] = right[rightIndex++];
        }

        return merged;
    }
}
