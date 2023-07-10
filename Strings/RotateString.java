package Strings;
//https://www.codingninjas.com/studio/problems/check-if-one-string-is-a-rotation-of-another-string_1115683
import java.util.LinkedList;
import java.util.Queue;


 public class Solution {
    public static int isCyclicRotation(String p, String q) {
        if (p.length() != q.length()) {
            return 0;  // Strings of different lengths cannot be cyclic rotations
        }

        String concatP = p + p;

        if (concatP.contains(q)) {
            return 1;  // q is a cyclic rotation of p
        } else {
            return 0;  // q is not a cyclic rotation of p
        }
 }
 }
