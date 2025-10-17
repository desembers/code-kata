package chapter1;

class Solution28 {
    public int solution(int[] numbers) {
        int total = 45;
        int sum = 0;

        for(int num : numbers) {
            sum += num;
        }
        return total - sum;
    }
}

public class 없는숫자더하기 {
    public static void main(String[] args) {
        Solution28 sol = new Solution28();
        System.out.println(sol.solution(new int[] {1,2,3,4,6,7,8,0}));
        System.out.println(sol.solution(new int[] {5,8,4,0,6,7,9}));
    }
}
