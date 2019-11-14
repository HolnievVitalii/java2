package lesson5;

/**
 * The “Backpack Problem” using recursion
 *
 * @author holnievvitalii@outlook.com
 * @version dated Oct 16, 2019
 */
public class BackpackProblem {
    private static int[] worth = new int[]{956, 170, 301, 277, 31};
    private static int[] weight = new int[]{7, 5, 3, 0, 23};
    private static int W = 30;

    private static int backPack(int i, int W) {
        if (i < 0) {
            return 0;
        }
        if (weight[i] > W) {
            return backPack(i - 1, W);
        } else {
            return Math.max(backPack(i - 1, W), backPack(i - 1, W - weight[i]) + worth[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(backPack(worth.length - 1, W));
    }
}
