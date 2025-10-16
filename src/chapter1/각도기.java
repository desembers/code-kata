package chapter1;

import java.util.Scanner;

public class 각도기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle = sc.nextInt(); //각도기 입력값

        if(0< angle && angle < 90) {
            System.out.println(1); //예각
        }else if(angle==90) {
            System.out.println(2); //직각
        }else if(90 < angle && angle < 180) {
            System.out.println(3); //둔각
        }else if(angle == 180) {
            System.out.println(4); //평각
        }else {
            System.out.println(-1); //아무것도 속하지 않는 각 (180도 초과)
        }
    }
}
