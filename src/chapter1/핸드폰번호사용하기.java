package chapter1;

class Solution27 {
    public String solution27(String phone_number) {
        int length = phone_number.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length - 4; i++) {
            sb.append("*");
        }
        String Four = phone_number.substring(length - 4);
        return sb.toString() + Four;
    }
}

public class 핸드폰번호사용하기 {
    public static void main(String[] args) {
        Solution27 sol = new Solution27();
        System.out.println(sol.solution27("01033334444"));
        System.out.println(sol.solution27("027778888"));
    }
}
