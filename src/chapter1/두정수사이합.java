package chapter1;

class Solution19 {
    public long solution(int a, int b) {
        int s = Math.min(a,b);
        int c = Math.max(a,b);

        long count = (long)c - s + 1;
        return count * (s+c) /2;
    }
}

public class 두정수사이합 {
    public static void main(String[] args) {
        Solution19 sol = new Solution19();
        System.out.println(sol.solution(3, 5));
        System.out.println(sol.solution(3, 3));
        System.out.println(sol.solution(5, 3));
        System.out.println(sol.solution(-5, 3));
    }
}
