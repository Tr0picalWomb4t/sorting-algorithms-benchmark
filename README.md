# 📊 Sorting Algorithms Benchmark

**Sorting Algorithms Benchmark** is a small Java CLI program that generates a random array and allows the user to run different **sorting algorithms with step visualization**.
The goal of the project is to **study how classic sorting algorithms work internally**.

---

# 📦 Project Structure

```
src/
├── Main.java
└── sorters/
    ├── SortingAlgorithm.java
    ├── SelectionSort.java
    ├── InsertionSort.java
    └── BubbleSort.java
```

**Description**

* `Main.java` → program entry point and CLI interface
* `SortingAlgorithm.java` → interface that defines how every sorting algorithm must behave
* `SelectionSort.java` → implementation of Selection Sort
* `InsertionSort.java` → implementation of Insertion Sort
* `BubbleSort.java` → implementation of Bubble Sort

---

# 🧑‍💻 Opening the Project

You can open the project with any Java IDE or simply run it from the terminal.

### Using an IDE (recommended)

1. Open **IntelliJ IDEA**, **VS Code**, or **Eclipse**
2. Select **Open Project / Open Folder**
3. Choose the project root folder
4. Make sure the project is using **Java 17 or newer**

From there you can run `Main.java` directly from the IDE.

---

# 🚀 Running from the Terminal

1. Make sure **Java 17+** is installed:

```bash
java -version
```

2. Move to the project root folder.

3. Compile the project:

```bash
javac src/sorters/*.java src/Main.java
```

4. Run the program:

```bash
java -cp src Main
```

> ⚠️ **Important:** Do **not** use Code Runner in VS Code. Running via the terminal is _required_.
> 
> ⚠️ **Note:** Some special characters (e.g., emoji, Unicode symbols) may not display correctly in VS Code's integrated terminal. 
> This usually depends on the font settings. Users may need to adjust their terminal or font configuration if necessary.

---

## 🖥 Program Usage

When the program starts, it will ask the user to configure a few parameters before running the benchmark.

### Required Inputs

| Input             | Description                                           |
| ----------------- | ----------------------------------------------------- |
| **Array Size**    | Number of elements to generate (recommended: 10–1000) |
| **Maximum Value** | Maximum value for the randomly generated numbers      |
| **Algorithm**     | Sorting algorithm to execute                          |

### Execution Flow

The program will:

1. Generate a **random integer array**
2. Display the **initial array**
3. Run the selected **sorting algorithm**
4. Show the **sorting process step-by-step**
5. Print the **final sorted array**
6. Display the **execution time**

### Example Run

```
╔════════════════════════════════════╗
║    SORTING ALGORITHMS BENCHMARK    ║
╚════════════════════════════════════╝

Array size [10-1000, default 10]: 15
Max value [1-∞, default 1M]: 30

📊 Initial array: 16 1 23 12 25 26 17 21 12 6 28 1 19 14 30 

╭── Available algorithms ──╮
│ 1. 🎯 Selection Sort     │
│ 2. 🔄 Insertion Sort     │
│ 3. 🫧 Bubble Sort        │
╰──────────────────────────╯
➤ Choice: 2

🚀 Running Insertion Sort...
Ins 47 ⇄x 1: [47 62 38 74 56 41 89 50 74 81 47 36 31 73 42]
Ins 74     : [38 47 62 74 56 41 89 50 74 81 47 36 31 73 42]
...

✅ Sorted!: 31 36 38 41 42 47 47 50 56 62 73 74 74 81 89 
⏱️ Time: 11 ms
```

During execution the program prints **intermediate sorting steps**, allowing the user to observe how the array changes while the algorithm progresses.

---

# 📌 Features

* Interactive CLI interface
* Step-by-step sorting visualization
* ANSI colored output
* Random array generation
* Execution time measurement
* Modular algorithm structure

---

# ➕ Implement Your Own Sorting Algorithm

If you want to add a new sorting algorithm, create a new file inside:

```
src/sorters/
```

Your class **must implement the `SortingAlgorithm` interface**, just like the existing algorithms.

Example structure:

```java
public class MySort implements SortingAlgorithm {

    @Override
    public void sort(int[] array) {
        // pure sorting implementation
    }

    @Override
    public void sortWithSteps(int[] array) {
        // sorting with step visualization
    }

    @Override
    public String getName() {
        return "My Sort";
    }
}
```

When implementing a new algorithm, it is recommended to **follow the style used in the existing ones**, including:

* code structure
* indentation
* ANSI color formatting
* step visualization format

The best approach is to **use the current sorting classes as a reference**.

After creating your algorithm, simply add it to the menu in `Main.java`.

---

# 🎯 Future Goals

* Add more algorithms (Quick Sort, Merge Sort, Heap Sort)
* Improve visualization formatting

---

# 📝 License

This project is open source and free to modify.
