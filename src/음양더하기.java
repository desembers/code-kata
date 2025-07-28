class Solution23 {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for(int i=0; i<absolutes.length; i++) {
            if(signs[i]) {
                sum += absolutes[i];
            }else {
                sum -= absolutes[i];
            }
        }
        return sum;
    }
}

public class 음양더하기 {
    public static void main(String[] args) {
       Solution23 sol = new Solution23();
        System.out.println(sol.solution(new int[]{4,7,12}, new boolean[]{true, true, false}));
        System.out.println(sol.solution(new int[]{1,2,3}, new boolean[]{false, false, true}));
    }
}
