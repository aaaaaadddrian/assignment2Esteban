import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Testing {

    public static void main(String[] args){

        File output = new File("output.txt");
        try{
            PrintWriter writer = new PrintWriter(output, StandardCharsets.UTF_8);
            writer.println("Insert Test: ");
            writer.println("------------------------------------------");
            writer.println("Sorted 100 elements in " + insertTest(20, 100) + " seconds");
            writer.println("Sorted 500 elements in " + insertTest(20, 500) + " seconds");
            writer.println("Sorted 1000 elements in " + insertTest(20, 1000) + " seconds");
            writer.println("Sorted 2000 elements in " + insertTest(20, 2000) + " seconds");
            writer.println("Sorted 5000 elements in " + insertTest(20, 5000) + " seconds");
            writer.println("Sorted 10000 elements in " + insertTest(20, 10000) + " seconds");
            writer.println("Sorted 20000 elements in " + insertTest(20, 20000) + " seconds");
            writer.println("Sorted 75000 elements in " + insertTest(20, 75000) + " seconds");
            writer.println("Sorted 150000 elements in " + insertTest(20, 150000) + " seconds");
            writer.println();
            writer.println("Bubble Test: ");
            writer.println("------------------------------------------");
            writer.println("Sorted 100 elements in " + bubbleTest(20, 100) + " seconds");
            writer.println("Sorted 500 elements in " + bubbleTest(20, 500) + " seconds");
            writer.println("Sorted 1000 elements in " + bubbleTest(20, 1000) + " seconds");
            writer.println("Sorted 2000 elements in " + bubbleTest(20, 2000) + " seconds");
            writer.println("Sorted 5000 elements in " + bubbleTest(20, 5000) + " seconds");
            writer.println("Sorted 10000 elements in " + bubbleTest(20, 10000) + " seconds");
            writer.println("Sorted 20000 elements in " + bubbleTest(20, 20000) + " seconds");
            writer.println("Sorted 75000 elements in " + bubbleTest(20, 75000) + " seconds");
            writer.println("Sorted 150000 elements in " + bubbleTest(20, 150000) + " seconds");
            writer.println();
            writer.println("Selection Test: ");
            writer.println("------------------------------------------");
            writer.println("Sorted 100 elements in " + selectTest(20, 100) + " seconds");
            writer.println("Sorted 500 elements in " + selectTest(20, 500) + " seconds");
            writer.println("Sorted 1000 elements in " + selectTest(20, 1000) + " seconds");
            writer.println("Sorted 2000 elements in " + selectTest(20, 2000) + " seconds");
            writer.println("Sorted 5000 elements in " + selectTest(20, 5000) + " seconds");
            writer.println("Sorted 10000 elements in " + selectTest(20, 10000) + " seconds");
            writer.println("Sorted 20000 elements in " + selectTest(20, 20000) + " seconds");
            writer.println("Sorted 75000 elements in " + selectTest(20, 75000) + " seconds");
            writer.println("Sorted 150000 elements in " + selectTest(20, 150000) + " seconds");
            writer.println();
            writer.println("Shell Test: ");
            writer.println("------------------------------------------");
            writer.println("Sorted 100 elements in " + shellTest(20, 100) + " seconds");
            writer.println("Sorted 500 elements in " + shellTest(20, 500) + " seconds");
            writer.println("Sorted 1000 elements in " + shellTest(20, 1000) + " seconds");
            writer.println("Sorted 2000 elements in " + shellTest(20, 2000) + " seconds");
            writer.println("Sorted 5000 elements in " + shellTest(20, 5000) + " seconds");
            writer.println("Sorted 10000 elements in " + shellTest(20, 10000) + " seconds");
            writer.println("Sorted 20000 elements in " + shellTest(20, 20000) + " seconds");
            writer.println("Sorted 75000 elements in " + shellTest(20, 75000) + " seconds");
            writer.println("Sorted 150000 elements in " + shellTest(20, 150000) + " seconds");
            writer.println();
            writer.println("Quick Test: ");
            writer.println("------------------------------------------");
            writer.println("Sorted 100 elements in " + quickTest(20, 100) + " seconds");
            writer.println("Sorted 500 elements in " + quickTest(20, 500) + " seconds");
            writer.println("Sorted 1000 elements in " + quickTest(20, 1000) + " seconds");
            writer.println("Sorted 2000 elements in " + quickTest(20, 2000) + " seconds");
            writer.println("Sorted 5000 elements in " + quickTest(20, 5000) + " seconds");
            writer.println("Sorted 10000 elements in " + quickTest(20, 10000) + " seconds");
            writer.println("Sorted 20000 elements in " + quickTest(20, 20000) + " seconds");
            writer.println("Sorted 75000 elements in " + quickTest(20, 75000) + " seconds");
            writer.println("Sorted 150000 elements in " + quickTest(20, 150000) + " seconds");
            writer.println();
            writer.println("Merge Test: ");
            writer.println("------------------------------------------");
            writer.println("Sorted 100 elements in " + mergeTest(20, 100) + " seconds");
            writer.println("Sorted 500 elements in " + mergeTest(20, 500) + " seconds");
            writer.println("Sorted 1000 elements in " + mergeTest(20, 1000) + " seconds");
            writer.println("Sorted 2000 elements in " + mergeTest(20, 2000) + " seconds");
            writer.println("Sorted 5000 elements in " + mergeTest(20, 5000) + " seconds");
            writer.println("Sorted 10000 elements in " + mergeTest(20, 10000) + " seconds");
            writer.println("Sorted 20000 elements in " + mergeTest(20, 20000) + " seconds");
            writer.println("Sorted 75000 elements in " + mergeTest(20, 75000) + " seconds");
            writer.println("Sorted 150000 elements in " + mergeTest(20, 150000) + " seconds");
            writer.println();
            writer.println("PHEW");
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
        double startTime = (double) System.nanoTime() / 1000000000;
        sorty.sorty(A);
        double endTime = (double) System.nanoTime() / 1000000000;

        double totalTime = endTime - startTime;
        System.out.println(totalTime);
        return totalTime;

    }

    public static String insertTest(int iterations, int size) {

        double total = 0;

        for (int number = 0; number < iterations; number++) {
            total = total + singleTest(size, new InsertionSort());
        }

        double average = total / iterations;

        return "" + average;

    }

    public static String bubbleTest(int iterations, int size) {

        double total = 0;

        for (int number = 0; number < iterations; number++) {
            total = total + singleTest(size, new BubbleSort());
        }

        double average = total / iterations;

        return "" + average;
    }

    public static String selectTest(int iterations, int size) {

        double total = 0;

        for (int number = 0; number < iterations; number++) {
            total = total + singleTest(size, new SelectionSort());
        }

        double average = total / iterations;

        return "" + average;
    }

    public static String shellTest(int iterations, int size) {

        double total = 0;

        for (int number = 0; number < iterations; number++) {
            total = total + singleTest(size, new ShellSort());
        }

        double average = total / iterations;

        return "" + average;
    }

    public static String quickTest(int iterations, int size) {

        double total = 0;

        for (int number = 0; number < iterations; number++) {
            total = total + singleTest(size, new QuickSort());
        }

        double average = total / iterations;

        return "" + average;
    }

    public static String mergeTest(int iterations, int size) {

        double total = 0;

        for (int number = 0; number < iterations; number++) {
            total = total + singleTest(size, new MergeSort());
        }

        double average = total / iterations;

        return "" + average;
    }



}