import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class unionAintersection {
    public static int[] union(int nums1[], int nums2[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            set.add(i);
        }
        int ans[] = new int[set.size()];
        int p = 0;
        for (int i : set) {
            ans[p++] = i;
        }
        return ans;

    }

    public static int[] intersection(int nums1[], int nums2[]) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int ans[] = new int[set2.size()];
        int p = 0;
        for (int i : set2) {
            ans[p++] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr1[] = { 7, 1, 5, 2, 3, 6 };
        int arr2[] = { 3, 8, 6, 20, 7 };

        System.out.println(Arrays.toString(union(arr1, arr2)));

    }
}
