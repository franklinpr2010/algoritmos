package mergesort;

public class Merge {
    // Método estático para combinar dois arrays ordenados
    public static int[] merge(int[] array1, int[] array2) {
        // Criação do array combinado com o tamanho adequado
        int[] combined = new int[array1.length + array2.length];

        // Inicialização dos índices para os três arrays
        int index = 0, i = 0, j = 0;

        // Laço principal para mesclar elementos de ambos os arrays
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index++] = array1[i++]; // Adiciona o menor elemento de array1 ao combinado
            } else {
                combined[index++] = array2[j++]; // Adiciona o menor elemento de array2 ao combinado
            }
        }

        // Adiciona os elementos restantes de array1, se houver
        while (i < array1.length) {
            combined[index++] = array1[i++];
        }

        // Adiciona os elementos restantes de array2, se houver
        while (j < array2.length) {
            combined[index++] = array2[j++];
        }

        // Retorna o array combinado contendo todos os elementos em ordem crescente
        return combined;
    }

    // Método principal para testar o algoritmo
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5}; // Primeiro array ordenado
        int[] array2 = {2, 4, 6}; // Segundo array ordenado

        int[] result = merge(array1, array2); // Chamando o método merge

        // Imprime o array resultante
        System.out.print("Array combinado: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
