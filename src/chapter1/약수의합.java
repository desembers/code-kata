package chapter1;

class Solution11 {
    public int solution(int n) {
        int sum = 0;
        for(int i=0; i<=n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
public class 약수의합 {
    public static void main(String[] args) {
        Solution11 sol = new Solution11();
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(5));
    }
}