package search.binary;

import java.io.*;
import java.util.*;


public class BinarySearchMain {

    // 이진 탐색(target 찾으면 인덱스 반환)
    public static int binarySearch(int[] arr, int target) {

        // left, right 인덱스 초기값 설정
        int left = 0, right = arr.length - 1;

        // left가 right보다 커지면 바로 종료(target 존재 X)
        while(left <= right) {

            int mid = (left + right) / 2; // mid 값 설정

            // 중간값이 target이면
            if(arr[mid] == target) return mid; // 인덱스 반환, 탐색 종료
            else if(arr[mid] < target) left = mid + 1; // 중간값이 target 보다 작으면 left 값 갱신
            else right = mid - 1; // 중간값이 target 보다 크면 right 값 갱신

        }

        return -1; // 배열에 target 존재하지 않는다.

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 정렬 보장되어있다고 가정

        String[] inputData = br.readLine().split(" ");
        int[] arr = new int[inputData.length];
        for(int i = 0; i < inputData.length; i++) {
            arr[i] = Integer.parseInt(inputData[i]);
        }

        // Arrays.sort(arr) // 배열의 정렬을 보장할 수 없다면, 정렬을 하고 search를 해야함

        int target = Integer.parseInt(br.readLine());
        int index = binarySearch(arr, target); // -1이 오면 존재하지 않는다는 듯
        System.out.println("찾고자 한 값 " + target + "의 위치는 "
                + (index == -1 ? "존재하지 않는다" : (index + " 인덱스에 있다.")));

    }

}
