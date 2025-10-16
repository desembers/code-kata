package chapter1;

class Solution3 {
    public int solution(int age) {
        return 2022 - age + 1;
    }
}

public class 나이출력 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        int a = sol.solution(2020);
        System.out.println(a);
    }
}
