package programmers.week6.prob8;

import java.util.*;

public class Solution {

    public static String solution(String s, int k) {

        // Stack 사용 이유: 앞자리 숫자보다 더 작은 수가 나오면
        // 이전 숫자를 지우고 현재 숫자를 넣는 방식이기 때문에
        // 최근 삽입된 문자를 빠르게 제거할 수 있는 Stack 사용
        Stack<Character> stack = new Stack<>();

        // 입력 문자열의 각 문자를 순회
        for(int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            // 현재 숫자보다 앞에 있는 숫자가 크면 pop
            // 숫자를 k개만 지울 수 있으므로, k > 0일 때만 가능
            // stack이 비어 있지 않은 경우만 pop 가능
            while(!stack.isEmpty() && stack.peek() > current && k > 0) {
                stack.pop(); // 큰 숫자 제거
                k--; // 제거한 개수만큼 k 감소
            }

            // 현재 문자를 stack에 추가
            stack.push(current);

        }

        // 문자열을 다 순회하고 나서도 k가 남아있다면,
        // 뒤에서부터 남은 k만큼 숫자 제거
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // 최종 결과 문자열을 담을 StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        // 앞자리 0을 제거하기 위한 플래그
        boolean flag = true;

        // stack에 남아있는 문자를 앞에서부터 하나씩 꺼냄
        for(char c : stack) {
            // 앞자리 0 은 무시
            if(flag && c == '0') {
                continue; // 문자열에 추가 안하고 넘김
            }

            flag = false; // 앞자리 0 모두 제거 후 flag 종료
            sb.append(c); // 결과 문자열에 추가
        }


        // 정식 자바 문법상 sb.length() 가 맞음
        // IntelliJ 편의 기능으로 sb.isEmpty() 제공됨 - IntelliJ 추천 무조건 믿지말것
        // sb 비었을때(결과 0일때)는 "0" 반환
        return sb.length() == 0 ? "0" : sb.toString(); // StringBuilder -> String 변환해서 반환

    }


    public static void main(String[] args) {

        System.out.println(solution("105990", 2));

    }
}