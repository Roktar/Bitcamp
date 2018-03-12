package bitcamp.java106.pms.domain;

import bitcamp.java106.pms.domain.AbstractDescriptionFactory;

public class DescriptionFactory2 {
    public static Description getDescription(AbstractDescriptionFactory d) {
        return d.createDescription();
    }

    public static int getNumber(String s) {
        switch(s) {
            case "team" :
                return 0;
            case "member" :
                return 1;
        }
        return -1;
    }
}