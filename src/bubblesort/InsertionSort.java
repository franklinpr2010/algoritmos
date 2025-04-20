package bubblesort;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) { // Começa no segundo índice
            int temp = array[i]; // Armazena o valor atual
            int j = i - 1; // Inicializa o índice para comparar
            // Move os elementos maiores que temp uma posição à direita
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            // Insere temp na posição correta
            array[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        int[] array = {9, 5, 1, 4, 3};
        System.out.println("Array antes da ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        insertionSort(array); // Ordena o array

        System.out.println("Array depois da ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }


}
