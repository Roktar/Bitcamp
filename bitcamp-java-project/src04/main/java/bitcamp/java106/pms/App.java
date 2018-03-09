package bitcamp.java106.pms;

import java.util.Scanner;
import bitcamp.java106.pms.Management;

public class App {
    public static void main(String[] args) {
        String[][] question = { {"팀명? ", "설명? ", "최대인원? ", "시작일? ", "종료일? " }, {"아이디? ", "이메일? ", "암호? "}};
        Scanner sc = new Scanner(System.in);
        Management manage = new Management();
        
        String command = "";

        while( !command.equals("quit") ) {
            System.out.print("명령> ");
            command = sc.nextLine();
            String[] sub;

            if(command.toLowerCase().equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit\n");
                continue;
            } else if(command.indexOf("/") > -1 && command.split("/").length > 0)
                sub = command.split("/");
            else
                continue;

            String[] sub2;

            if(sub[1].indexOf(" ") > -1) // view가 해당
                sub2 = sub[1].split(" ");
            else {
                sub2 = new String[2];
                sub2[0] = sub[1];
            } // add, list가 해당

            if(sub[0].equals("team") || sub[0].equals("member")) {
                switch(sub2[0]) {
                    case "add" :
                        if(sub[0].equals("team"))
                            manage.addData(sc, question[0], true );
                        else
                            manage.addData(sc, question[1], false );
                        break;
                    case "list" :
                        manage.getData();
                        break;
                    case "view" :
                        if(sub[1] == null || sub[1].equals("view"))
                            System.out.println("찾을 팀명 혹은 아이디가 입력되지 않았습니다.");
                        else
                            manage.findData(sub2[1]);
                        break;
                    default :
                        System.out.println("명령어가 올바르지 않습니다.\n");
                }
            } else if(sub[0].equals("quit"))
                break;
            else
                System.out.println("명령어가 올바르지 않습니다.\n");

            // switch(sub[0]) {
            //     case "team" :
            //         switch(sub[1]) {
            //             case "add" :
            //                 manage.addTeam(sc, question[0]);
            //                 break;
            //             case "list" :
            //                 manage.getTeam();
            //                 break;
            //             default :
            //                 String sub2[] = sub[1].split(" ");
            //                 manage.findTeam(sub2[1]);
            //                 break;
            //         }
            //         break;
            //     case "member" : 
            //         switch(sub[1]) {
            //             case "add" :
            //                 manage.addMember(sc, question[1]);
            //                 break;
            //             case "list" :
            //                 manage.getMember();
            //                 break;
            //             default :
            //                 String sub2[] = sub[1].split(" ");
            //                 manage.findMember(sub2[1]);
            //                 break;
            //         }
            //         break;
            //     case "quit" :
            //         break;
            //     default :
            //         System.out.println("명령어가 올바르지 않습니다.\n");
            // }
        }
        System.out.println("안녕히가세요!");
    }
}