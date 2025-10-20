package chapter2;

class Solution40 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = 0; // 단어 내에서의 인덱스

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                // 공백이면 단어 인덱스 초기화
                answer.append(' ');
                idx = 0;
            } else {
                // 짝수 인덱스 → 대문자, 홀수 인덱스 → 소문자
                if (idx % 2 == 0)
                    answer.append(Character.toUpperCase(c));
                else
                    answer.append(Character.toLowerCase(c));
                idx++;
            }
        }

        return answer.toString();
    }
}


public class 이상한문자만들기 {
    public static void main(String[] args) {
        Solution40 sol = new Solution40();
        System.out.println(sol.solution("try hello world"));
    }
}
