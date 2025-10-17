package chapter1;

class Solution30 {
    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;

        if (len % 2 == 0) {
            return s.substring(mid - 1, mid + 1);
        } else {
            return s.substring(mid, mid + 1);
        }
    }
}

public class 가운데글자가져오기 {
    public static void main(String[] args) {
         Solution30 sol = new Solution30();
        System.out.println(sol.solution("abcde"));
        System.out.println(sol.solution("qwer"));
    }
}
