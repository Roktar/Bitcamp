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
        Description sub;

        if(type)
            sub = new GroupDescription();
        else
            sub = new MemberDescription();

        sub.add(sc, question);
        data.add(sub);
        System.out.println();
    }

    public void getData() {
        for(int i=0; i<data.size(); i++)
            data.get(i).get();
        System.out.println();
    }

    public void findData(String target) {
                            
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).getBase().equals(target)) {
                data.get(i).get();
                System.out.println();
                return;
            }
        }
        System.out.println("해당 이름의 팀이 없습니다.\n");
    }

    // 아래는 우선 보류

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