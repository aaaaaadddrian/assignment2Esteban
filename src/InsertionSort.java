public class InsertionSort implements SortingAlg{

    public static void main(String [] args){
        int[] A = {3, 2, 4, 6, 1, 7, 8, -11, 9};
        int[] Array = insert(A);
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i] + ", ");

        }
    }

    public static int[] insert(int[] A){

        for(int i = 0; i < A.length; i++){
            for(int j = 1; j < A.length; j++){
                if(A[j] < A[j-1]){
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                    j--;
                }
            }
        }

        return A;
    }

    @Override
    public int[] sorty(int[] A) {
        return insert(A);
    }
}
