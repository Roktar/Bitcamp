package bitcamp.java106.pms;

import java.util.Scanner;

public class GroupDescription {
    String tName, tDes, tMax, tStart, tEnd;

    public GroupDescription() {
        this.tName = "";
        this.tDes = "";
        this.tMax = "";
        this.tStart = "";
        this.tEnd = "";
    }

    public void setData(int idx, Scanner sc, String[] question) {
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

    public void printData() {
        System.out.printf("%s, %s, %s\n", this.tName, this.tMax, this.tStart + " ~ " + this.tEnd); 
    }
}