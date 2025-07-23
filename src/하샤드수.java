class Solution18 {
    public boolean solution(int x) {
        int n = x;
        int d = 0;
        while(x > 0) {
            d += x%10;
            x /= 10;
        }
        return n % d == 0;
    }
}

public class 하샤드수 {
    public static void main(String[] args) {
       Solution18 sol = new Solution18();
        System.out.println(sol.solution(10));
        System.out.println(sol.solution(11));
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(13));
    }
}
