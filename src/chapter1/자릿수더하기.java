package chapter1;

class Solution10 {
    public int solution(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

public class 자릿수더하기 {
    public static void main(String[] args) {
        Solution10 sol = new Solution10();
        System.out.println(sol.solution(123));
        System.out.println(sol.solution(987));
    }
}
