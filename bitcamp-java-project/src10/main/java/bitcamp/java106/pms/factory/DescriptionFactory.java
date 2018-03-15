package bitcamp.java106.pms.factory;

import bitcamp.java106.pms.origin_type.*;
import bitcamp.java106.pms.type.*;

public class DescriptionFactory {
    public static Description createDescription(int n) {
        switch(n) {
            case 0 :
                return new GroupDescription();
            case 1 :
                return new MemberDescription();
            case 2 :
                return new BoardDescription();
        }
        return null;
    }

    public static int getNumber(String s) {
        switch(s) {
            case "team" :
                return 0;
            case "member" :
                return 1;
            case "board" :
                return 2;
        }
        return -1;
    }
}