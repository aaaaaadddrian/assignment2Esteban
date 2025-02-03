public class BubbleSort implements SortingAlg{
    public static void main(String [] args){

        int[] A = {3, 2, 4, 6, 1, 7, 8, -11, 9};
        int[] Array = bubble(A);
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i] + ", ");

        }
    }

    public static int[] bubble(int[] A){

        for(int i = 0; i < A.length - 1; i++){
            for(int j = 0; j < A.length - i - 1; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }

    @Override
    public int[] sorty(int[] A) {
        return bubble(A);
    }
}
