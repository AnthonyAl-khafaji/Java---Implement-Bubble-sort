package bubbleSort;

import java.io.*;
import java.util.*;

public class bubbleSort {
    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength) {
        Random rand = new Random();
        int[] randomArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = rand.nextInt(101); // Random integers between 0 and 100
        }

        return randomArray;
    }

    // Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
    public static void writeArrayToFile(int[] array, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.println(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
    public static int[] readFileToArray(String filename) {
        List<Integer> arrayList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                arrayList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    // Given an integer array, sort it in-place using the Bubble Sort algorithm.
    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // The main function will handle a user's keyboard input specified in the next session
    public static void main(String[] args) {
        // Example usage:
        int[] randomArray = createRandomArray(10);
        writeArrayToFile(randomArray, "randomNumbers.txt");

        int[] arrayFromFile = readFileToArray("randomNumbers.txt");
        System.out.println("Array from file before sorting: " + Arrays.toString(arrayFromFile));

        bubbleSort(arrayFromFile);

        System.out.println("Array after sorting: " + Arrays.toString(arrayFromFile));
    }
}