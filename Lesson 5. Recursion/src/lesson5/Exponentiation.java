package lesson5;

/**
 * recursion exponentiation
 *
 * @author holnievvitalii@outlook.com
 * @version dated Oct 16, 2019
 */
public class Exponentiation {
    public static class Power {
        public static int pow(int base, int power) {
            if (power > 1)
                return base * pow(base, power - 1);
            else if (power == 1)
                return base;
            else if (power == 0)
                return 1;
            else
                return 0;
        }

        public static void main(String[] args) {
            System.out.println("3 to the power of 2 = " + pow(3, 2));
        }
    }
}
