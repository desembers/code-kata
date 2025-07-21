import java.util.ArrayList;
import java.util.List;

class Solution14 {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n>0) {
            list.add((int)n%10);
            n/=10;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

public class 자연수뒤집어배열만들기 {
    public static void main(String[] args) {
           Solution14 sol = new Solution14();
        System.out.println(sol.solution(12345));
        }
    }
