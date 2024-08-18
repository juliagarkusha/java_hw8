package app;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] numbers;

    public static void main(String[] args) {

        numbers = new int[] {54, 32, 81, 10, 12, 11, 70, 21, 7, 9, 14, 2, 41, 38, 67};

        System.out.println("Початковий вигляд масиву: " + Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("Відсортований масив: " + Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int target = scanner.nextInt();

        int index = binarySearch(numbers, target);

        if (index != -1) {
            System.out.println("Індекс числа " + target + " у відсортованому масиві: " + index);
        } else {
            System.out.println("Число " + target + " не знайдено в масиві.");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
