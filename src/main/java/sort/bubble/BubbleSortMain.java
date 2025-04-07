package sort.bubble;

import java.util.*;
import java.io.*;

public class BubbleSortMain {

    // 버블 정렬 메소드
    private static void bubbleSort(int[] arr) {

        int size = arr.length;
        boolean swapped; // 정렬 끝난지 확인하기 위한 변수

        for(int i = 0; i < size; i++) {

            swapped = false; // 교환시 true 되게

            // 한 패스마다 비교 횟수 1씩 줄음
            for(int j = 0; j < size - 1 - i; j++) {

                // arr[j]가 arr[j+1]보다 크면
                if(arr[j] > arr[j + 1]) {

                    // 자리 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // 한번이라도 교환 했으면 true

                }

            }

            // 이미 정렬 완성되있는 경우
            if(!swapped) break; // 더이상 정렬하지 않고 종료 (버블 정렬 조금이라도 짧게 수행하기위함)

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputData = br.readLine().split(" ");

        int[] arr = new int[inputData.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(inputData[i]);
        }

        System.out.println("정렬 전 : " + Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));

    }

}
