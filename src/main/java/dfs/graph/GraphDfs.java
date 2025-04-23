package dfs.graph;

/*
 * [24479] 알고리즒 수업 - 깊이 우선 탐색 1
 * https://www.acmicpc.net/problem/24479
 */

import java.io.*;
import java.util.*;

class Vertex implements Comparable<Vertex> {

    int value; // 값
    int weight; // 가중치

    // 생성자
    public Vertex(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Vertex other) {
        return this.value - other.value; // value 기준 정렬
    }

}

public class GraphDfs {

    static List<List<Vertex>> graph; // 입력 받은 인접 그래프
    static List<Integer> visited; // 방문 여부를 기록할 리스트
    static int count = 0; // 순서 기록할 변수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        graph.add(null); // 0 번 인덱스 버림 (입력에서 1번이 시작임)

        // 정점 생성 (1 ~ N)
        for(int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Vertex(end, 1));
            graph.get(end).add(new Vertex(start, 1));
        }

        for(int i = 1; i <= N; i++) {
            // i 노드에 연결된 노드 목록 오름차순 정렬
            Collections.sort(graph.get(i));
        }

        /*
        // 그래프 연결 상태 확인
        for(int i = 1; i <= N; i++) {
            System.out.println(graph.get(i));
        }
         */

        // ArrayList를 크기 N + 1 로 초기화하고 모든 값을 0으로 채움
        visited = new ArrayList<>(Collections.nCopies(N + 1, 0));

        dfs(R);

        for(int i = 1; i <= N; i++) {
            System.out.println(visited.get(i));
        }

    }

    public static void dfs(int start) {

        count++; // count 초기값 0이므로 시작하자마자 +1 해서 1로 설정

        visited.set(start, count);
        for(Vertex next : graph.get(start)) {
            // 다음 노드가 방문 안했던 노드면
            if(visited.get(next.value) == 0) {
                dfs(next.value); // 다음 노드 방문
            }
        }

    }

}
