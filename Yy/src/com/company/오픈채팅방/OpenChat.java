
package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class OpenChatTest {
    public String[] solution(String[] record) {
        String[] answer;
        Map<String, String> hash = new HashMap<>();
        List<String[]> l = new LinkedList<>();

        for (int k = 0; k < record.length; k++) {
            String s = record[k];
            String[] userinfo = s.split(" "); // 띄어쓰기 별로 구분해 배열 첨가

            if (userinfo[0].equals("Enter")) {
                hash.put(userinfo[1], userinfo[2]);
                l.add(userinfo);
            }
            else if (userinfo[0].equals("Change")) {
                hash.put(userinfo[1], userinfo[2]);
            }
            else {
                l.add(userinfo);
            }
        }
        /*
            <uid1234 , Muzi> - <uid1234 , Prodo>
            <uid4567 , Prodo> - <uid1234 , Ryan>
            최종
            <uid1234 , Prodo>
            <uid1234 , Ryan>

            list에는 들어오고 나간것을 출력해주는 내용이없는 Change빼고 다 추가
         */
        // System.out.println(l.size());

        for (int k = 0; k < l.size(); k++) {
            String[] key = l.get(k);
        }

        answer = new String[l.size()];
        int idx = 0;
        for (String[] key : l){
            String name = hash.get(key[1]); // Key(userid)에 대한 Value(이름)이 출력
            //System.out.print(name);
            if (key[0].equals("Enter")) {
                answer[idx++] = name + "님이 들어왔습니다.";
            }
            else {
                answer[idx++] = name + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}

public class OpenChat {
    public static void main(String[] args) {
        String[] a = { "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };
        OpenChatTest o = new OpenChatTest();
        String[] b = o.solution(a);

        for (int i = 0; i < b.length; i++)
            System.out.print(b[i]);

    }
}
