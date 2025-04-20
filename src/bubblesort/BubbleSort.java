package bubblesort;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) { // Itera do último índice ao primeiro
            for (int j = 0; j < i; j++) { // Itera de 0 até i-1
                if (array[j] > array[j + 1]) { // Compara elementos adjacentes
                    // Realiza a troca
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        bubbleSort(array);
        for (int num : array) {
            System.out.print(num + " "); // Saída: 2 3 4 5 8
        }
    }




}
