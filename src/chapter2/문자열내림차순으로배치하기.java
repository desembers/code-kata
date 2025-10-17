package chapter2;

import java.util.Arrays;
import java.util.Collections;

class Solution34 {
    public String solution(String s) {
        Character[] chars = new Character[s.length()];

        for(int i=0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        Arrays.sort(chars, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();

    }
}

public class 문자열내림차순으로배치하기 {
    public static void main(String[] args) {
        Solution34 sol = new Solution34();
        System.out.println(sol.solution("Zbcdefg"));
    }
}
