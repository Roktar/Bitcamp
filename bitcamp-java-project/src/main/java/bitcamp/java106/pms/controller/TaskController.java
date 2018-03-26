package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

public class TaskController {
    TaskDao taskDao;
    MemberDao memberDao;
    TeamDao teamDao;
    Scanner keyScan;
    
    public TaskController(Scanner keyScan, MemberDao memberDao, TeamDao teamDao) {
        this.taskDao = new TaskDao();
        this.keyScan = keyScan;
        this.memberDao = memberDao;
        this.teamDao = teamDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            this.onTaskList(option);
/*        } else if (menu.equals("task/view")) {
            this.onTeamView(option);
        } else if (menu.equals("task/update")) {
            this.onTeamUpdate(option);
        } else if (menu.equals("task/delete")) {
            this.onTeamDelete(option);*/
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    
    public void onTaskAdd(String teamName) {
        Task task = new Task();
        
        if(teamName == null) {
            System.out.println("팀 이름을 입력하십시오.");
            return;
        }
        
        Team team = teamDao.get(teamName);
        
        if(team == null) {
            System.out.println("해당 팀이 없습니다.");
            return;
        }
        
        System.out.print("작업명? ");
        task.setTaskName(keyScan.nextLine());
        task.setStartDate( inputDate("시작일? ", teamName, 1) );
        task.setEndDate( inputDate("종료일? ", teamName, 2) );
        System.out.print("작업자? ");
        
        String id = keyScan.nextLine();
        Member member = memberDao.get(id);
        
        if(member == null) {
            System.out.println("해당 회원이 없습니다.");
            return;
        }
        
        task.setWorkerName(id);
        
        taskDao.insert(task);
    }
    
    public void onTaskList(String teamName) {
        Task[] tasks = taskDao.list();
        
        for(int i=0; i<tasks.length; i++) {
            if(tasks[i].getTeamName().toLowerCase().equals(teamName.toLowerCase())) 
                System.out.printf("%d, %s, %s, %s, %s", tasks[i].getTaskNo(), tasks[i].getTaskName(), tasks[i].getStartDate(),
                                                        tasks[i].getEndDate(), tasks[i].getWorkerName());
        }
    }
    
    public Date inputDate(String category, String teamName, int type) {
        String date;
        Date retVal;
        Team team = teamDao.get(teamName);
        
        System.out.print(category);
        date = keyScan.nextLine();
        
        try {
            retVal = Date.valueOf(date);

            if(type == 1) {
                if(team.getStartDate().compareTo(retVal) < 0)
                    return retVal;
                else
                    return team.getStartDate();
            } else {
                if(team.getEndDate().compareTo(retVal) > 0)
                    return team.getEndDate();
                else
                    return retVal;
            }
        } catch(Exception e) {
            if(type == 1)
                return team.getStartDate();
            else
                return team.getEndDate();
        }
    }
}
