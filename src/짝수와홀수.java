class Solution {
    public String solution(int num) {
        if(num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
public class 짝수와홀수 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
    }
}
