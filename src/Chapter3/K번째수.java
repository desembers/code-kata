package Chapter3;

import java.util.Arrays;

class Solution47 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            int[] temp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(temp);

            answer[idx] = temp[k-1];
        }
        return answer;
    }
}

public class K번째수 {
    public static void main(String[] args) {
        Solution47 sol = new Solution47();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }
}
