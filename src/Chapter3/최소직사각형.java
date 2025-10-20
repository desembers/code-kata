package Chapter3;

class Solution43 {
   public int solution(int[][] sizes) {
      int maxWidth = 0;
      int maxHeight = 0;

      for(int[] size : sizes) {
         int w = Math.max(size[0], size[1]);
         int h = Math.max(size[0], size[1]);

         if(w > maxWidth) maxWidth = w;
         if(h > maxHeight) maxHeight = h;
      }
      return maxWidth * maxHeight;
   }
 }

public class 최소직사각형 {
    public static void main(String[] args) {
        Solution43 sol = new Solution43();
        int[][] sizes = {{60,50}, {30,70}, {60,30}, {80,40}};
        System.out.println();
    }
}
