package sorters;

public interface SortingAlgorithm {
    void sort(int[] array);
    String getName();
    void sortWithSteps(int[] array);
    
    static void printArrayShort(int[] array) {
        System.out.printf("\u001B[90m[\u001B[0m");
        for (int i = 0; i < array.length; i++) {
            String num = String.format("%-4d", array[i]);
            System.out.print("\u001B[37m" + num + "\u001B[0m");
        }
        System.out.println("\u001B[90m]\u001B[0m");
    }

}
