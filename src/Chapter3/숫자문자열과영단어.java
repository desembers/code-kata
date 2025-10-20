package Chapter3;

class Solution45 {
    public int solution(String s) {
        String[] members = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i=0; i<10; i++) {
            s = s.replaceAll(members[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}

public class 숫자문자열과영단어 {
    public static void main(String[] args) {
        Solution45 s = new Solution45();
        System.out.println(s.solution("one4seveneight"));
        System.out.println(s.solution("23four5six7"));
        System.out.println(s.solution("1zerotwozero3"));
    }
}
