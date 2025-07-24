class Solution20 {
    public int solution(long num) {
        int count = 0;

        // 1인 경우는 0을 반환
        if (num == 1) return 0;

        // 최대 500번 반복
        while (num != 1 && count < 500) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;
        }

        // 500번 안에 1이 되면 횟수 반환, 아니면 -1
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
