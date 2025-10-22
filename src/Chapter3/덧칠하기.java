package Chapter3;

class Solution58 {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int paintedEnd = 0;

        for (int pos : section) {
            if (pos > paintedEnd) {
                paintedEnd = pos + m - 1;
                count++;
            }
        }
        return count;
    }
}

public class 덧칠하기 {

    public static void main(String[] args) {
         Solution58 sol = new Solution58();
         int n = 5;
         int m = 4;
         int[] section = {1,3};
        System.out.println(sol.solution(n,m,section));
    }

}
