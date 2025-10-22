package Chapter3;

class Solution53 {
    public String solution(int a, int b) {
        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalTodays = 0;

        for(int i=0; i<a - 1; i++) {
            totalTodays += month[i];
        }

        totalTodays += b;

        int dayIndex = (totalTodays + 4) % 7;

        return day[dayIndex];

    }
}

public class 이천십육년 {

    public static void main(String[] args) {
        Solution53 sol = new Solution53();
        System.out.println(sol.solution(5, 24));

    }

}
