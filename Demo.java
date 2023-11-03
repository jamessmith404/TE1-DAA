import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import com.cbis.CBIS;
import com.cbis.RQS;

public class Demo {
    public static void main(String[] args) {
        // String[] sizes = {"kecil", "sedang", "besar"};
        // String[] statuses = {"sorted", "random", "reversed"};

        String size = "besar";
        String status = "random";

        
        // int[] arr = {1,5,3,7,2,5,9,8};
        int[] arr = Generator.generateArray(size, status);

        long startTime = System.nanoTime();
        int[] sortedArr = RQS.sort(arr);
        long endTime = System.nanoTime();

        double ms = (endTime - startTime) / 1_000_000.0;

        System.out.printf("Size: %s; Status: %s; Time elapsed: %f ms%n", size, status, ms);

        // for (String size: sizes) {
        //     for (String status: statuses) {
        //         int[] arr = Generator.generateArray(size, status);

        //         long startTime = System.nanoTime();
        //         int[] sortedArr = CBIS.sort(arr);
        //         long endTime = System.nanoTime();

        //         System.out.printf("Size: %s; Status: %s; Time elapsed: %d ns\n", size, status, (endTime-startTime));
        //     }
        // }
        // System.out.println(Arrays.toString(sortedArr));
    }
}

class Generator {
    public static int[] generateArray(String size, String status) {
        int n = 1;
        Random rand = new Random();

        if (size.equals("kecil")) { //
            n = 200;
        }
        else if (size.equals("sedang")) {
            n = 2000;
        }
        else if (size.equals("besar")) {
            n = 20000;
        }

        Integer[] arrOut = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            arrOut[i] = rand.nextInt(1, Integer.MAX_VALUE);
        }

        if (status.equals("sorted")) {
            Arrays.sort(arrOut);
        }
        else if (status.equals("reversed")) {
            Arrays.sort(arrOut, Collections.reverseOrder());
        } else if (status.equals("random")) {
            ;
        }

        return Arrays.stream(arrOut).mapToInt(Integer::intValue).toArray();
    }
}