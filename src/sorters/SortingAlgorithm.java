package sorters;

public interface SortingAlgorithm {

    /** Pure sorting without visualization */
    void sort(int[] array);

    /** Returns the name of the sorting algorithm */
    String getName();

    /** Sorting with step-by-step visualization */
    void sortWithSteps(int[] array);

    /** Utility: prints array in short format with colors */
    static void printArrayShort(int[] array) {
        System.out.printf("\u001B[90m[\u001B[0m"); // gray brackets
        for (int i = 0; i < array.length; i++) {
            String num = String.format("%-4d", array[i]);
            System.out.print("\u001B[37m" + num + "\u001B[0m"); // white numbers
        }
        System.out.println("\u001B[90m]\u001B[0m");
    }

}