package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.App;

public class GroupDescription extends Description {
    String tName, tDes, tMax, tStart, tEnd;
    private int num = 0;

    public void add(Scanner sc, String[] question) {
        System.out.print(question[0]);
        this.tName = sc.nextLine();
        System.out.print(question[1]);
        this.tDes = sc.nextLine();
        System.out.print(question[2]);
        this.tMax = sc.nextLine();
        System.out.print(question[3]);
        this.tStart = sc.nextLine();
        System.out.print(question[4]);
        this.tEnd = sc.nextLine();
    }

    public int get(int n) {
        if(num == n) {
            System.out.printf("%s, %s, %s\n", this.tName, this.tMax, this.tStart + " ~ " + this.tEnd); 
            return 1;
        }
        return 0;
    }

    public String getBase() {
        return tName;
    }
}