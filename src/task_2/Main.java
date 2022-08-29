package task_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {5, 6, 3, 2, 5, 1, 4, 9};
        bubbleSort(array1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = {9, 5, 6, 1, 3, 2, 5, 1, 4, 9};
        quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));

    }

    private static void bubbleSort(int[] array) {
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    needIteration = true;
                }
            }
        }
    }

    private static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(array, leftBorder, rightMarker);
        }
    }
}
