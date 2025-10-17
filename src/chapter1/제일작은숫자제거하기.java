package chapter1;

import java.util.Arrays;

class Solution29 {
     public int[] solution(int[] arr) {
         if (arr.length == 1) {
             return new int[]{-1};
         }

         int min = arr[0];
         for (int i=0; i<arr.length; i++) {
             if (arr[i] < min) {
                 min = arr[i];
             }
         }

         int[] answer = new int[arr.length -1];
         int idx = 0;
         for (int num : arr) {
             if (num != min) {
                 answer[idx++] = num;
             }
         }
         return answer;
     }
}

public class 제일작은숫자제거하기 {
    public static void main(String[] args) {
        Solution29 sol = new Solution29();
        System.out.println(Arrays.toString(sol.solution(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{10})));
    }
}
