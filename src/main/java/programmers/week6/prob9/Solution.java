package programmers.week6.prob9;


import java.util.PriorityQueue;

public class Solution {

    public static int solution(int[][] z) {

        int x = z[0].length; // 수영장 가로 길이
        int y = z.length; // 수영장 세로 길이

        // 우선순위 큐(최소힙) 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[][] visited = new int[y][x];

        for(int i = 0; i < y; i++) {

            for(int j = 0; j < x; j++) {

                if ((i == 0 || i == y - 1 || j == 0 || j == x - 1)) {
                    queue.offer(z[i][j]); // 외곽(테두리)만 큐에 먼저 넣음
                    visited[i][j] = 1; // visited 처리
                }

            }
        }


        return 0;

    }


    public static void main(String[] args) {

        int[][] heights = {
                {3, 4, 5, 4, 3, 3},
                {3, 2, 1, 1, 2, 3},
                {4, 2, 1, 1, 2, 3},
                {3, 3, 3, 3, 5, 3}
        };

        System.out.println(solution(heights));

    }
}