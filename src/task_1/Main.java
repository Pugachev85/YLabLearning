package task_1;

public class Main {
    public static Long seed = System.currentTimeMillis();

    public static void main(String[] args) {
        int arraySize = 12;
        int numsFrom = -1000;
        int numsTo = 1000;

        int[][] array = new int[arraySize][arraySize];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = nextRandom(numsFrom, numsTo);
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Minimal value of array: " + minValue(array));
        System.out.println();
        System.out.println("Maximal value of array: " + maxValue(array));
        System.out.println();
        System.out.println("Average value of array: " + averageValue(array));
    }

    private static int nextRandom(int from, int to) {
        seed ^= seed << 13;
        seed ^= seed >> 17;
        seed ^= seed << 5;
        return (int) (from + seed) % (to - from);
    }

    private static int minValue(int[][] array) {
        int result = 0;
        for (int[] line : array) {
            for (int current : line) {
                if (current < result) result = current;
            }
        }
        return result;
    }

    private static int maxValue(int[][] array) {
        int result = 0;
        for (int[] line : array) {
            for (int current : line) {
                if (current > result) result = current;
            }
        }
        return result;
    }

    private static float averageValue(int[][] array) {
        long summ = 0;
        int count = 0;
        for (int[] line : array) {
            for (int current : line) {
                summ += current;
                count++;
            }
        }
        return (float) summ / count ;
    }

}
