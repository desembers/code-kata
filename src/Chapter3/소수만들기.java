package Chapter3;

class Solution57 {
    public int solution(int[] nums) {
        int count = 0;

        // 서로 다른 3개 선택 (조합)
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) count++;
                }
            }
        }

        return count;
    }

    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}


public class 소수만들기 {
    public static void main(String[] args) {
        Solution57 sol = new Solution57();
        int[] nums = {1, 2, 3, 4};
        System.out.println(sol.solution(nums));
    }
}
