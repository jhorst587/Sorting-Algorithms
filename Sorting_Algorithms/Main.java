public class Main {


    public static void printArray(int[] a){
        System.out.print("[");
        for (int i = 0; i < a.length - 1; i++){
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1] + "]\n");
    }

    /**
     *  This program tests several sorting algorithms by taking the average time to sort an array with 5000 elements
     *  out of 10 iterations and prints the results to the console. The sorting algorithms tested are bubble sort,
     *  quick sort, shell sort, selection sort, insertion sort and merge sort.
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

        System.out.println("Bubble sort: " + bubble.testReturn(10, 5000));
        System.out.println("Quick sort: " + quick.testReturn(10, 5000));
        System.out.println("Shell sort: " + shell.testReturn(10, 5000));
        System.out.println("Selection sort: " + select.testReturn(10, 5000));
        System.out.println("Insertion sort: " + insert.testReturn(10, 5000));
        System.out.println("Merge sort:" + merge.testReturn(10, 5000));

        /*
        System.out.println("Bubble sort:");
        bubble.test(10, 5000);
        System.out.println("Quick sort:");
        quick.test(10, 5000);
        System.out.println("Shell sort:");
        shell.test(10, 5000);
        System.out.println("Selection sort:");
        select.test(10, 5000);
        System.out.println("Insertion sort:");
        insert.test(10, 5000);
        System.out.println("Merge sort:");
        merge.test(10, 5000);
        */
    }
}
