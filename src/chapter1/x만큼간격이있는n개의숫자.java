package chapter1;

class Solution13 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0; i<n; i++) {
            answer[i] = (long)x * (i+1);
        }
        return answer;
    }
}

public class x만큼간격이있는n개의숫자 {
    public static void main(String[] args) {
          Solution13 sol = new Solution13();
        System.out.println(sol.solution(2,5));
        System.out.println(sol.solution(4,3));
        System.out.println(sol.solution(-4,-8));
    }
}