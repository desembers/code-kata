class Solution9 {
    public double solution(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
          return (double) sum / arr.length;
    }
}

public class 평균구하기 {
    public static void main(String[] args) {
        Solution9 sol = new Solution9();

        // 테스트 예시
        System.out.println(sol.solution(new int[]{1, 2, 3, 4}));  // 2.5
        System.out.println(sol.solution(new int[]{5, 5}));         // 5.0
    }
}
