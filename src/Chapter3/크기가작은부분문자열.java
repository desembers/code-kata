package Chapter3;

class Solution42 {
    public int solution(String t, String p) {
        int count = 0;
        int len = p.length();
        long pNum = Long.parseLong(p);

        for(int i=0; i<t.length() -len; i++) {
            String sub = t.substring(i, i+len);
            long subNum = Long.parseLong(sub);

            if (subNum <= pNum) {
                count++;
            }
        }
        return count;
    }
}

public class 크기가작은부분문자열 {
    public static void main(String[] args) {
        Solution42 s = new Solution42();
        System.out.println(s.solution("3141592", "271"));
        System.out.println(s.solution("500220839878", "7"));
        System.out.println(s.solution("10203", "15"));
    }
}
