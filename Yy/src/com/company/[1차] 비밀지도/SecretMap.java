package com.company;

class MapTest {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int arr[][] = new int[n][n];
        int a[][] = new int[n][n];
        int b[][] = new int[n][n];

        for (int i = 0; i < arr1.length; i++) {
            int check = arr1[i];
            while (check != 0) {
                for (int j = n - 1; j >= 0; j--) {
                    a[i][j] = check % 2;
                    check /= 2;
                }
            }
        }

        for (int k = 0; k < arr2.length; k++) {
            int check = arr2[k];
            while (check != 0) {
                for (int l = n - 1; l >= 0; l--) {
                    b[k][l] = check % 2;
                    check /= 2;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            answer[i] = "";
            for (int j = 0; j < arr1.length; j++) {
                if (a[i][j] == b[i][j])
                    if (a[i][j] == 0)
                        answer[i] += " ";
                    else
                        answer[i] += "#";
                else
                    answer[i] += "#";
            }
        }

        return answer;
    }
}

public class SecretMap {
    public static void main(String[] args) {
        int[] a = {9, 20, 28, 18, 11};
        int[] b = {30, 1, 21, 17, 28};
        MapTest m = new MapTest();
        String answer[] = {};
        answer = m.solution(5, a, b);
        for (int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }
}
