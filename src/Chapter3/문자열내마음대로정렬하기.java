package Chapter3;

import java.util.Arrays;

class Solution46 {
    public String[] solution(String[] s, int n) {
       Arrays.sort(s, (s1, s2) -> {
           char c1 = s1.charAt(n);
           char c2 = s2.charAt(n);

           if (c1 == c2) {
               return s1.compareTo(s2);
           } else {
               return Character.compare(c1, c2);
           }
        });
       return s;
    }
}

public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        Solution46 sol = new Solution46();
        String[] result = sol.solution(new String[]{"sun", "bed", "car"}, 1);
        System.out.println(Arrays.toString(result));

        String[] result2 = sol.solution(new String[]{"abce", "abcd", "cdx"}, 2);
        System.out.println(Arrays.toString(result2));
    }
}
