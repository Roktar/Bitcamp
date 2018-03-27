package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TaskController {
    
    Scanner keyScan;
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao, TaskDao taskDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    public void service(String menu, String option) {
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(option);
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", option);
            return;
        }
        
        if (menu.equals("task/add")) {
            this.onTaskAdd(team);
        } else if (menu.equals("task/list")) {
<<<<<<< HEAD
            this.onTaskList(team);
        } else if (menu.equals("task/view")) {
            this.onTaskView(team);
        } else if (menu.equals("task/update")) {
            this.onTaskUpdate(team);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(team);
        } else if (menu.equals("task/state")) {
            this.onTaskDelete(team);
        } else {
=======
            this.onTaskList(option);
        } else if (menu.equals("task/view")) {
            this.onTaskView(option);
        } else if (menu.equals("task/update")) {
            this.onTaskUpdate(option);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(option);
        } else if (menu.equals("task/state")) {
        	this.onTaskState(option);
    	} else {
>>>>>>> 59c3a57d4ce791fed9251a7d0bda32d19e0558c5
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    private void onTaskAdd(final Team team) {
        Task task = new Task(team);
        
        System.out.println("[팀 작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setStartDate(team.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() < team.getStartDate().getTime()) {
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        System.out.print("종료일? ");
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(team.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) {
                task.setEndDate(team.getEndDate());
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.print("작업자 아이디? ");
        String memberId = keyScan.nextLine();
        if (memberId.length() != 0) {
            Member member = team.getMember(memberId);
            if (member == null) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(member);
            }
        }
        
        taskDao.insert(task);
    }

    
    private void onTaskList(Team team) {
        System.out.println("[팀 작업 목록]");
        
        Task[] tasks = taskDao.list(team.getName());
        
        for (Task task : tasks) {
            System.out.printf("%d,%s,%s,%s,%s\n", 
                    task.getNo(), task.getTitle(), 
                    task.getStartDate(), task.getEndDate(),
                    (task.getWorker() == null) ? 
                            "-" : task.getWorker().getId());
        }
        System.out.println();
    }
    
    void onTaskView(Team team) {

        System.out.println("[작업 정보]");
        System.out.print("작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(team.getName(), taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.printf("작업명: %s\n", task.getTitle());
        System.out.printf("시작일: %s\n", task.getStartDate());
        System.out.printf("종료일: %s\n", task.getEndDate());
        System.out.printf("작업자: %s\n", 
                (task.getWorker() == null) ? "-" : task.getWorker().getId());
    }
    
    private void onTaskUpdate(Team team) {        
        System.out.println("[팀 작업 변경]");
        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task originTask = taskDao.get(team.getName(), taskNo);
        if (originTask == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
<<<<<<< HEAD
        Task task = new Task(team);
        task.setNo(originTask.getNo());
=======
        System.out.print("작업명? ");
        task.setTeamName(teamName);
        task.setTaskName(keyScan.nextLine());
        task.setStartDate( inputDate("시작일? ", teamName, 1) );
        task.setEndDate( inputDate("종료일? ", teamName, 2) );
        System.out.print("작업자? ");
        
        String id = keyScan.nextLine();
        Member member = memberDao.get(id);
>>>>>>> 59c3a57d4ce791fed9251a7d0bda32d19e0558c5
        
        System.out.printf("작업명(%s)? ", originTask.getTitle());
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setTitle(originTask.getTitle());
        } else {
            task.setTitle(str);
        }
<<<<<<< HEAD
        
        System.out.printf("시작일(%s)? ", originTask.getStartDate());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setStartDate(originTask.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() < team.getStartDate().getTime()) {
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        System.out.printf("종료일(%s)? ", originTask.getEndDate());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(originTask.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) {
                task.setEndDate(team.getEndDate());
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.printf("작업자 아이디(%s)? ", 
                (originTask.getWorker() == null) ? 
                        "-" : originTask.getWorker().getId());
        String memberId = keyScan.nextLine();
        if (memberId.length() == 0) {
            task.setWorker(originTask.getWorker());
        } else {
            Member member = team.getMember(memberId);
            if (member == null) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
                task.setWorker(member);
            }
        }
=======
        task.setWorkerName(id);
        task.setState(0);
        
        taskDao.insert(task);
        System.out.println("작업을 등록했습니다.");
    }
    
    public void onTaskList(String teamName) {
    	if(teamName == null) {
    		System.out.println("팀 이름이 입력되지 않았습니다.");
    		return;
    	}
    	
        Task[] tasks = taskDao.list();
>>>>>>> 59c3a57d4ce791fed9251a7d0bda32d19e0558c5
        
        if (Console.confirm("변경하시겠습니까?")) {
            taskDao.update(task);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }

    
<<<<<<< HEAD
    private void onTaskDelete(Team team) {
        System.out.println("[팀 작업 변경]");
        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
=======
    void onTaskView(String name) {
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
        }
        
        System.out.print("작업번호? ");
        int taskNo = keyScan.nextInt();
        keyScan.nextLine();
        
        Task task = taskDao.get(taskNo);

        if (task == null) {
            System.out.println("해당 작업이 없습니다.");
        } else {
            System.out.printf("작업명: %s\n", task.getTaskName());
            System.out.printf("시작일: %s\n", task.getStartDate());
            System.out.printf("종료일: %s\n", task.getEndDate());
            System.out.printf("작업자: %s\n", task.getWorkerName());
        }
    }
    
    void onTaskUpdate(String teamName) {
        if (teamName == null) {
            System.out.println("팀 이름이 입력되지 않았습니다.");
            return;
        }
        Team team = teamDao.get(teamName);
        
        if(team == null) {
        	System.out.println("팀이 존재하지 않습니다.");
        	return;
        }
        
        System.out.print("변경할 작업 번호? ");
        int taskNo = keyScan.nextInt();
        keyScan.nextLine();
        
        Task task = taskDao.get(taskNo);

        if (task == null) {
            System.out.println("해당 작업이 없습니다.");
        } else {
            Task updateTask = new Task();
            
            updateTask.setTeamName(task.getTeamName());
            System.out.printf("작업명(%s)? ", task.getTaskName());
            updateTask.setTaskName(this.keyScan.nextLine());
            System.out.printf("시작일(%s)? ", task.getStartDate());
            updateTask.setStartDate( inputDate("", task.getTeamName(), 1));
            System.out.printf("종료일(%s)? ", task.getEndDate());
            updateTask.setEndDate(inputDate("", task.getTeamName(), 2));
            System.out.printf("작업자(%s)? ", task.getWorkerName());
            
            String id = keyScan.nextLine();
            Member member;
            
            if(id == null)
            	updateTask.setWorkerName(task.getWorkerName());
            else {
            	member = memberDao.get(id);
            
	            if(member == null) {
	            	System.out.println("등록되지 않은 작업자입니다.");
	            	return;
	            }
	            updateTask.setWorkerName(member.getId());
            }
            
            System.out.print("변경하시겠습니까(y/N)? ");
            if(keyScan.nextLine().toLowerCase().equals("y")) {
                taskDao.update(updateTask);
                System.out.println("변경하였습니다.");
            } else
            	System.out.println("취소하였습니다.");
        }
    }
    
    void onTaskDelete(String teamName) {
    	if(teamName == null) {
    		System.out.println("팀 이름이 입력되지 않았습니다.");
    		return;
    	}
    	
        Team team = teamDao.get(teamName);
        
        if(team == null) {
        	System.out.println("팀이 존재하지 않습니다.");
        	return;
        }
        
        System.out.printf("삭제할 작업 번호? ");
        int taskNo = keyScan.nextInt();
        keyScan.nextLine();
        Task task = taskDao.get(taskNo);
        
        if (task == null) {
            System.out.println("없는 작업번호입니다.");
            return;
        }
        System.out.print("정말 삭제하시겠습니까(y/N)? ");
        if(keyScan.nextLine().toLowerCase().equals("y")) {
        	taskDao.delete(taskNo);
        	System.out.println("삭제하였습니다.");
        }
    }
    
    void onTaskState(String teamName) {
        if (teamName == null) {
            System.out.println("팀 이름이 입력되지 않았습니다.");
            return;
        }
        Team team = teamDao.get(teamName);
        
        if(team == null) {
        	System.out.println("팀이 존재하지 않습니다.");
        	return;
        }
        
        System.out.print("상태를 변경할 작업의 번호? ");
        int taskNo = keyScan.nextInt();
        keyScan.nextLine();
        
        Task task = taskDao.get(taskNo);

        if (task == null) {
            System.out.println("해당 작업이 없습니다.");
        } else {
            System.out.printf("'%s' 작업의 상태 : ", task.getTaskName());
            
            printState(task.getState());
           
            System.out.print("\n변경할 상태(0:작업대기, 1:작업중, 9:작업완료)? ");
            int state = keyScan.nextInt();
            keyScan.nextLine();
            
            if(state == 0 || state == 1 || state == 9) {
            	task.setState(state);
            	System.out.print("작업의 상태를 '");
            	printState(state);
            	System.out.println("'(으)로 변경하였습니다.");
            } else
            	System.out.println("올바르지않은 값입니다. 이전 상태를 유지합니다.");
        }
    }
    
    public void printState(int state) {
        switch(state) {
	    	case 0 : 
	    		System.out.print("작업대기");
	    		break;
	    	case 1 : 
	    		System.out.print("작업중");
	    		break;
	    	case 9 : 
	    		System.out.print("작업완료");
	    		break;
        }
    }
    
    public Date inputDate(String category, String teamName, int type) {
        String date;
        Date retVal;
        Team team = teamDao.get(teamName);
>>>>>>> 59c3a57d4ce791fed9251a7d0bda32d19e0558c5
        
        Task task = taskDao.get(team.getName(), taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getMembers(), taskNo);
            return;
        }
        
        if (Console.confirm("삭제하시겠습니까?")) {
            taskDao.delete(task);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }
}

//ver 17 - 클래스 생성