package Chapter3;

class Solution61 {
    public int solution(String[] s) {
        int count = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String bab : s) {
            String prev = "";
            boolean valid = true;

            while (!bab.isEmpty()) {
                boolean matched = false;

                for (String w : words) {
                    if (bab.startsWith(w)) {
                        if (w.equals(prev)) {
                            valid = false;
                            break;
                        }
                        prev = w;
                        bab = bab.substring(w.length());
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    valid = false;
                    break;
                }
                if (!valid) break;
            }

            if (valid) count++;
        }

        return count;
    }
}

public class 옹알이 {
    public static void main(String[] args) {
        Solution61 sol = new Solution61();
        String test[] = {"aya", "yee", "u", "maa"};
        String test2[] = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(sol.solution(test));
        System.out.println(sol.solution(test2));
    }
}
