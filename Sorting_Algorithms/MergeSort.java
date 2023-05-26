public class MergeSort implements SortingAlgorithm{

    public int[] sorty(int[] input){
        int midpoint = input.length / 2;
        mergesort(input, 0, input.length - 1);

        return input;
    }

    private static void mergesort(int[] input, int i, int k){
        int j = 0;
        if(i < k){
            j = (i + k) / 2;

            mergesort(input, i, j);
            mergesort(input,j + 1, k);

            merge(input, i, j, k);
        }
    }

    private static void merge(int[] numbers, int i, int j, int k) {
        int mergedSize = k - i + 1;                // Size of merged partition
        int[] mergedNumbers = new int[mergedSize]; // Dynamically allocates temporary
        // array for merged numbers
        int mergePos = 0;                          // Position to insert merged number
        int leftPos = i;                           // Initialize left partition position
        int rightPos = j + 1;                      // Initialize right partition position

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= j && rightPos <= k) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            }
            else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // If left partition is not empty, add remaining elements to merged numbers
        while (leftPos <= j) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition is not empty, add remaining elements to merged numbers
        while (rightPos <= k) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[i + mergePos] = mergedNumbers[mergePos];
        }
    }
}
