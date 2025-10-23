package Chapter3;

class Solution62 {
    public String solution(String x, String y) {
        int[] countx = new int[10];
        int[] county = new int[10];

        for (char c : x.toCharArray()) {
            countx[c - '0']++;
        }
        for (char c : y.toCharArray()) {
            county[c - '0']++;
        }

        StringBuilder result = new StringBuilder();

        for(int i=9; i>=0; i--) {
            int pairCount = Math.min(countx[i], county[i]);
            result.append(String.valueOf("0").repeat(pairCount));
        }

        if (result.length() == 0) return "-1";
        if (result.toString().startsWith("0")) return "0";

        return result.toString();
    }
}

public class 숫자짝꿍 {

    public static void main(String[] args) {
        Solution62 s = new Solution62();

        System.out.println(s.solution("100", "2345"));     // -1
        System.out.println(s.solution("100", "203045"));   // 0
        System.out.println(s.solution("100", "123450"));   // 10
        System.out.println(s.solution("12321", "42531"));  // 321
        System.out.println(s.solution("5525", "1255"));    // 552
    }
}
