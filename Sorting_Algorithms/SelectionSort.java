public class SelectionSort implements SortingAlgorithm{
    public int[] sorty(int[] input){
        int indexOfSmallest = 0;
        for(int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if(input[indexOfSmallest] > input[j]){
                    indexOfSmallest = j;
                }
            }
            int temp = input[i];
            input[i] = input[indexOfSmallest];
            input[indexOfSmallest] = temp;
            indexOfSmallest = i+1;
        }
        return input;
    }
}
