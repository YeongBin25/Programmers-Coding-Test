package com.company;

class Col {
    public int solution(int num) {
        int answer = 0;
        while (num != 1) {
            if (num % 2 == 1) {
                num = (num * 3) + 1;
                answer++;
            }
            else {
                num /= 2;
                answer++;
            }
            if (answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}

public class Colats {
    public static void main(String[] args) {
        Col c = new Col();
        c.solution(16);
    }
}
