package chapter1;

import java.util.Scanner;

public class 숫자비교하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextByte();
        int num2 = sc.nextInt();

        if(num1 == num2) {
            System.out.println(1);
        }else {
            System.out.println(-1);
        }
    }
}
