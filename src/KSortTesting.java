import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class KSortTesting {

    public static void main(String[] args) {

        File output = new File("outputKSort.txt");

        SortingAlg[] sorts = {new InsertionSort(), new BubbleSort(), new SelectionSort(), new ShellSort(), new QuickSort(), new MergeSort()};
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        try {
            PrintWriter writer = new PrintWriter(output, StandardCharsets.UTF_8);

            for(int i = 0; i < sorts.length; i++){
                writer.println(sorts[i]);
                writer.println("******************************************************");
                writer.println();
                for(int j = 0; j < sizes.length; j++){
                    writer.println("Sorted " + sizes[j] + " elements in " + multiTest(20, sizes[j], sorts[i]) + " seconds.");
                }
            }

            writer.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static double singleTest(int sizeOfArray, SortingAlg sorty) {
        Random gen = new Random();
        int[] A = new int[sizeOfArray];
        for (int i = 0; i < sizeOfArray; i++) {
            A[i] = gen.nextInt();
        }

        int[] gaps = {10};
        int[] B = shellSort(A, gaps);


        double startTime = (double) System.nanoTime() / 1000000000;
        sorty.sorty(B);
        double endTime = (double) System.nanoTime() / 1000000000;

        double totalTime = endTime - startTime;
        System.out.println(totalTime);
        return totalTime;

    }

    public static String multiTest(int iterations, int size, SortingAlg sorty){
        double total = 0;
        for(int i = 0; i < iterations; i++){
            total = total + singleTest(size, sorty);
        }
        double avg = total / iterations;
        return "" + avg;
    }


    public static int[] shellSort(int[] numbers, int[] gapValues) {
        for (int g = 0; g < gapValues.length; g++) {
            for (int i = 0; i < gapValues[g]; i++) {
                insertionSortInterleaved(numbers, i, gapValues[g]);
            }
        }
        return numbers;
    }

    public static void insertionSortInterleaved(int[] numbers, int startIndex, int gap) {
        for (int i = startIndex + gap; i < numbers.length; i += gap) {
            int j = i;
            while (j - gap >= startIndex && numbers[j] < numbers[j - gap]) {
                // Swap numbers[j] and numbers [j - gap]
                int temp = numbers[j];
                numbers[j] = numbers[j - gap];
                numbers[j - gap] = temp;
                j -= gap;
            }
        }
    }
}


