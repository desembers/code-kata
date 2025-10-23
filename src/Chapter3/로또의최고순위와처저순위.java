package Chapter3;

import java.util.*;

class Solution60 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0;
        int matchCount = 0;

        for (int num : lottos) {
            if(num == 0) {
                zeroCount++;
            }else {
                for (int win : win_nums) {
                    if (num == win) {
                        matchCount++;
                        break;
                    }
                }
        }

        }
        int maxRank = getRank(matchCount + zeroCount);
        int minRank = getRank(matchCount);

        return new int[]{maxRank, maxRank};
    }

    private int getRank(int count) {
        if(count < 2) return 6;
        return 7 - count;
    }
}


public class 로또의최고순위와처저순위 {
    public static void main(String[] args) {
          Solution60 sol = new Solution60();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(sol.solution(lottos, win_nums));
    }
}
