package Chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution63 {
    public int solution(int n, int[] lost, int[] reverse) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reverseList = new ArrayList<>();

        for (int l : lost) lostList.add(l);
        for (int r : reverse) reverseList.add(r);

        Collections.sort(lostList);
        Collections.sort(reverseList);

        List<Integer> toRemove = new ArrayList<>();
        for(int i : lostList) {
            if (reverseList.contains(i)) {
                toRemove.add(i);
            }
        }
        lostList.removeAll(toRemove);
        reverseList.removeAll(toRemove);

        for (int r : reverseList) {
            if (lostList.contains(r-1)) {
                lostList.remove(Integer.valueOf(r-1));
            } else if(lostList.contains(r+1)) {
                lostList.remove(Integer.valueOf(r+1));
            }
        }
        return n - lostList.size();
    }
}

public class 체육복 {
    public static void main(String[] args) {
        Solution63 s = new Solution63();
        System.out.println(s.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(s.solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(s.solution(3, new int[]{3}, new int[]{1}));
    }
}
