package bubblesort;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        // Loop externo: percorre o array do primeiro até o penúltimo elemento
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i; // Assume que o índice atual contém o menor elemento
            // Loop interno: busca o menor elemento no subarray restante
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) { // Compara elementos
                    minIndex = j; // Atualiza o índice do menor elemento
                }
            }
            // Troca o elemento do índice atual pelo menor encontrado, se necessário
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Cria um array de exemplo
        int[] array = {64, 25, 12, 22, 11};

        System.out.println("Array antes da ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Chama o método selectionSort para ordenar o array
        selectionSort(array);

        System.out.println("Array depois da ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
