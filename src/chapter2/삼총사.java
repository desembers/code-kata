package chapter2;

class Solution41 {
    public int solution(int[] number) {
        int count = 0;
        int n = number.length;

        for(int i=0; i<n-2; i++) {
            for(int j=0; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

public class 삼총사 {
    public static void main(String[] args) {
       Solution41 sol = new Solution41();
        System.out.println(sol.solution(new int[]{-2, 3, 0, 2, -5}));      // 2
        System.out.println(sol.solution(new int[]{-3, -2, -1, 0, 1, 2, 3})); // 5
        System.out.println(sol.solution(new int[]{-1, 1, -1, 1}));
    }
}
