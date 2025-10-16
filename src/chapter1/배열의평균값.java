package chapter1;

class Solution7 {
    public double solution(int[] numbers) {
        int sum=0;
        for(int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;

    }
}

public class 배열의평균값 {
    public static void main(String[] args) {
        Solution7 sol = new Solution7();
        System.out.println(sol.solution(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
