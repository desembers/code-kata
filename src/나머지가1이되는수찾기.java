class Solution12 {
    public int solution(int n) {
        for(int i =2; i<n; i++) {
            if(n % i == 1) {
                return i;
            }
        }
        return 0;
    }
}

public class 나머지가1이되는수찾기 {
    public static void main(String[] args) {
        Solution12 sol = new Solution12();
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(10));
    }
}
