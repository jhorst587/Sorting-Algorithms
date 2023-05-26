import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class runs tests a sorting algorithm by recording how long it takes to sort arrays of a given number of elements
 * and recording the time in milliseconds.
 */
public class Tester {

    SortingAlgorithm sa;
    Random rand;

    public Tester(SortingAlgorithm sa){
        this.sa = sa;
        rand = new Random();
    }

    /**
     * This method tests the sorting algorithm represented by the variable sa on a single array with a number of elements
     * equal to size. The time the algorithm takes to sort the array is returned in milliseconds.
     *
     * @param size the number of elements in the array to be sorted
     * @return the time the algorithm takes to sort the array in milliseconds
     */
    public double singleTest(int size){
        int[] numbers = new int[size];

        for(int i = 0; i < size; i++){
            numbers[i] = rand.nextInt();
        }

        double startTime = System.nanoTime();
        sa.sorty(numbers);
        double endTime = System.nanoTime();


        return (endTime - startTime) / 1000000; //convert to milliseconds
    }

    /**
     * This method prints out the amount of time in milliseconds for the sorting algorithm represented by the variable
     * sa for a given number of iterations on arrays of a given size.
     *
     * @param iterations number of iterations the sorting algorithm will be tested on
     * @param size the number of elements in the arrays to be sorted
     */
    public void test(int iterations, int size){
        int[] times = new int[size];
        for(int i = 0; i < iterations; i++){
            System.out.println(i + ": " + singleTest(size));
        }
    }

    /**
     * This method determines and returns the average time in milliseconds for the sorting algorithm represented by the
     * variable sa to sort an array of a given size over a given number of iterations.
     *
     * @param iterations number of iterations the sorting algorithm will be tested on
     * @param size the number of elements in the arrays to be sorted
     * @return the average time for an array to be sorted
     */
    public double testReturn(int iterations, int size){
        double totalTime = 0;
        for(int i = 0; i < iterations; i++){
            totalTime += singleTest(size);
        }
        return totalTime / iterations;
    }

    /**
     * This method creates a new file that contains the times for which the sorting algorithm represented by the variable
     * sa can sort an array of a given size. The number of times the algorithm is tested is determined by the parameter
     * iterations. At the bottom of the file, the average time over all iterations is listed.
     *
     * @param fileName name of the file to be created
     * @param iterations number of iterations the sorting algorithm will be tested on
     * @param size the number of elements in the arrays to be sorted
     * @return true if a new file was created, false if it was not able to be created
     */
    public boolean testFile(String fileName, int iterations, int size){
        File f = new File(fileName);

        if(f.delete()){
            System.out.println("File successfully deleted");
        }

        try {
            if (f.createNewFile()) {
                FileWriter fw = new FileWriter(f);
                System.out.println("File successfully created.");

                for(int i = 0; i < iterations; i++) {
                    fw.write(singleTest(size) + ("\n"));
                }
                fw.close();

                Scanner scan = new Scanner(f);
                double totalTime = 0;
                for(int i = 0; i < iterations; i++){
                    totalTime += scan.nextDouble();
                }

                double averageTime = totalTime / iterations;

                fw = new FileWriter(f, true);
                fw.write("Average time for " + iterations + " iterations: " + averageTime);
                fw.close();



                return true;
            }
        } catch (IOException e){
            System.out.println("File could not be created.");
            e.printStackTrace();
        }
        return false;
    }
}
