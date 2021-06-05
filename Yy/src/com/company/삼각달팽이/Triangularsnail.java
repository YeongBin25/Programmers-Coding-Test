package com.company;

class Solut {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2]; // 공식 크기
        int arr[][] = new int[n][]; // 가변 배열
        int num = 1; // 처음 숫자(입력)
        int r = n - 1; // 4일때 [0 ~ 4][0]
        int fi = 0;
        int next = 0;
        int ke = n - 1;
        int n2 = n;

        for (int i = 0; i < n; i++)
            arr[i] = new int[i + 1];

        while (n != 0) {
            if (n == 0)
                break;
            // 왼쪽
            for (int i = fi; i <= r; i++) { // i는 계속 증가 , fi = 0, r = 5 두번째는 2 ~ 4
                arr[i][next] = num; // 처음 돌때는 여기에 fi넣음 0값
                num++;
            }
            n--; // 한변끝
            fi += 2; // *** 한번돌고는 다음 시작값은 밑변 관계없이 2로 시작 ***
            next++; // *** 위랑같이 한번돌고는 다음 시작값은 1로 시작 ex) [2][1] ***

            if (n == 0)
                break;
            // 아래 밑단
            for (int j = 1; j <= n; j++) { // n = 5
                arr[r][next + j - 1] = num; // 2 + 1 - 1 = 2 // 한번돌고는 밑변 시작이 2가되서 변수하나 더둬서 그 변수값 증가 위에서 처음엔 위에처럼 j를 씀 j+1(인덱스 에러)
                num++;
            }
            n--;

            if (n == 0)
                break;
            // 오른쪽
            for (int k = 1; k <= n; k++) {
                arr[r - k][ke - k] = num; // 5 - 1 = 4
                num++;
            }
            r -= 1; // *** 한번돌고올때마다 내가 원래빼준값보다 1을 더빼줘야하는 규칙 ***
            ke -= 2; // *** 뒤에 y값은 처음돌때처럼 [4][4]이게 아니고 [3][2]로 하나가 적어서 -2를함 ***
            n--;
        }

        int k = 0;
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[k++] = arr[i][j];
            }
        }

        return answer;
    }
}


public class Triangularsnail {
    public static void main(String[] args) {
        Solut s = new Solut();
        int[] an = s.solution(6);

        for (int i : an) {
            //System.out.print(i + " ");
        }
    }

}

