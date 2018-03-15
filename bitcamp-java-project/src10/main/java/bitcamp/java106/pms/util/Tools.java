package bitcamp.java106.pms.util;

import java.util.List;
import java.util.ArrayList;
import bitcamp.java106.pms.origin_type.Description;

public class Tools {
    public static boolean is_equals_command(String[] list, String target) {
        for(int i=0; i<list.length; i++) {
            if(list[i].equals(target)) 
                return true;
        }
        return false;
    }

    public static int getCount(String str, char search) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == search)
                count++;
        }
        return count;
    }

    public static boolean isDuplicate(List<Description> data, String target, int n) {
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).getBase().toLowerCase().equals(target.toLowerCase())) {
                if(data.get(i).getNumber() == n)
                    return true;
            }
        }
        return false;
    }

}