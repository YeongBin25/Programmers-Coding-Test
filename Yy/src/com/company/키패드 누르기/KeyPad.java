package com.company;

class Key {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        int ldis, rdis;
        for (int i = 0; i < numbers.length; i++) {
            ldis = 0; rdis = 0;
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            } else {
                int k = numbers[i];
                if (k == 0) {
                    k += 11;
                    //행(Y축) + 열(X축)
                    ldis = (Math.abs(k - left)) / 3 + (Math.abs(k - left)) % 3;
                    rdis = (Math.abs(k - right)) / 3 + (Math.abs(k - right)) % 3;

                    if (ldis > rdis) {
                        answer += "R";
                        right = k;
                    } else if (rdis > ldis) {
                        answer += "L";
                        left = k;
                    } else if (rdis == ldis) {
                        if (hand.equals("left")) {
                            answer += "L";
                            left = k;
                        } else {
                            answer += "R";
                            right = k;
                        }
                    }
                } else {
                    ldis = (Math.abs(numbers[i] - left)) / 3 + (Math.abs(numbers[i] - left)) % 3;
                    rdis = (Math.abs(numbers[i] - right)) / 3 + (Math.abs(numbers[i] - right)) % 3;

                    if (ldis > rdis) {
                        answer += "R";
                        right = numbers[i];
                    } else if (rdis > ldis) {
                        answer += "L";
                        left = numbers[i];
                    } else if (rdis == ldis) {
                        if (hand.equals("left")) {
                            answer += "L";
                            left = numbers[i];
                        } else {
                            answer += "R";
                            right = numbers[i];
                        }
                    }
                }
            }
        }
        return answer;
    }
}

public class KeyPad {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        Key k = new Key();
        k.solution(arr, "right");
    }
}
