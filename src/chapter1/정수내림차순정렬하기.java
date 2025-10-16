package chapter1;

import java.util.Arrays;
import java.util.Collections;

class Solution17 {
    public long solution(long n) {
        String[] digits = String.valueOf(n).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String digit : digits) {
            sb.append(digit);
        }
        return Long.parseLong(sb.toString());
    }
}

public class 정수내림차순정렬하기 {
    public static void main(String[] args) {
        System.out.println(solution(118372)); 
    }
}
