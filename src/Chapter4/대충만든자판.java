package Chapter4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution65 {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();

        for(String key : keymap) {
            for (int i = 0; i<key.length(); i++) {
                char c = key.charAt(i);
                int pressCount = i + 1;

                if(map.containsKey(c)) {
                    map.put(c, Math.min(map.get(c), pressCount));
                } else {
                    map.put(c, pressCount);
                }
            }
        }

        int[] answer = new int[targets.length];
        for (int i = 0; i<targets.length; i++) {
            int totalPress = 0;
            boolean possible = true;

            for (char c : targets[i].toCharArray()) {
                if (!map.containsKey(c)) {
                    possible = false;
                    break;
                }
                totalPress += map.get(c);
            }
            answer[i] = possible ? totalPress : -1;
        }
        return answer;
    }
}

public class 대충만든자판 {
    public static void main(String[] args) {
        Solution65 s = new Solution65();

        String[] keymap1 = {"ABACD", "BCEFD"};
        String[] targets1 = {"ABCD", "AABB"};
        System.out.println(Arrays.toString(s.solution(keymap1, targets1))); // [9, 4]

        String[] keymap2 = {"AA"};
        String[] targets2 = {"B"};
        System.out.println(Arrays.toString(s.solution(keymap2, targets2))); // [-1]

        String[] keymap3 = {"AGZ", "BSSS"};
        String[] targets3 = {"ASA", "BGZ"};
        System.out.println(Arrays.toString(s.solution(keymap3, targets3))); // [4, 6]
    }
}
