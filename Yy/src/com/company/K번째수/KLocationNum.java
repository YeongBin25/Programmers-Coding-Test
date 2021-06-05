package com.company;

import java.util.Arrays;
class So {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int s = 0; //자르기 시작
        int e = 0; //자르기 끝
        int an = 0; // x번째 수

        for (int i = 0; i < commands.length; i++) {
            s = commands[i][0];
            e = commands[i][1];
            an = commands[i][2];

            int arr[] = new int[(e+1)-s];
            int q = 0;
            for (int j = s-1; j < e; j++) {
                arr[q] = array[j];
                q++;
            }
            Arrays.sort(arr);
            answer[i] = arr[an-1];
        }
        return answer;
    }
}

public class KLocationNum {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7 ,3}};
        So s = new So();
        s.solution(array, commands);
    }
}
