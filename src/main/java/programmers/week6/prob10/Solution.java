package programmers.week6.prob10;

import java.util.*;

public class Solution {

    public static int solution(int[][] value) {

        // 각 돌 마다 두 플레이어에게 주는 점수의 합을 기준으로 내림차순 정렬
        // 합이 클 수록 해당 돌의 "영향력"이 큼 (누가 가져가도 점수 변화 큼)
        // 영향려이 큰 돌부터 먼저 선택하는 것이 양쪽 모두에게 최적 전략이 됨
        // 단, 두 플레이어가 서로의 돌 가치를 알고 있어야 가능한 전략임
        Arrays.sort(value, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        // 각 플레이어의 점수 합
        int player1 = 0;
        int player2 = 0;

        // 돌들을 하나씩 번갈아가며 선택
        for (int i = 0; i < value.length; i++) {
            if (i % 2 == 0) {
                // 첫 번째 플레이어 차례
                player1 += value[i][0];
            } else {
                // 두 번째 플레이어 차례
                player2 += value[i][1];
            }
        }

        // 게임 결과 비교 후 반환
        if (player1 > player2) return 1; // 플레이어1 승리
        else if (player1 == player2) return 0; // 무승부
        else return -1; // 플레이어2 승리

    }


    public static void main(String[] args) {

        int[][] value = { {5, 3}, {6, 9}, {4, 5}, {6, 3}, {2, 8}, {5, 4} };

        System.out.println(solution(value));

    }
}