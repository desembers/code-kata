class Solutions {
    public int solution(int num1, int num2) {
        return num1 * num2;
    }
}

public class 두수의곱 {
    public static void main(String[] args) {
       Solutions sol = new Solutions();
       int a = sol.solution(100,2);
       int b = sol.solution(3,4);
        System.out.println(a);
        System.out.println(b);
    }
}
