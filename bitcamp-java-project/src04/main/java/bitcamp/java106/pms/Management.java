package bitcamp.java106.pms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import bitcamp.java106.pms.Description;
import bitcamp.java106.pms.GroupDescription;
import bitcamp.java106.pms.MemberDescription;

public class Management {
    private List<Description> data;

    public Management() {
        data = new ArrayList<Description>();
    }

    public void addData(Scanner sc, String[] question, boolean type) {
        Description sub = (type ? new GroupDescription() : new MemberDescription() );
        sub.add(sc, question);
        data.add(sub);
        System.out.println();
    }

    public void getData(int n) {
        int cnt = 0;
        for(int i=0; i<data.size(); i++) {
            cnt += data.get(i).get(n);
        }
        if(cnt <= 0)
            System.out.println("데이터가 없습니다.");
        System.out.println();
    }

    public void findData(String target, int n) {               
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).getBase().equals(target)) {
                data.get(i).get(n);
                System.out.println();
                return;
            }
        }
        System.out.println( ( n == 0 ? "해당 이름의 팀이 없습니다." : "해당 아이디의 회원이 없습니다." ) + "\n" );
    }
}