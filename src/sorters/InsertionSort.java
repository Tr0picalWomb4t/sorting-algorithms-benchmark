package sorters;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i], j = i - 1;
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j--];
            }
            array[j + 1] = curr;
        }
    }

    @Override
    public void sortWithSteps(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currVal = array[i];
            int j = i - 1;

            int shifts = 0;
            while (j >= 0 && array[j] > currVal) {
                array[j + 1] = array[j];
                j--;
                shifts++;
            }

            array[j + 1] = currVal;

            // Print step header
            System.out.printf("\u001B[90mIns%3d", currVal);
            if (shifts > 0) {
                System.out.printf(" ⇄x%2d:\u001B[0m", shifts);
            } else {
                System.out.print("     :\u001B[0m");
            }

            SortingAlgorithm.printArrayShort(array);
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }
}