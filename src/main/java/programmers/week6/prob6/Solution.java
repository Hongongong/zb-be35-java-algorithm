package programmers.week6.prob6;


public class Solution {

    public static int solution(int N, int M, int[] fry, int[] clean) {

        int maxMachineTime = 0;
        for(int i = 0; i < N; i++) {
            if(maxMachineTime < fry[i] + clean[i]) {
                maxMachineTime = fry[i] + clean[i];
            }
        }


        int maxFriedTime = maxMachineTime * M;

        // 이진 탐색 시작
        int left = 1;
        int right = maxFriedTime;

        int answer = 0;

        while(left <= right) {

            int mid = (left + right) / 2;

            int canFriedCount = 0;

            for(int i = 0; i < N; i++) {
                int friedTime = fry[i] + clean[i];
                // 🔥 마지막 clean까지 포함해서 가능한 개수 계산 = > 이해 안됨 ㅠ
                canFriedCount += (mid + clean[i]) / friedTime;
            }

            if(canFriedCount >= M) {
                answer = mid;       // 가능하므로 후보 저장
                right = mid - 1;    // 더 짧은 시간도 가능한지 탐색
            } else {
                left = mid + 1;
            }

        }

        return answer;

    }

    public static void main(String[] args) {

        int N = 4, M = 2;
        int[] fry = {2, 2, 1, 3};
        int[] clean = {2, 4, 3, 2};

        System.out.println(solution(N, M, fry, clean));
    }
}