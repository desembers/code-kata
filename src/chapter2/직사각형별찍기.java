package chapter2;

import java.util.Scanner;

public class 직사각형별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.println("*");
            }
            System.out.println();
        }

    }
}
