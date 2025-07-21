class Solution15 {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}

public class 문자열을정수로바꾸기 {
    public static void main(String[] args) {
        Solution15 sol = new Solution15();
        System.out.println(sol.solution("1234"));
        System.out.println(sol.solution("-1234"));
        System.out.println(sol.solution("+1234"));
    }
}
