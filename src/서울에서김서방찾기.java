class Solution21 {
    public String solution(String[] seoul) {
        int index = 0;
        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                index = i;
                break;
            }
        }
        return "김서방은 " + index + "에 있다";
    }
}

public class 서울에서김서방찾기 {
    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        Solution21 sol = new Solution21();
        System.out.println(sol.solution(seoul));
    }
}
