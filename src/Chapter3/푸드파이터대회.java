package Chapter3;

class Solution50 {
public String solution(int[] food) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<food.length; i++) {
        int count = food[i] / 2;
        for (int j=0; j<count; j++) {
            sb.append(i);
        }
    }

    StringBuilder right = new StringBuilder(sb).reverse();
    String answer = sb.toString() + "0" + right.toString();
    return answer;
   }

}

public class 푸드파이터대회 {
    public static void main(String[] args) {
        Solution50 sol = new Solution50();
        int[] food = {1,3,4,6};
        System.out.println(sol.solution(food));
    }
}
