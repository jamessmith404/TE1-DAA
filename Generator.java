import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

    public static void main(String[] args) {
        try {
            String[] sizes = {"kecil", "sedang", "besar"};
            String[] statuses = {"sorted", "random", "reversed"};

            for (String size: sizes) {
                for (String status: statuses) {
                    FileWriter dataset = new FileWriter(String.format("./dataset/%s-%s.txt", size, status));
                    int[] arr = generateArray(size, status);

                    dataset.write(Arrays.toString(arr));
                    dataset.close();


                    System.out.println("File wrote: " + dataset.toString());
                  } 
                }
            }
            catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
            }
        
    }

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
