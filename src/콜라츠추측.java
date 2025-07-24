class Solution20 {
    public int solution(long num) {
        int count = 0;

        if (num == 1) return 0;

        while (num != 1 && count < 500) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }

        return num == 1 ? count : -1;
    }
}

public class 콜라츠추측 {
    public static void main(String[] args) {
        Solution20 sol = new Solution20();
        System.out.println(sol.solution(6));
        System.out.println(sol.solution(16));
        System.out.println(sol.solution(626331));
    }
}
