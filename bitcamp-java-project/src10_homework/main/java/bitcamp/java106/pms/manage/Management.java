package bitcamp.java106.pms.manage;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import bitcamp.java106.pms.origin_type.Description;
import bitcamp.java106.pms.type.GroupDescription;
import bitcamp.java106.pms.type.MemberDescription;
import bitcamp.java106.pms.type.BoardDescription;
import bitcamp.java106.pms.factory.DescriptionFactory;
import bitcamp.java106.pms.util.DescriptionUtils;
import bitcamp.java106.pms.util.Tools;

public class Management {
    private static Management manage;
    private List<Description> data;

    private Management() {
        data = new ArrayList<Description>();
    }

    public static Management getInstance() {
        if(manage == null)
            manage = new Management();
        return manage;
    }

    public void print(Scanner sc, String cat1, String[] cat2) {
        int n = DescriptionUtils.getNumber(cat1);

        switch(cat2[0]) {
            case "add" :
                addData(sc, n);
                break;
            case "list" :
                getData(n);
                break;
            case "view" :
                if(cat2[1] == null)
                    System.out.println("찾을 데이터가 입력되지 않았습니다.");
                else
                    findData(cat2[1], n);
                break;
            case "update" :
                if(cat2[1] == null)
                    System.out.println("수정할 데이터가 입력되지 않았습니다.");
                else
                    setData(sc, cat2[1], n);
                break;
            case "del" :
                if(cat2[1] == null)
                    System.out.println("삭제할 데이터가 입력되지 않았습니다.");
                else
                    delData(sc, cat2[1], n);
                break;
            default :
                System.out.println("명령어가 올바르지 않습니다.");
        }
        System.out.println();
    }

    public void addData(Scanner sc, int n) { // add
        Description sub = DescriptionFactory.createDescription(n);

        if(sub != null) {
            sub.add(sc);
            if(!DescriptionUtils.isDuplicate(data, sub.getBase(), n))
                data.add(sub);
            else
                System.out.println("이미 등록된 데이터입니다.");
        } else 
            System.out.print("명령어가 올바르지 않습니다.");
    }

    public void setData(Scanner sc, String target, int n) { // update
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).getBase().equals(target)) {
                if(data.get(i).getNumber() == n) {
                    Description d = data.get(i).call_by_value(); 
                    d.update(sc);

                    if(DescriptionUtils.isDuplicate(data, d.getBase(), n))
                        System.out.println("이미 등록되어있어 수정할 수 없습니다.");
                    else {
                        data.set(i, d);
                        System.out.println("변경하였습니다.");
                    }
                    return;
                }
            }
        }
        System.out.println("데이터가 없습니다.");
    }

    public void getData(int n) { // list
        int cnt = 0;

        for(int i=0; i<data.size(); i++)
            cnt += data.get(i).get(n);
        if(cnt <= 0)
            System.out.println("데이터가 없습니다.");
    }

    public void findData(String target, int n) { // view    
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).getBase().equals(target)) {
                data.get(i).get(n);
                return;
            }
        }
        System.out.println( "데이터가 없습니다." );
    }

    public void delData(Scanner sc, String target, int n) { // delete
        for(int i=0; i<data.size(); i++) {
            if(data.get(i).getBase().equals(target)) {
                if(data.get(i).getNumber() == n) {
                    System.out.print("정말 삭제하시겠습니까? (Y/N) ");
                        if( sc.nextLine().equals("y") ) {
                            System.out.println(data.get(i).getBase() + " 데이터를 삭제했습니다.");
                            data.remove(i);
                    } else
                        System.out.println("삭제를 취소하셨습니다.");
                    return;
                }
            }
        }
        System.out.println( "데이터가 없습니다." );
    }
    
    public int indexOf() {
        
        return 1;
    }
}