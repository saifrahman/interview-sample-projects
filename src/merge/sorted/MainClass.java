package merge.sorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m+n];
        // i ,j, k are pointers for three arrays nums1, nums2 and merged respectively
        int i=0;
        int j=0;
        
        for(int k = 0;k < m+n ;k++){
            if(i == m && j < n){
               merged[k] = nums2[j++]; 
            }else if(j == n && i < m){
               merged[k] = nums1[i++]; 
            }else if(nums1[i] <= nums2[j] && nums1[i] != 0){
                merged[k] = nums1[i++];
            }else if(nums2[j] != 0){
                merged[k] = nums2[j++];
            }
        }
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
            int[] nums1 =  {1,2,3,0,0,0}; // stringToIntegerArray(line);
//            line = in.readLine();
            int m = 3;//Integer.parseInt(line);
//            line = in.readLine();
            int[] nums2 = {2,5,6};//stringToIntegerArray(line);
//            line = in.readLine();
            int n = 3;//Integer.parseInt(line);
            
            new Solution().merge(nums1, m, nums2, n);
            String out = integerArrayToString(nums1);
            
            System.out.print(out);
        
    }
}