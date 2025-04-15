package greedy;

import java.io.*;
import java.util.*;

public class GreedyMeetingSelector {

    // 회의 정보 클래스
    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 정렬 기준 설정
        @Override
        public int compareTo(Meeting other) {

            // end가 같으면 start로 정렬
            if(this.end == other.end) {
                return this.start - other.start;
            }

            // 내 값이 크면 양수, 작으면 음수, 같으면 0 반환됨
            return this.end - other.end; // 결과 양수로 나오면 오름차순, 음수 나오면 내림차순
        }

        @Override
        public String toString() {
            return String.format("[%s, %s]", this.start, this.end);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 회의 개수

        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] inputData = br.readLine().split(" ");
            int start = Integer.parseInt(inputData[0]);
            int end = Integer.parseInt(inputData[1]);
            meetings.add(new Meeting(start, end));

            System.out.println(meetings.get(i));
        }

        System.out.println("<<< 정렬 전 >>>");
        for(Meeting m : meetings) {
            System.out.println(m);
        }

        // 내가 정한 기준으로 정렬
        Collections.sort(meetings);

        System.out.println("<<< end 기준 정렬 후 >>>");
        for(Meeting m : meetings) {
            System.out.println(m);
        }

        int count = 0;
        int lastEndTime = 0; // 마지막 회의 종료 시간

        for(Meeting m : meetings) {
            // 현재 m 회의 시간이 지난 마지막 회의 종료시간보다 같거나 크면
            if(m.start >= lastEndTime) {
                count++; // 회의 배정 개수 증가
                lastEndTime = m.end; // 마지막 회의 종료시간 갱신

                 System.out.println("배정 : " + m);
            }
        }

        System.out.println("회의 배정 개수 : " + count);

    }

}
