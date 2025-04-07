package sort.selection;

import java.util.*;
import java.io.*;

public class SelectionSortMain {

    // 선택 정렬 메소드
    public static void selectionSort(int[] arr) {

        int size = arr.length;

        for(int i = 0; i < size - 1; i++) {

            // 이번 라운드 최소값 index 저장하기위함
            int minIndex = i;

            // 라운드 시작 인덱스 다음 요소부터 값 비교
            for(int j = i + 1; j < size; j++) {
                // 최소값 발견하면
                if(arr[j] < arr[minIndex]) {
                    minIndex = j; // 최소값 index 변경
                }
            }

            // 이번 라운드 최소값과 자리 변경
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputData = br.readLine().split(" ");
        int[] arr = new int[inputData.length];
        for(int i = 0; i < inputData.length; i++) {
            arr[i] = Integer.parseInt(inputData[i]);
        }

        System.out.println("정렬 전 : " + Arrays.toString(arr));

        selectionSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));

    }

}
