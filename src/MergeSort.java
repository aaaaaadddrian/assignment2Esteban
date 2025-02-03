public class MergeSort implements SortingAlg{
    public static void main(String[] args){
        int[] A = {3, 2, 4, 6, 1, 7, 8, -11, 9};
        mergingSorting(A, 0, A.length - 1);
        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + ", ");

        }

    }

    public static void merge(int[] A, int i, int j, int k){
        int[] merged = new int[k - i + 1];
        int mergePos = 0;
        int left = i;
        int right = j + 1;

        while(left <= j && right <= k){
            if(A[left] <= A[right]){
                merged[mergePos] = A[left];
                left++;
            }else{
                merged[mergePos] = A[right];
                right++;
            }
            mergePos++;
        }

        while(left <= j){
            merged[mergePos] = A[left];
            left++;
            mergePos++;
        }

        while(right <= k){
            merged[mergePos] = A[right];
            right++;
            mergePos++;
        }
        for(int l = 0; l < merged.length; l++){
            A[i + l] = merged[l];
        }
    }

    private static int[] mergingSorting(int[] A, int i, int k){
        int j = 0;

        if(i < k){
            j = (k + i)/2;

            mergingSorting(A, i, j);
            mergingSorting(A, j + 1, k);
            merge(A, i, j, k);

        }
        return A;
    }

    @Override
    public int[] sorty(int[] A) {
        return mergingSorting(A, 0, A.length - 1);
    }
}
