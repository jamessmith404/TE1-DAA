package com.cbis;

import java.util.Random;

public class RQS {
    private static Random rand = new Random();
    private static int[] a_list; // hold the list as static variable as java is pass-by-value, not pass-by-ref

    public static int[] sort(int[] arr) {
        a_list = arr;
        return quicksort(0, a_list.length-1);
    }
    private static int[] quicksort(int left, int right) {
        if (left < right) {
            int final_pivot_pos = randomized_partition(left, right);
            quicksort(left, final_pivot_pos-1);
            quicksort(final_pivot_pos+1, right);
        }
        return a_list;
    }
    private static int randomized_partition(int left, int right) {       
        int random_number = rand.nextInt(left, right+1);
        
        int temp = a_list[random_number];
        a_list[random_number] = a_list[right];
        a_list[right] = temp;

        int pivot = a_list[right];
        int last_filled = left--;

        for (int i = left; i < right; i++) {
            if (a_list[i] <= pivot) {
                last_filled++;
                
                temp = a_list[last_filled];
                a_list[last_filled] = a_list[i];
                a_list[i] = temp;
            }
        }
        last_filled++;

        temp = a_list[last_filled];
        a_list[last_filled] = a_list[right];
        a_list[right] = temp;

        return last_filled;
    }

    
}