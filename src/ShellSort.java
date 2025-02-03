public class ShellSort implements SortingAlg{

    public static void main(String[] args){
        int[] A = {3, 2, 4, 6, 1, 7, 8, -11, 9};
        int[] Array = shell(A, A.length);
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i] + ", ");

        }

    }

    public static int[] shell(int[] A, int gaps){
        if(gaps >=  1){
            for(int g = 0; g < A.length; g++){
                for(int i = 0; i < gaps; i++){
                    insertionSortInterleaved(A, i, gaps);
                }
                gaps /= 2;
            }
        }
        return A;
    }

    public static void insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
        for (int i = startIndex + gap; i < numbers.length; i += gap) {
            int j = i;
            while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
                int temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j -= gap;
            }
        }
    }

    @Override
    public int[] sorty(int[] A) {
        return shell(A, A.length);
    }
}
