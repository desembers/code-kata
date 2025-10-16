package chapter1;

import java.util.Arrays;

class Solution22 {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                count++;
            }
        }

        if (count == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[index++] = arr[i];
            }
        }

        Arrays.sort(answer);

        return answer;
    }
}

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        Solution22 sol = new Solution22();
        System.out.println(sol.solution(new int[]{5,9,7,10}, 5));
        System.out.println(sol.solution(new int[]{3,2,6}, 10));
    }
}
