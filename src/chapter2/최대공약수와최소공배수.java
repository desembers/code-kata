package chapter2;

class Solution38 {
    public int[] solution(int n, int m) {
        int gcd = getGCD(n, m);
        int lcm = (n * m) / gcd;
        return new int[] {gcd, lcm};
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

public class 최대공약수와최소공배수 {
    public static void main(String[] args) {
        Solution38 sol = new Solution38();

        int[] result1 = sol.solution(3, 12);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] result2 = sol.solution(2, 5);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
    }
}
