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

---

# 🖥 Program Usage

When the program starts, it will ask for some input parameters:

* **Array Size** → number of elements to generate
* **Maximum Value** → highest possible value in the random array
* **Algorithm Choice** → which sorting algorithm to run

After selecting an algorithm, the program will:

1. Generate a random array
2. Show the **sorting process step-by-step**
3. Print the **final sorted array**
4. Display the **execution time**

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
