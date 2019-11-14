import java.io.IOException;

/**
 * @author holni
 * @version dated August 19, 2019
 */
public class Main {
    /**
     *
     * @param args
     * @throws MyArraySizeException
     */
    public static void main(String[] args) throws MyArraySizeException {
        Object[][] arr;
        int  amount = 0;
        try {
            arr = iArray(4,4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < arr.length;i++ )
            for (int j = 0; j < arr.length;j++) {
                try {
                    amount += (int) arr[i][j];
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("cell: [" + i + "]" + "[" + j + "]" + " - contains an invalid data!");
                } finally {
                    System.out.println("Amount = " + amount);
                }
            }
    }

    /**
     * @about А two-dimensional 4x4 string array is served,
     * when feeding an array of a different size,
     * it is necessary to throw a MyArraySizeException.
     * @param r
     * @param c
     * @return
     * @throws MyArraySizeException
     */
    public static Object[][] iArray(int r, int c) throws MyArraySizeException {
        if (r != 4 || c != 4) {
            throw new MyArraySizeException("the array goes out of bounds");
        }
        return new Object[][] {{0,'2',4,3},{0,1,2,4}};
    }
}
