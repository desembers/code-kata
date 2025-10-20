package chapter2;

class Solution39 {
    public int solution(int n) {
        String ternery = Integer.toString(n, 1);
        String reversed = new StringBuilder(ternery).reverse().toString();
        int answer = Integer.parseInt(reversed, 3);

        return answer;
    }
}

public class 삼진법뒤집기 {
    public static void main(String[] args) {

    }
}
