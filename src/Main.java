import sorters.SelectionSort;
import sorters.InsertionSort;
import sorters.BubbleSort;
import sorters.SortingAlgorithm;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] originalArray = null;
        boolean running = true;

        while (running) {
            printMainMenu();
            int mainChoice = readChoice(scanner, 1, 3);
            
            switch (mainChoice) {
                case 1 -> {
                    originalArray = createRandomArray(scanner);
                    if (originalArray != null) {
                        compareSortsLoop(scanner, originalArray);
                    }
                }
                case 2 -> {
                    originalArray = createManualArray(scanner);
                    if (originalArray != null) {
                        compareSortsLoop(scanner, originalArray);
                    }
                }
                case 3 -> {
                    printColored("\u001B[32m👋 Uscita dal programma!\u001B[0m");
                    running = false;
                }
            }
        }
        scanner.close();
    }
    
    private static void printMainMenu() {
        printColored("\u001B[32m╔════════════════════════════════════╗\u001B[0m");
        printColored("\u001B[32m║    \u001B[1;32mSORTING ALGORITHMS BENCHMARK\u001B[0m    ║\u001B[0m");
        printColored("\u001B[32m╚════════════════════════════════════╝\u001B[0m");
        printColored("\u001B[36m╭────────────────────────────────────╮\u001B[0m");
        printColored("\u001B[36m│ 1. 🎲 Genera array casuale         │\u001B[0m");
        printColored("\u001B[36m│ 2. ✏️  Inserisci array             │\u001B[0m");
        printColored("\u001B[36m│ 3. 🚪 Esci                         │\u001B[0m");
        printColored("\u001B[36m╰────────────────────────────────────╯\u001B[0m");
    }
    
    private static void compareSortsLoop(Scanner scanner, int[] originalArray) {
        printArray("\u001B[36m📊 Array originale\u001B[0m", originalArray, true);
        
        boolean backToMain = false;
        while (!backToMain) {
            printSorterMenu();
            int choice = readChoice(scanner, 0, 3);
            
            if (choice == 0) {
                backToMain = true;
                continue;
            }
            
            SortingAlgorithm sorter = switch (choice) {
                case 1 -> new SelectionSort();
                case 2 -> new InsertionSort();
                case 3 -> new BubbleSort();
                default -> null;
            };
            
            if (sorter != null) {
                System.out.println("\n\u001B[32m🚀 Running " + sorter.getName() + "...\u001B[0m");
                long start = System.currentTimeMillis();
                int[] toSort = originalArray.clone();
                sorter.sortWithSteps(toSort);
                long end = System.currentTimeMillis();
                
                printArray("\u001B[32m✅ Sorted!\u001B[0m", toSort, false);
                printColored("\u001B[31m⏱️  Time: \u001B[1m" + (end - start) + "\u001B[0m ms\u001B[0m");
            }
        }
    }

    private static int[] createRandomArray(Scanner scanner) {
        // ✅ CORRETTO: 5 parametri (default=10, min=10, max=1000)
        int size = getInt(scanner, 10, 10, 1000, "Array size \u001B[90m[10-1000, default 10]\u001B[0m");
        // ✅ CORRETTO: 5 parametri (default=1000000, min=1, max=Integer.MAX_VALUE)
        int maxValue = getInt(scanner, 1000000, 1, Integer.MAX_VALUE, "Max value \u001B[90m[1-∞, default 1M]\u001B[0m");
        
        int[] array = generateRandomArray(size, maxValue);
        printColored("\u001B[32m✅ Array casuale generato!\u001B[0m");
        return array;
    }

    private static int[] createManualArray(Scanner scanner) {
        // ✅ CORRETTO: 5 parametri (default=10, min=1, max=100)
        int size = getInt(scanner, 10, 1, 100, "Array size \u001B[90m[1-100, default 10]\u001B[0m");
        
        printPrompt("Inserisci " + size + " numeri separati da spazio: ");
        String[] inputs = scanner.nextLine().trim().split("\\s+");
        int[] array = new int[size];
        
        try {
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(inputs[i]);
            }
            printColored("\u001B[32m✅ Array inserito!\u001B[0m");
            return array;
        } catch (Exception e) {
            printColored("\u001B[31m❌ Errore input, riprova.\u001B[0m");
            return null;
        }
    }
    
    private static void printSorterMenu() {
        printColored("\u001B[35m╭────────────────────────────────────╮\u001B[0m");
        printColored("\u001B[35m│ 1. 🎯 Selection Sort               │\u001B[0m");
        printColored("\u001B[35m│ 2. 🔄 Insertion Sort               │\u001B[0m");
        printColored("\u001B[35m│ 3. 🫧 Bubble Sort                  │\u001B[0m");
        printColored("\u001B[35m│ 0. ⬅️  Torna al menu principale    │\u001B[0m");
        printColored("\u001B[35m╰────────────────────────────────────╯\u001B[0m");
    }

    // ✅ METODI INPUT SUPER PROFESSIONALI (invariati)
    private static int readChoice(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("\u001B[33m➤ Choice: \u001B[0m");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                printColored("\u001B[33m⚠️  Premi un numero da " + min + " a " + max + ":\u001B[0m");
                continue;
            }
            
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                printColored("\u001B[33m⚠️  Scegli tra " + min + "-" + max + ":\u001B[0m");
            } catch (NumberFormatException e) {
                printColored("\u001B[33m⚠️  Solo numeri:\u001B[0m");
            }
        }
    }

    private static int getInt(Scanner scanner, int defaultValue, int min, int max, String prompt) {
        while (true) {
            System.out.print("\u001B[33m" + prompt + ": \u001B[33m");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) return defaultValue;
            
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    printColored("\u001B[33m⚠️  Fuori range [" + min + "-" + max + "], riprova:\u001B[0m");
                }
            } catch (NumberFormatException e) {
                printColored("\u001B[33m⚠️  Numero non valido:\u001B[0m");
            }
        }
    }

    private static void printPrompt(String message) {
        System.out.print("\u001B[36m" + message + "\u001B[33m");
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