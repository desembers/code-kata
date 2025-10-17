package chapter2;

class Solution36 {
      public boolean solution(String s) {
          return (s.length() == 4 || s.length() == 6) && s.matches("\\d+");
      }
}

public class 문자열다루기기본 {
    public static void main(String[] args) {
        Solution36 sol = new Solution36();
        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }
}
