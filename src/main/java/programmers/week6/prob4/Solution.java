package programmers.week6.prob4;


public class Solution {

    public static boolean solution(String s, String t) {

        // 두 문자열의 길이가 같다는 조건 없음
        // 길이 다르면 에너그램 될수없음
        if (s.length() != t.length()) {
            return false; // 바로 false 반환해서 종료
        }

        // 두 문자열 길이 같으면 나머지 진행

        boolean answer = true; // 반환값 초기화

        int[] countArr = new int[26]; // 알파벳 등장 횟수 저장할 배열

        for(int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - 'a']++; // s 문자열의 문자 개수는 + 1
            countArr[t.charAt(i) - 'a']--; // t 문자열의 문자 개수는 - 1
        }

        // 횟수 배열 순회
        for (int count : countArr) {
            // 0 아닌 값이 있는 경우 에너그램 아님
            if (count != 0) {
                return false; // 바로 false 반환해서 종료
            }
        }

        return answer; // countArr 전부 0이면 true - 에너그램 O

    }

    public static void main(String[] args) {

        System.out.println(solution("imfinethankyou", "atfihnemnoyuki"));
    }
}