package Chapter3;

import java.util.*;

class Solution48 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for (int j=0; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        Solution48 sol = new Solution48();

        int[] result1 = sol.solution(new int[]{2, 1, 3, 4, 1});
        System.out.println(Arrays.toString(result1));
        // [2, 3, 4, 5, 6, 7]

        int[] result2 = sol.solution(new int[]{5, 0, 2, 7});
        System.out.println(Arrays.toString(result2));
        // [2, 5, 7, 9, 12]
    }
}
