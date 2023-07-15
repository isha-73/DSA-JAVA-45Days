import java.util.*;

// https://practice.geeksforgeeks.org/problems/next-permutation5226
class Solution {
    static List<Integer> nextPermutation(int N, int arr[]) {

        // approach:
        /*
         * In order to find the next permutation, which is lexicofrapphycally greater
         * than previous sequence
         * - First find such number whose next element is greater.
         * - note such number index
         * - let {1,2,3,6,5,4}, here index 2, i.e number 3 has 6 as graeter element just
         * right
         * we will first check is there any number grater than 3 but less than 6, here
         * 4.
         * so swap 4 with 3
         * -now to make it next permutation, we will sort the remaining sequence in
         * ascending order
         */
        List<Integer> ans = new ArrayList<>();
        int idx = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            for (int i = 0; i < N; i++) {
                ans.add(arr[i]);
            }
            Collections.sort(ans);
            return ans; // this is when the array is sorted in descending order it means its at last
                        // permutation

        }

        // check right greater elemnet of idx
        for (int i = N - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        // now sort/reverse the elements after idx
        List<Integer> rem = new ArrayList<>();
        for (int i = N - 1; i > idx; i--) {
            rem.add(arr[i]);
        }
        for (int j = 0; j <= idx; j++) {
            ans.add(arr[j]);

        }
        ans.addAll(rem);
        return ans;

    }

}