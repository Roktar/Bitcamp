package bitcamp.java106.pms;

import java.util.Scanner;

public abstract class Description {
    public abstract void add(Scanner sc, String[] questions);
    public abstract int get(int n);
    public abstract String getBase();
}