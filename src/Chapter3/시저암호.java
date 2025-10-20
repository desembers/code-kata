package Chapter3;

class Solution44 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char)('a' + (c - 'a' + n) % 26));
            } else if(c >= 'A' && c <= 'Z') {
                sb.append((char)('A' + (c - 'A' + n) % 26));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class 시저암호 {
    public static void main(String[] args) {
        Solution44 s = new Solution44();
        System.out.println(s.solution("AB", 1));
        System.out.println(s.solution("z", 1));
        System.out.println(s.solution("a B z", 3));
    }
}
