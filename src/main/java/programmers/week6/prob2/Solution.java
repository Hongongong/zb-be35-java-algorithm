package programmers.week6.prob2;

import java.util.*;

public class Solution {

    // 문자열 비교를 위한 사용자 정의 정렬 기준 클래스
    public static class MyComparator implements Comparator<String> {

        // Comparator 인터페이스 구현 시 필수 작성 메서드
        // 두 문자열을 이어붙인 후 비교하여 정렬 순서를 결정
        // 내림차순 정렬 (큰 숫자가 앞에 오도록)
        @Override
        public int compare(String a, String b) {

            // 반환값: 음수 → a가 앞, 0 → 같음, 양수 → b가 앞
            // (b+a)가 (a+b)보다 크면 b가 먼저 와야 하므로 (b+a).compareTo(a+b) 사용
            return (b + a).compareTo(a + b);

        }

    }

    public static String solution(int[] numbers) {

        // 숫자 배열을 문자열 배열로 변환(숫자 이어붙여서 비교하기 위함)
        String[] strNumArr = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            strNumArr[i] = String.valueOf(numbers[i]); // int -> String 변환
        }

        // 버블 정렬은 시간 초과 발생
        // 자바 내장 sort 함수 사용하면 훨씬 빠름 - 실제로 더 자주 쓰임
        // 정렬 기준에 따라 문자열 배열 정렬
        Arrays.sort(strNumArr, new MyComparator());

        // 정렬된 문자열 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (String num : strNumArr) {
            sb.append(num);
        }

        // 결과 문자열 반환
        return sb.toString();
    }

    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }
}