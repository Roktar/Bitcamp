package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.App;

public class MemberDescription extends Description {
    String m_id, m_email, m_pw;
    private int num = 1;

    public void add(Scanner sc, String[] question) {
        System.out.print(question[0]);
        this.m_id = sc.nextLine();
        System.out.print(question[1]);
        this.m_email = sc.nextLine();
        System.out.print(question[2]);
        this.m_pw = sc.nextLine();
    }

    public int get(int n) {
        if(num == n) {
            System.out.printf("%s, %s, %s\n", this.m_id, this.m_email, this.m_pw); 
            return 1;
        }
        return 0;
    }

    public String getBase() {
        return m_id;
    }
}