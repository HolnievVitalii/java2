/**
 * @author holni
 * @version dated August 29, 2019
 */
public class MainClass extends Thread {
    static final int size = 10000000;
    static final int h = size / 2;

    /**
     * @param args
     */
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.firstMethod();
        mainClass.secondMethod();
    }

    private void firstMethod() {
        System.out.println("start of the first method");
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("runtime: " + (System.currentTimeMillis() - a) + " millis");
        }

        private void secondMethod() {
            System.out.println("start of the second method");
            float[] arr = new float[size];
            float[] a1 = new float[h];
            float[] a2 = new float[h];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
            long a = System.currentTimeMillis();
            System.arraycopy(arr, 0, a1, 0, h);
            System.arraycopy(arr, h, a2, 0, h);
            System.currentTimeMillis();
            System.out.println("array splitting runtime: " + (System.currentTimeMillis() - a) + " millis");

            /**
             * create two threads of the second method
             */
            new Thread(() ->this.secondMethodBreakdown(a1,1)).start();
            new Thread(() ->this.secondMethodBreakdown(a2,2)).start();

            try {
                new Thread(() ->this.secondMethodBreakdown(a1,1)).join();
                new Thread(() ->this.secondMethodBreakdown(a2,2)).join();
            } catch (Exception e) {
                System.err.println("Main thread interrupted!");
                e.printStackTrace();
            }

            long gluing = System.currentTimeMillis(); //gluing of arrays together
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);
            long end = System.currentTimeMillis();
            System.out.println("array gluing runtime: " + (end - gluing) + " millis");
            System.out.println("End of the second method | runtime: " + (end - a) + " millis");
        }

    /**
     * @apiNote method for calculating the execution time of each thread individually
     * @param arr
     * @param num
     */
    private void secondMethodBreakdown(float[] arr, int num) {
        long beginning = System.currentTimeMillis();
            for (int i = 0; i < arr.length ; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            long end = System.currentTimeMillis();
            System.out.println(String.format("Thread runtime %d equals %s millis", num, String.valueOf(end - beginning)));
        }
}
        
