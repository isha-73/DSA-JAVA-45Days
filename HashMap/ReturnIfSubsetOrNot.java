package HashMap;

//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;



class Compute {
    public String isSubset(long[] a1, long[] a2, long n, long m) {
       HashMap<Long, Integer> countMap1= new HashMap<>();

        // Count the occurrences of each element in a1
        for (long num : a1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
        }
        
       HashMap<Long, Integer> countMap2 = new HashMap<>();

        // Count the occurrences of each element in a2
        for (long num : a2) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }
        // System.out.println(countMap);
       
       for(int i=0;i<m;i++){
           if(!countMap1.containsKey(a2[i])) return "No";
           if(countMap1.get(a2[i])==1 && countMap2.get(a2[i])>1) return "No";
       }
       return "Yes";
    }
}
