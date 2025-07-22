class Solution16 {
    public static long solution(long n) {
        long x = (long)Math.sqrt(n);
        if(x * x == n) {
            return x * x + 1;
        } else {
            return -1;
        }
    }
}

public class 정수제곱근판별 {
    public static void main(String[] args) {
        Solution16 sol = new Solution16();
        System.out.println(sol.solution(121));
        System.out.println(sol.solution(3));
    }
}
