package chapter2;

class Solution31 {
     public String solution(int n) {
          StringBuilder sb = new StringBuilder();

          for(int i=0; i<n; i++) {
              if(i % 2 == 0) {
                  sb.append("수");
              } else {
                  sb.append("박");
              }
          }
          return sb.toString();
     }
}

public class 수박수박수박수박수박수 {
    public static void main(String[] args) {
         Solution31 sol = new Solution31();
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(4));
    }
}
