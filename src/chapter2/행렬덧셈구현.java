package chapter2;

class Solution37 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
         int rows = arr1.length;
         int cols = arr1[0].length;

         int[][] result = new int[rows][cols];

         for (int i=0; i<rows; i++) {
             for (int j=0; j<cols; j++) {
                 result[i][j] = arr1[i][j] + arr2[i][j];
             }
         }
        return result;
    }
}

public class 행렬덧셈구현 {
    public static void main(String[] args) {
        Solution37 sol = new Solution37();

        int[][] arr1 = {{1,2}, {2,3}};
        int[][] arr2 = {{3,4}, {5,6}};

        int[][] result = sol.solution(arr1, arr2);

        for(int i =0; i<result.length; i++) {
            for(int j=0; j<result.length; j++) {
                System.out.println(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
