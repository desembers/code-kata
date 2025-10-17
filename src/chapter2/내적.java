package chapter2;

class Solution32 {
    public int solution(int[] a, int[] b) {
        int sum = 0;

        for (int i=0; i<a.length; i++) {
            sum += a[i] * b[i];
        }

        return sum;
    }
}

public class 내적 {
    public static void main(String[] args) {
         Solution32 sol = new Solution32();
        System.out.println(sol.solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2}));
        System.out.println(sol.solution(new int[] {-1,0,1}, new int[] {1,0,-1}));
    }
}
