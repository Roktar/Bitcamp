package bitcamp.java106.pms;

import java.util.Scanner;

import bitcamp.java106.pms.controller.BoardController;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TaskController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.TeamMemberController;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.util.Console;

public class App {
    static Scanner keyScan = new Scanner(System.in);
    public static String option = null; 
   
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }
    // 컨트롤러들은 DAO를 공유할 수 있다. 그리고 그렇게 만들기위해서는 DAO를 별도로 생성한 후 같은 DAO의 주소를 각각 넘겨준다.
    public static void main(String[] args) {
        TeamDao teamDao = new TeamDao();
        MemberDao memberDao = new MemberDao();
        TeamController teamController = new TeamController(keyScan, teamDao);
        MemberController memberController = new MemberController(keyScan, memberDao);
        BoardController boardController = new BoardController(keyScan);
        TaskController taskController = new TaskController(keyScan, memberDao, teamDao);
        TeamMemberController teamMemberController = new TeamMemberController(keyScan, teamDao, memberDao);

        Console.keyScan = keyScan;
        
        while (true) {
            String[] arr = Console.prompt();

            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if(menu.startsWith("team/member/")) {
                teamMemberController.service(menu, option);
            } else if (menu.startsWith("team/")) {
                teamController.service(menu, option);
            } else if (menu.startsWith("member/")) {
                memberController.service(menu, option);
            } else if (menu.startsWith("board/")) {
                boardController.service(menu, option);
            } else if (menu.startsWith("task/")) {
                taskController.service(menu, option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }

            System.out.println(); 
        }
    }
}