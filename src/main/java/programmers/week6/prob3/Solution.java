package programmers.week6.prob3;

import java.util.*;

public class Solution {

    public static String solution(String s) {

        // 0 ~ 9 가 문자열에서 등장한 횟수 저장할 배열
        int[] countArr = new int[10];

        // 문자열 한글자씩 순회하면서 각 숫자 등장 횟수 계산
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0'; // char -> int 변환
            countArr[num]++; // 해당 숫자의 등장 횟수 증가
        }

        // 0 ~ 9 까지 숫자 담을 배열 (정렬 대상)
        int[] numArr = new int[10];
        for(int i = 0; i < numArr.length; i++) {
            numArr[i] = i; // 0 ~ 9 저장
        }

        // 선택 정렬 시작
        // 기준 : 등장 횟수가 많은 숫자 또는 등장 횟수가 같으면 숫자가 작은것이 앞에 오도록 정렬
        int size = countArr.length;

        for(int i = 0; i < size - 1; i++) {

            // cntMaxIdx 초기값 = 현재 위치(i)로 설정
            int cntMaxIdx = i;

            // i 이후 범위에서 기준에 따라 더 앞에 와야 할 숫자 찾기
            for(int j = i + 1; j < size; j++) {

                int currentCount = countArr[numArr[j]]; // 현재 j번째 숫자의 등장 횟수 가져옴
                int maxIndexCount = countArr[numArr[cntMaxIdx]]; // 현재 cntMaxIdx 숫자의 등장 횟수 가져옴

                // cntMaxIdx 갱신
                if(currentCount > maxIndexCount || (currentCount == maxIndexCount && numArr[j] < numArr[cntMaxIdx])) {
                    cntMaxIdx = j;
                }

            }

            // i번째 위치의 숫자 <-> cntMaxIdx 위치의 숫자
            int temp = numArr[cntMaxIdx];
            numArr[cntMaxIdx] = numArr[i];
            numArr[i] = temp;

        }

        StringJoiner sj = new StringJoiner(" ");
        for(int n : numArr) {
            sj.add(String.valueOf(n));
        }


        return sj.toString();
    }

    public static void main(String[] args) {

        System.out.println(solution("221123"));
    }
}