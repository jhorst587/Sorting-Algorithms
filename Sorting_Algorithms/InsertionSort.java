public class InsertionSort implements SortingAlgorithm{
    public int[] sorty(int[] input){
        for(int i = 0; i < input.length; i++) {
            int j = i;
            while(j > 0 && input[j] < input[j - 1]){

                    int temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                    j--;
            }
        }
        return input;
    }
}
