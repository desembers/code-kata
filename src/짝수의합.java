class Solution6 {
    public int solution(int n) {
        int answer = 0;
        for(int i=0; i<=n; i+=2){
            answer += i;
        }
        return answer;
    }
}

public class 짝수의합 {
    public static void main(String[] args) {
         Solution6 sol = new Solution6();
         System.out.println(sol.solution(10));
    }
}
