package Chapter3;

class Solution54 {
    public String solution(String[] card1, String[] card2, String[] goal) {
       int index1 = 0, index2 = 0;

       for (String word : goal) {
           if (index1 < card1.length && card1[index1].equals(word)) {
               index1++;
           }else if(index2 < card2.length && card2[index2].equals(word)) {
               index2++;
           }else {
               return "No";
           }
       }
       return "Yes";
    }
}


public class 카드뭉치 {
    public static void main(String[] args) {
        Solution54 sol = new Solution54();
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        System.out.println(sol.solution(cards1, cards2, goal));
    }
}
