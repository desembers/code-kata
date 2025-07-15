import java.util.Scanner;

class Solution8 {
    public int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }
}

public class 두수의차 {
    public static void main(String[] args) {
        Solution8 sol = new Solution8();
        int a = sol.solution(2,3);
        int b = sol.solution(100,2);
        System.out.println(a);
        System.out.println(b);
    }
}


