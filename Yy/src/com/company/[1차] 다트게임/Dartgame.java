package com.company;

class DartgameTest {
    public int solution(String dartResult) {
        int answer = 0;
        String s = "";
        int arr[] = new int[3];
        int idx = 0;

        for(int i = 0;i<dartResult.length();i++){
            switch(dartResult.charAt(i)){
                // 보너스 제곱 구현
                case 'S':
                    int mit = Integer.parseInt(s);
                    arr[idx] = (int)Math.pow(mit , 1);
                    idx++;
                    s ="";
                    break;
                case 'D':
                    mit = Integer.parseInt(s);
                    arr[idx] = (int)Math.pow(mit , 2);
                    idx++;
                    s ="";
                    break;
                case 'T':
                    mit = Integer.parseInt(s);
                    arr[idx] = (int)Math.pow(mit , 3);
                    idx++;
                    s ="";
                    break;
                // 옵션 추가
                case '*':
                    arr[idx-1] *= 2;
                    if(idx > 1)
                        arr[idx-2] *= 2;
                    break;
                case '#':
                    arr[idx-1] *= -1;
                    break;
                default:
                    // 나머지 숫자들
                    s += String.valueOf(dartResult.charAt(i));
                    break;
            }
        }


        for(int i = 0;i < arr.length; i++){
            answer += arr[i];
        }

        return answer;
    }
}

public class Dartgame {
    public static void main(String[] args) {
        DartgameTest d = new DartgameTest();
        d.solution("1S2D*3T");
    }
}
