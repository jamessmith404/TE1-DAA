import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.algorithms.CBIS;
import com.algorithms.RQS;

public class Demo {
    public static void main(String[] args) {
        int[] arr;
        int n = 1;
        // choose the size & status via this vars
        String size = "besar";      // kecil, sedang, besar
        String status = "random";   // sorted, random, reversed

        if (size.equals("kecil")) {
            n = 200;
        }
        else if (size.equals("sedang")) {
            n = 2000;
        }
        else if (size.equals("besar")) {
            n = 20000;
        }

        arr = new int[n];
        
        // arr = {1,5,3,7,2,5,9,8};
        File data = new File(String.format("./dataset/%s-%s.txt", size, status));
        try (Scanner sc = new Scanner(data)) {
            String in = sc.nextLine();


            if (in != null) {
                // Remove the leading '[' and trailing ']' and split by ", "
                in = in.substring(1, in.length() - 1);
                String[] integerStrings = in.split(", ");
                // System.out.println(Arrays.toString(integerStrings));
                int i = 0;

                for (String integerString : integerStrings) {
                    int intValue = Integer.parseInt(integerString);
                    arr[i++] = intValue;
                }
            }
        } catch (NumberFormatException | FileNotFoundException e) {
            e.printStackTrace();
        }

        // System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        int[] sortedArr = RQS.sort(arr);
        long endTime = System.nanoTime();

        double ms = (endTime - startTime) / 1_000_000.0;

        System.out.printf("Size: %s; Status: %s; Time elapsed: %f ms%n", size, status, ms);

        // System.out.println();
        // System.out.println(Arrays.toString(sortedArr));
    }
}