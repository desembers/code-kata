package chapter1;

class Solution5 {
    public int solution(int num1, int num2) {
        return num1 * 1000 / num2;
    }
}

public class 두수의나눗셈 {
    public static void main(String[] args) {
        Solution5 sol = new Solution5();
        int a = sol.solution(2000, 40);
        System.out.println(a);
    }
}
