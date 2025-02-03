public class QuickSort implements SortingAlg{

    public static void main(String[] args){
        int[] A = {3, 2, 4, 6, 1, 7, 8, -11, 9};
        int[] Array = quick(A,0, A.length - 1);
        for(int i = 0; i < Array.length; i++){
            System.out.print(Array[i] + ", ");

        }
    }

    public static int[] quick(int[] A, int start, int end){
        if(end <= start){
            return A;
        }

        int high = partition(A, start, end);

        if(high - start <= end - (high + 1)){
            quick(A, start, high);
        }else{
            quick(A, high + 1, end);
        }

        return A;
    }

    public static int partition(int[] A, int startInd, int endInd){
        int midpoint = (startInd + endInd)/2;
        int pivot = A[midpoint];
        int low = startInd;
        int high = endInd;

        boolean done = false;

        while(!done){
//            System.out.println(low + " " + high);
            while(pivot > A[low]){
                low++;
            }

            while(pivot < A[high]){
                high--;
            }

            if(low >= high){
                done = true;
            }else{
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;
            }
        }
        return high;
    }

    @Override
    public int[] sorty(int[] A) {
        return quick(A, 0, A.length - 1);
    }
}
