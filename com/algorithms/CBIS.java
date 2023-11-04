package com.algorithms;

public class CBIS {

    public static int[] sort(int[] a_list) {
        int POP = 0;

        for (int i = 1; i <= a_list.length-1; i++) {
            int COP = i;
            int key = a_list[COP];
            int place;

            if (key >= a_list[POP]) { // left or right movement decision
                place = binary_loc_finder(a_list, POP+1, COP-1, key); // move right
            }
            else {
                place = binary_loc_finder(a_list, 0, POP-1, key); // move left
            }
            POP = place;
            // System.out.printf("POP val: %d || COP val: %d\n", POP, COP);
            a_list = place_inserter(a_list, POP, COP);
        }
        return a_list;
    }
    public static int binary_loc_finder(int[] a_list, int start, int end, int key) {
        if (start == end) {
            if (a_list[start] > key) {
                return start;
            } 
            else {
                return start + 1;
            }
        }

        if (start > end) {
            return start;
        }
        else {
            int middle = (start + end) / 2;
            
            if (a_list[middle] < key) {
                return binary_loc_finder(a_list, middle+1, end, key);
            }
            else if (a_list[middle] > key) {
                return binary_loc_finder(a_list, start, middle-1, key);
            }
            else {
                return middle;
            }
        }
    }
    public static int[] place_inserter(int[] a_list, int start, int end) {
        int temp = a_list[end];

        for (int k = end; k > start; k--) {
            a_list[k] = a_list[k-1];
        }
        a_list[start] = temp;
        return a_list;
    }
}