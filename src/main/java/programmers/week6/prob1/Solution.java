package programmers.week6.prob1;

import java.util.*;

public class Solution {

    public static String solution(String s) {
        String answer = "";

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

        // 버블 정렬 시작
        // 기준 : 등장 횟수가 많은 숫자가 앞에오고, 등장 횟수가 같으면 숫자가 작은것이 앞에 오도록 정렬
        int size = countArr.length;
        boolean swapped; // 버블 정렬 최적화위한 변수

        for(int i = 0; i < size; i++) {

            swapped = false; // // 이번 반복에서 요소 교환(swap)이 발생했는지 여부 (정렬이 이미 되어 있으면 반복 조기 종료)

            for(int j = 0; j < size - 1; j++) {

                int count1 = countArr[numArr[j]]; // 왼쪽 숫자의 등장 횟수
                int count2 = countArr[numArr[j + 1]]; // 오른쪽 숫자의 등장 횟수

                // 등장 횟수가 더 작거나, 횟수가 같을 경우에는 숫자가 더 크면 교환
                if(count1 < count2 || (count1 == count2 && numArr[j] > numArr[j+1])) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;

                    swapped = true; // 교환 발생했음을 표시
                }

            }

            // 한 번도 교환이 발생하지 않으면 → 이미 정렬 완료된 상태 → 종료
            if(!swapped) break;

        }

        // 정렬된 숫자들을 공백으로 이어붙여 출력 문자열 구성
        StringJoiner sb = new StringJoiner(" ");
        for(int n : numArr) {
            sb.add(Integer.toString(n));
        }

        answer = sb.toString(); // 결과 문자열 반환

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("221123"));
    }
}
