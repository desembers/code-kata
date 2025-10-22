package Chapter3;

class Solution59 {
    public int solution(int number, int limit, int power) {
        int total = 0;

        for (int i = 1; i <= number; i++) {
            int divisorCount = getDivisorCount(i); // 약수 개수 계산

            if (divisorCount > limit)
                divisorCount = power; // 제한 초과 시 power로 대체

            total += divisorCount; // 총 철 무게 누적
        }

        return total;
    }

    // √n까지 탐색하여 약수 개수 구하기
    private int getDivisorCount(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++; // i가 약수
                if (i != n / i) count++; // 짝이 되는 약수 추가
            }
        }

        return count;
    }
}


public class 기사단원의무기 {
    public static void main(String[] args) {
        Solution59 sol = new Solution59();
        int number = 5;
        int limit = 3;
        int power = 2;
        System.out.println(sol.solution(number, limit, power));
    }
}
