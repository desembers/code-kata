package Chapter4;

class Solution64 {
    public int solution(String s) {
        int answer = 0;
        int countx = 0, countOrder = 0;
        char x = ' ';
        boolean isNewPart = true;

        for(int i=0; i<s.length(); i++) {
            if (isNewPart) {
                x = s.charAt(i);
                countx = 0;
                countOrder = 0;
                isNewPart = false;
            }

            if(s.charAt(i) == x) countx++;
            else countOrder++;

            if(countx == countOrder) {
                answer++;
                isNewPart = true;
            }
        }
        if(!isNewPart) answer++;
        return answer;
    }
}

public class 문자열나누기 {
    public static void main(String[] args) {
        Solution64 s = new Solution64();

        System.out.println(s.solution("banana"));        // 3
        System.out.println(s.solution("abracadabra"));   // 6
        System.out.println(s.solution("aaabbaccccabba"));// 3
    }
}
