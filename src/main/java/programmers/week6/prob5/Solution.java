package programmers.week6.prob5;


public class Solution {

    public static int solution(int N, int[][] trust) {

        // 모든 마을 사람들이 아무도 안믿으면
        if(trust.length == 0) return -1; // 판사 없음

        // 각 사람이 다른 사람을 믿는 횟수 배열
        int[] trustOthers = new int[N];

        // 각 사람이 다른 사람에게 믿음을 받은 횟수 배열
        int[] trustedByOthers = new int[N];

        for(int i = 0; i < trust.length; i++) {
            trustOthers[trust[i][0] - 1]++; // 다른 사람 믿은 횟수 + 1
            trustedByOthers[trust[i][1] - 1]++; // 다른 사람 한테 믿음 받은 횟수 + 1
        }

        for(int i = 0; i < N; i++) {

            // 아무도 믿지 않고 다른 모든 사람들이 믿어주는 사람이면
            if(trustOthers[i] == 0 && trustedByOthers[i] == N - 1) return i + 1; // 판사임

        }

        return -1; // 판사 없음

    }

    public static void main(String[] args) {

        int[][] arr = {{1,3}, {2,3}};

        System.out.println(solution(3, arr));
    }
}