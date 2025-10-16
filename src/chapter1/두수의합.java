package chapter1;

class Solution4 {
    public int solution(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }
}

public class 두수의합 {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        int a = sol.solution(2020, 2020);
        System.out.println(a);
    }
}
