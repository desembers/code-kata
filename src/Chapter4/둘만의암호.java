package Chapter4;

import java.util.HashSet;
import java.util.Set;

class Solution66 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> skiplist = new HashSet<>();

        for (char c : skip.toCharArray()) {
            skiplist.add(c);
        }

        for (char c : s.toCharArray()) {
            char next = 'c';
            int count = 0;

            while(count < index) {
                next++;
                if (next > 'z') next = 'a';

                if(!skiplist.contains(next)) {
                    count++;
                }
            }
            sb.append(next);
        }
        return sb.toString();
    }
}

public class 둘만의암호 {
    public static void main(String[] args) {
        Solution66 sol = new Solution66();
        System.out.println(sol.solution("aukks", "wbqd", 5));
    }
}
