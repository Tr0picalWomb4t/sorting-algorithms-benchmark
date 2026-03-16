import sorters.SelectionSort;
import sorters.InsertionSort;
import sorters.BubbleSort;
import sorters.SortingAlgorithm;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        printColored("\u001B[32m╔════════════════════════════════════╗\u001B[0m");
        printColored("\u001B[32m║    \u001B[1mSORTING ALGORITHMS BENCHMARK\u001B[0m\u001B[32m    ║\u001B[0m");
        printColored("\u001B[32m╚════════════════════════════════════╝\u001B[0m\n");
        
        System.out.print("\u001B[33mDimensione array \u001B[90m[10-1000, def. 10]\u001B[0m: \u001B[33m");
        int size = getInt(scanner, 10, 10, 1000);
        System.out.print("\u001B[33mMax valore \u001B[90m[1-∞, def. 1M]\u001B[0m: \u001B[33m");
        int maxValue = getInt(scanner, 1000000, 1);
        
        int[] array = generateRandomArray(size, maxValue);
        printArray("\u001B[36m📊 Array iniziale\u001B[0m", array, true);
        
        printSorterMenu();
        System.out.print("\u001B[33m➤ Scelta: \u001B[0m");
        int choice = getInt(scanner, 0, 1, 3);
        
        SortingAlgorithm sorter = switch (choice) {
            case 1 -> new SelectionSort();
            case 2 -> new InsertionSort();
            case 3 -> new BubbleSort();
            default -> null;
        };
        
        if (sorter != null) {
            System.out.println("\n\u001B[32m🚀 Avvio " + sorter.getName() + "...\u001B[0m");
            long start = System.currentTimeMillis();
            int[] toSort = array.clone();
            sorter.sortWithSteps(toSort);
            long end = System.currentTimeMillis();
            
            printArray("\u001B[32m✅ Ordinato!\u001B[0m", toSort, false);
            printColored("\u001B[31m⏱️ Tempo: \u001B[1m" + (end - start) + "\u001B[0m\u001B[31m ms\u001B[0m");
        }
        scanner.close();
    }
    
    private static void printSorterMenu() {
        printColored("\u001B[35m╭── Algoritmi disponibili ──╮");
        printColored("\u001B[35m│ 1. 🎯 Selection Sort       │");
        printColored("\u001B[35m│ 2. 🔄 Insertion Sort       │");
        printColored("\u001B[35m│ 3. 🫧 Bubble Sort          │");
        printColored("\u001B[35m╰───────────────────────────╯\u001B[0m");
    }

    private static int getInt(Scanner scanner, int defaultValue, int min, int max) {
        try {
            String input = scanner.nextLine().trim();
            int value = input.isEmpty() ? defaultValue : Integer.parseInt(input);
            return Math.max(min, Math.min(max, value));
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    private static int getInt(Scanner scanner, int defaultValue, int min) {
        try {
            String input = scanner.nextLine().trim();
            int value = input.isEmpty() ? defaultValue : Integer.parseInt(input);
            return Math.max(min, value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private static void printColored(String text) {
        System.out.println(text);
    }

    private static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue + 1);
        }
        return array;
    }

    private static void printArray(String label, int[] array, boolean extraLine) {
        System.out.println();
        System.out.print(label + ": ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        if (extraLine) System.out.println();
    }

    public static void printArrayShort(int[] array) {
        for (int i : array) System.out.printf("%d ", i);
        System.out.println();
    }

}
