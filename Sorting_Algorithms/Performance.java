import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Performance {

    /**
     * This program tests several sorting algorithms and records the results in files. Each file contains 50 times
     * recorded (in milliseconds) for an individual algorithm to sort 5000 integers and an average of the 50 times. The
     * last file contains the results of a shorter test of each algorithm (only 10 iterations, still sorting 5000 elements)
     * and stores only the average of each of the algorithms' times. The sorting algorithms tested are bubble sort,
     * quick sort, shell sort, selection sort, insertion sort and merge sort.
     */
    public static void main(String[] args){
        BubbleSort b = new BubbleSort();
        QuickSort q = new QuickSort();
        ShellSort sh = new ShellSort();
        SelectionSort sel = new SelectionSort();
        InsertionSort i = new InsertionSort();
        MergeSort m = new MergeSort();

        Tester bubble = new Tester(b);
        Tester quick = new Tester(q);
        Tester shell = new Tester(sh);
        Tester select = new Tester(sel);
        Tester insert = new Tester(i);
        Tester merge = new Tester(m);


        bubble.testFile("BubbleSort.txt", 50, 5000);
        quick.testFile("QuickSort.txt", 50, 5000);
        shell.testFile("ShellSort.txt", 50, 5000);
        select.testFile("SelectionSort.txt", 50, 5000);
        insert.testFile("InsertionSort.txt", 50, 5000);
        merge.testFile("MergeSort.txt", 50, 5000);

        try {
            File averageTimes = new File("averageTimes.txt");
            if(averageTimes.delete()){
                System.out.println("File successfully deleted.");
            }

            if (averageTimes.createNewFile()) {
                System.out.println("File created: " + averageTimes.getName());
                FileWriter fw = new FileWriter(averageTimes);
                fw.write("Bubble sort: " + bubble.testReturn(10, 5000));
                fw.write("\nQuick sort: " + quick.testReturn(10, 5000));
                fw.write("\nShell sort: " + shell.testReturn(10, 5000));
                fw.write("\nSelection sort: " + select.testReturn(10, 5000));
                fw.write("\nInsertion sort: " + insert.testReturn(10, 5000));
                fw.write("\nMerge sort: " + merge.testReturn(10, 5000));

                fw.close();
            }
        } catch (IOException e){
            System.out.println("File could not be created.");
            e.printStackTrace();
        }
    }
}
