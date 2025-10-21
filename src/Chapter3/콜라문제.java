package Chapter3;

class Solution51 {
    public int solution(int a, int b, int n) {
        int total = 0; // 받을 수 있는 콜라 총합

        while (n >= a) {
            int newCola = (n / a) * b; // 새로 받는 콜라
            total += newCola;
            n = (n % a) + newCola; // 남은 빈 병 + 새로 받은 콜라
        }

        return total;
    }
}


public class 콜라문제 {
    public static void main(String[] args) {
        Solution51 sol = new Solution51();

        System.out.println(sol.solution(2, 1, 20));
        System.out.println(sol.solution(3, 1, 20));
        System.out.println(sol.solution(3, 2, 20));
    }
}
