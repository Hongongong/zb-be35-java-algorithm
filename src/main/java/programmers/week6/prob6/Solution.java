package programmers.week6.prob6;


public class Solution {

    // N개의 튀김기로 M마리의 치킨을 튀기는 데 걸리는 최소 시간을 반환하는 함수
    public static int solution(int N, int M, int[] fry, int[] clean) {

        int left = 1; // 이진 탐색 범위의 시작 (시간 최소값)
        int right = 0; // 이진 탐색 범위의 끝 (시간 최대값)
        int mid = 0; // 현재 이진 탐색 중간 시간

        // 가장 느린 튀김기의 1사이클(fry + clean) 시간을 기준으로 최대 예상 시간을 설정
        for(int i = 0; i < N; i++) {
            right = Math.max(right, fry[i] + clean[i]); // 가장 긴 사이클 시간 찾기
        }

        right *= M; // 모든 치킨을 가장 느린 튀김기로만 튀긴다고 가정한 최대 시간

        int answer = right; // 가능한 최소 시간을 저장할 변수 (답 후보)

        // 이진 탐색 시작
        while(left <= right) {

            mid = (left + right) / 2; // 현재 시점에서 시험해볼 시간

            int cnt = 0; // mid 시간 동안 튀겨낼 수 있는 치킨 수

            // 각 튀김기에 대해 계산
            for(int i = 0; i < N; i++) {

                int oneCycle = fry[i] + clean[i]; // 해당 튀김기의 한 사이클 시간
                cnt += mid / oneCycle; // 정규 사이클 내에 튀길 수 있는 치킨 수

                // 사이클 이외에 남은 시간으로 한 마리 더 튀길 수 있는 경우
                // (마지막 치킨 튀긴 후 청소 시간은 포함 안해도됨)
                if (mid % oneCycle >= fry[i]) {
                    cnt += 1; // 남은 시간으로 한 마리 추가 가능
                }

            }

            // mid 시간 내에 M마리 이상 튀겼으면 → 시간을 줄여보기
            if(cnt >= M){
                answer = mid; // 최소 시간 후보 저장
                right = mid - 1; // 더 짧은 시간으로 가능한지 탐색
            } else {
                // M마리보다 못 튀겼으면 → 시간이 부족하니 더 늘려야 함
                left = mid + 1;
            }

        }

        // 탐색을 마치고 찾은 최소 시간 반환
        return answer;

    }

    public static void main(String[] args) {

        int N = 2, M = 20;
        int[] fry = {3, 6};
        int[] clean = {2, 1};

        System.out.println(solution(N, M, fry, clean));
    }
}