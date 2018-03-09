package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.App;

public class MemberDescription extends Description {
    String m_id, m_email, m_pw;

    public void add(Scanner sc, String[] question) {
        System.out.print(question[0]);
        this.m_id = sc.nextLine();
        System.out.print(question[1]);
        this.m_email = sc.nextLine();
        System.out.print(question[2]);
        this.m_pw = sc.nextLine();
    }

    public void get() {
        System.out.printf("%s, %s, %s\n", this.m_id, this.m_email, this.m_pw); 
    }

    public String getBase() {
        return m_id;
    }
}