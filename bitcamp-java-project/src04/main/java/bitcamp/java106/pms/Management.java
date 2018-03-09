package bitcamp.java106.pms;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import bitcamp.java106.pms.Description;
import bitcamp.java106.pms.GroupDescription;
import bitcamp.java106.pms.MemberDescription;

public class Management {
    private List<Description> data;
    // private List<GroupDescription> g_data;
    // private List<MemberDescription> m_data;
    // private List<Description[][]> n_data; // 이걸 쓸거면 분류별로 인덱스 별도로 보유해야할 듯.

    public Management() {
        data = new ArrayList<Description>();
        // g_data = new ArrayList<GroupDescription>();
        // m_data = new ArrayList<MemberDescription>();
        // n_data = new ArrayList<Description[][]>();
    }

    public void addData(Scanner sc, String[] question, boolean type) {
        Description sub;

        if(type)
            sub = new GroupDescription();
        else
            sub = new MemberDescription();

        sub.add(sc, question);
        data.add(sub);
        System.out.println();
    }

    public void getData(boolean type) {
        int cnt = 0;

        for(int i=0; i<data.size(); i++) {
            if(type) {
                if(data.get(i) instanceof GroupDescription) {
                    data.get(i).get();
                    cnt++;
                }
            } else {
                if(data.get(i) instanceof MemberDescription) {
                    data.get(i).get();                  
                    cnt++;
                }
            }
        }
        if(cnt <= 0)
            System.out.println("데이터가 없습니다.");
        System.out.println();
    }

    public void findData(String target, boolean type) {
        if(data.size() <= 0)
            System.out.println("등록된 정보가 없습니다.");
        else {                    
            for(int i=0; i<data.size(); i++) {
                if(data.get(i).getBase().equals(target)) {
                    data.get(i).get();
                    System.out.println();
                    return;
                }
            }
            System.out.println( ( type ? "해당 이름의 팀이 없습니다." : "해당 아이디의 회원이 없습니다." ) + "\n" );
        }
    }

    // public void addTeam(Scanner sc, String[] question) {
    //     GroupDescription g_sub = new GroupDescription();
    //     g_sub.setData(sc, question);
    //     g_data.add(g_sub);
    //     System.out.println();
    // }

    // public void getTeam() {
    //     for(int i=0; i<g_data.size(); i++)
    //         g_data.get(i).printData();
    //     System.out.println();
    // }

    // public void findTeam(String target) {
    //     boolean check = false;
                            
    //     for(int i=0; i<g_data.size(); i++) {
    //         if(g_data.get(i).tName.equals(target)) {
    //             g_data.get(i).printData();
    //             check = true;
    //             System.out.println();
    //             break;
    //         }
    //     }
    //     if(!check)
    //         System.out.println("해당 이름의 팀이 없습니다.\n");
    // }

    // public void addMember(Scanner sc, String[] question) {
    //     MemberDescription m_sub = new MemberDescription();
    //     m_sub.setData(sc, question);
    //     m_data.add(m_sub);
    //     System.out.println();
    // }

    // public void getMember() {
    //     for(int i=0; i<m_data.size(); i++)
    //         m_data.get(i).printData();
    // }

    // public void findMember(String target) {
    //     boolean check = false;
                            
    //     for(int i=0; i<m_data.size(); i++) {
    //         if(m_data.get(i).m_id.equals(target)) {
    //             m_data.get(i).printData();
    //             check = true;
    //             System.out.println();
    //             break;
    //         }
    //     }
    //     if(!check)
    //         System.out.println("해당 아이디의 회원이 없습니다.\n");
    // }
}