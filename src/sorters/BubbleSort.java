package sorters;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
        } while (swapped);
    }
    
    @Override
    public void sortWithSteps(int[] array) {
        int pass = 0;
        boolean swapped;
        do {
            swapped = false;
            pass++;
            int swaps = 0;
            
            System.out.printf("\u001B[90mPass%3d", pass);
            
            for (int i = 0; i < array.length - pass; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swapped = true;
                    swaps++;
                }
            }

            if (swaps > 0) {
                System.out.printf("(%2d): \u001B[0m", swaps);
            } else {
                System.out.print("    : \u001B[0m");
            }
            
            SortingAlgorithm.printArrayShort(array);
        } while (swapped);
    }


    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i]; array[i] = array[j]; array[j] = tmp;
    }
    
    @Override
    public String getName() { return "Bubble Sort"; }
}
