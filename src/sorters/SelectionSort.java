package sorters;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) minIdx = j;
            }
            swap(array, i, minIdx);
        }
    }
    
    @Override
    public void sortWithSteps(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            
            // Trova min
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            
            String action = minIdx != i ? " ↔swap!" : "       ";
            String header = String.format("\u001B[90mPasso%2d(min@%2d):%s\u001B[0m", i+1, minIdx, action);
            System.out.print(header);
            
            if (minIdx != i) {
                swap(array, i, minIdx);
            }
            
            SortingAlgorithm.printArrayShort(array);
        }
    }

    
    private void swap(int[] array, int i, int j) {
        int tmp = array[i]; array[i] = array[j]; array[j] = tmp;
    }
    
    @Override
    public String getName() { return "Selection Sort"; }
}
