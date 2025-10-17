package chapter2;

class Solution35 {
    //등차수열의 합 - total_price = price * count * (count + 1) / 2
    //총이용금액 계산하고, 현재 가진돈 money보다 크면 그차이만큼 부족한 금액 반환하고, 부족하지않으면 0으로 반환
    public long solution(int price, int money ,int count) {
        long totalCost = (long) price * count * (count + 1) / 2;
        long shortage = totalCost - money;
        return shortage > 0 ? shortage : 0;
    }
}

public class 부족한금액계산하기 {
    public static void main(String[] args) {
        Solution35 sol = new Solution35();
        System.out.println(sol.solution(3, 20, 4));
    }
}
