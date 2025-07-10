class Solution2 {
    public int solution(int num1, int num2) {
        return num1 / num2;
    }
}

public class 몫구하기 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int a = sol.solution(100,2);
        int b = sol.solution(6,2);
        System.out.println(a);
        System.out.println(b);
    }
}
