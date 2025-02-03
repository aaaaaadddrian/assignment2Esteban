public class SelectionSort implements SortingAlg{

    public static void main(String[] args){

        int[] A = {3, 2, 4, 6, 1, 7, 8, -11, 9};
        int[] Array = select(A);
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i] + ", ");

        }
    }

    public static int[] select(int[] A){

        for(int i = 0; i < A.length - 1; i++){
            int indexSmallest = i;
            for(int j = i + 1; j < A.length; j++){
                if(A[j] < A[indexSmallest]){
                    indexSmallest = j;
                }
            }
            int temp = A[i];
            A[i] = A[indexSmallest];
            A[indexSmallest] = temp;
        }
        return A;
    }

    @Override
    public int[] sorty(int[] A) {
        return select(A);
    }
}
