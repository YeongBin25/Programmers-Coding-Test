package com.company;

import java.util.Arrays;
class Solu {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int total = 0;
        Arrays.sort(d);
        while (true) {
            for (int i = 0; i < d.length; i++) {
                total += d[i];
                answer++;
                if (total > budget) {
                    answer--;
                    total -= d[i];
                }
            }
            break;
        }

        return answer;
    }
}

public class Budget {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 5, 4};
        Solu s = new Solu();
        s.solution(arr, 9);
    }
}
