package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.Management;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management manage = new Management();
        
        String command = "";
        String[] sub, sub2;
        String[][] question = { {"팀명? ", "설명? ", "최대인원? ", "시작일? ", "종료일? " }, {"아이디? ", "이메일? ", "암호? "}};
        boolean type = false;

        sub2 = new String[2];

        while( !command.equals("quit") ) {
            System.out.print("명령> ");
            command = sc.nextLine();
            sub = command.split("/");

            if(command.toLowerCase().equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit\n");
                continue;
            } else if( (!sub[0].toLowerCase().equals("team") && !sub[0].toLowerCase().equals("member")) || getCount(command, '/') > 2 || sub.length < 2) {
                System.out.println("명령어가 올바르지 않습니다.\n");
                continue;
            }

            if( getCount(sub[1], ' ') < 2 && sub[1].indexOf(" ") > -1) // view가 해당
                sub2 = sub[1].split(" ");
            else
                sub2[0] = sub[1]; // add, list가 해당

            type = ( sub[0].toLowerCase().equals("team") ? true : false);
            switch(sub2[0].toLowerCase()) {
                case "add" :
                    manage.addData(sc, question[ (type ? 0 : 1) ], type);
                    break;
                case "list" :
                    manage.getData( (type ? 0 : 1) );
                    break;
                case "view" :
                    if(sub[1] == null || sub[1].toLowerCase().equals("view"))
                        System.out.println("찾을 팀명 혹은 아이디가 입력되지 않았습니다.\n");
                    else
                        manage.findData(sub2[1], (type ? 0 : 1) );
                    break;
                default :
                    System.out.println("명령어가 올바르지 않습니다.\n");
            }
        }
        System.out.println("안녕히가세요!");
    }

    public static int getCount(String str, char search) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == search)
                count++;
        }
        return count;
    }
}