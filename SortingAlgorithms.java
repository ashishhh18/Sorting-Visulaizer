public class SortingAlgorithms {
    public static void bubbleSort(int[] array, SortingPanel panel) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    panel.refresh(); 
                }
            }
        }
    }

    public static void selectionSort(int[] array, SortingPanel panel) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;

            panel.refresh(); 
        }
    }

    
}
