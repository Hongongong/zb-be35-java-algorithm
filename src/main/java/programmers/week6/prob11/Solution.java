package programmers.week6.prob11;

import java.util.*;

public class Solution {

    public static int solution(int[][] activity) {

        // 회의 총 개수
        int n = activity.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        // 시작 시간, 끝 시간 배열 분리
        for (int i = 0; i < n; i++) {
            starts[i] = activity[i][0];
            ends[i] = activity[i][1];
        }

        Arrays.sort(starts); // 시작 시간 오름차순 정렬
        Arrays.sort(ends);   // 종료 시간 오름차순 정렬


        int maxConcurrent = 0; // 가장 많은 동시 회의 수를 저장할 변수 ( = 필요한 최소 분신 수 )
        int concurrent = 0; // 현재 시점에 동시에 진행 중인 회의 수

        int i = 0; // 시작시간 배열의 인덱스 (start pointer)
        int j = 0; // 종료시간 배열의 인덱스 (end pointer)

        // 모든 회의의 시작 시간이 처리될 때까지 반복
        while (i < n) {
            if (starts[i] < ends[j]) {
                // 새 회의가 시작되었지만, 이전 회의들 중 끝난 회의가 아직 없음
                // 즉, 분신이 더 필요함
                concurrent++; // 현재 동시 회의 수 증가
                maxConcurrent = Math.max(maxConcurrent, concurrent); // 최대값 갱신
                i++; // 다음 회의 시작 시간으로 이동
            } else {
                // 시작 시간 >= 종료 시간 → 회의 하나 종료됨
                // 분신 하나가 일을 끝냈다고 생각
                concurrent--; // 현재 동시 회의 수 감소
                j++; // 다음 종료 시간으로 이동
            }
        }

        // 필요한 최소 분신 수 반환
        return maxConcurrent;

    }


    public static void main(String[] args) {

        int[][] activity = {{0, 5}, {2, 6}, {3, 5}, {7, 10}, {5, 9}, {13, 15} };

        System.out.println(solution(activity));

    }
}