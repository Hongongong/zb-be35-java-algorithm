package greedy;

import java.io.*;
import java.util.*;

public class GoldBagGreedy {

    public static class Gold implements Comparable<Gold> {

        int weight, value;

        public Gold(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Gold other) {

            double thisValuePerWeight = (double) this.value / this.weight; // this의 금 1kg 당 가치
            double otherValuePerWeight = (double) other.value / other.weight; // other의 금 1kg 당 가치

            // Double내 자체 비교 compare 메소드 사용
            // this가 앞에있으면 오름차순, this가 뒤에있으면 내림차순
            return Double.compare(otherValuePerWeight, thisValuePerWeight); // 내림차순 정렬
        }

        @Override
        public String toString() {

            return String.format("[%s, %s, %s]", weight, value, (double)value / weight);

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputData = br.readLine().split(" ");
        int n = Integer.parseInt(inputData[0]); // 금덩이 개수
        int maxWeight = Integer.parseInt(inputData[1]); // 가방 최대 무게

        List<Gold> goldList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            inputData = br.readLine().split(" ");

            int weight = Integer.parseInt(inputData[0]); // 금 무게
            int value = Integer.parseInt(inputData[1]); // 금 가치

            goldList.add(new Gold(weight, value)); // 금 객체 만들어서 리스트에 저장

        }

        Collections.sort(goldList); // 금 1kg 당 가치 기준으로 내림차순 정렬

        int totalValue = 0; // 총 금 가치
        int currentWeight = 0; // 현재 가방 무게

        System.out.println("<<< 내림차순 정렬 확인 >>>");

        for(Gold gold : goldList) {
            System.out.println(gold); // 내림차순 정렬 확인

            if(currentWeight + gold.weight <= maxWeight) {
                currentWeight += gold.weight;
                totalValue += gold.value;
            } else {
                int remainWeight = maxWeight - currentWeight; // 가방 남은 무게
                totalValue += gold.value / gold.weight * remainWeight; // 금 잘라서 최대한 넣음
                break; // 가방 넣기 종료
            }

        }

            System.out.println("가방 총 가치 : " + totalValue);

    }

}
