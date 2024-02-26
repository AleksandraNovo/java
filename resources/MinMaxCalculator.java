package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinMaxCalculator {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/resources/data.txt");
        Scanner scanner = new Scanner(file);

        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        scanner.close();

        int[] numbersArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numbersArray[i] = numbers.get(i);
        }
        int[] array = numbersArray;

        MinMaxThread minThread = new MinMaxThread(array, true);
        MinMaxThread maxThread = new MinMaxThread(array, false);

        minThread.start();
        maxThread.start();

        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Minimum: " + minThread.getResult());
        System.out.println("Maximum: " + maxThread.getResult());

        findMinMax(array);
    }
    public static void findMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Минимум: " + min);
        System.out.println("Максимум: " + max);
    }

}

class MinMaxThread extends Thread {
    private int[] array;
    private boolean isMin;
    private int result;

    public MinMaxThread(int[] array, boolean isMin) {
        this.array = array;
        this.isMin = isMin;
        this.result = isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (isMin) {
                if (array[i] < result) {
                    result = array[i];
                }
            } else {
                if (array[i] > result) {
                    result = array[i];
                }
            }
        }
    }
}