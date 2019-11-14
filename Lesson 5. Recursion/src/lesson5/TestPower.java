package lesson5;

/**
 * another version of exponentiation
 *
 * @author holnievvitalii@outlook.com
 * @version dated Oct 16, 2019
 */
public class TestPower {
    public static double pow(double base, int power) {
        if (power == 0)
            return 1.0;
        if ((power & 1) != 0)
            return pow(base, power - 1) * base;
        base = pow(base, power >> 1);
        return base * base;
    }

    public static void main(String[] args) {
        System.out.println("3 to the power of 2 = " + pow(3, 2));
    }
}
