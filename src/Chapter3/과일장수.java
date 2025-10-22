package Chapter3;

import java.util.Arrays;

class Solution55 {
   public int solution(int k, int m, int[] score) {
          Arrays.sort(score);
          int n = score.length;
          int profit = 0;

          for(int i=n-m; i>=0; i-=m) {
              profit += score[i] * m;
          }
          return profit;
   }
}


public class 과일장수 {

    public static void main(String[] args) {
        Solution55 sol = new Solution55();
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        System.out.println(sol.solution(k,m,score));
    }

}
