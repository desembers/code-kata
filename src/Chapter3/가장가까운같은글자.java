package Chapter3;

import java.util.HashMap;
import java.util.Map;

class Solution49 {
    public int[] solution(String s) {
       int[] answer = new int[s.length()];
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(lastIndex.containsKey(c)) {
                answer[i] = i - lastIndex.get(c);
            } else {
                answer[i] = -1;
            }
            lastIndex.put(c, i);
        }
        return answer;
    }
}

public class 가장가까운같은글자 {
    public static void main(String[] args) {
       Solution49 sol = new Solution49();
        System.out.println(sol.solution("banana"));
        System.out.println(sol.solution("foobar"));
    }
}
