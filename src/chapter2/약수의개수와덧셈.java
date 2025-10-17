package chapter2;

class Solution33 {
    //약수의 개수 더하려면 제곱수(약수의 개수가 홀수)
    //약수개수(짝수) + 약수개수(짝수) + 약수개수(홀수)즉, 제곱근 Math.sqrt()검증 필요
    public int solution(int left, int right) {
         int answer = 0;

         for(int i=left; i<=right; i++) {
            if (isPrefectSquare(i)) {
                answer -= i;
            } else {
                answer += i;
            }
         }
         return answer;
    }

    private boolean isPrefectSquare(int num) {
           int sqrt = (int) Math.sqrt(num);
           return sqrt * sqrt == num;
    }

}

public class 약수의개수와덧셈 {
    public static void main(String[] args) {
         Solution33 sol = new Solution33();
        System.out.println(sol.solution(13, 17));
        System.out.println(sol.solution(24,27));
    }
}
