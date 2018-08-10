package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.service.TaskService;
import bitcamp.java106.pms.service.TeamService;

@Component
@RequestMapping("team/{teamName}/task")
public class TaskController {
    
    TeamService teamService;
    TaskService taskService;

    public TaskController(TeamService teamService,
            TaskService taskService) {
        this.teamService = teamService;
        this.taskService = taskService;
    }
    
    @RequestMapping("add")
    public String add(
            Task task,
            @PathVariable String teamName,
            String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        if (teamService.get(task.getTeam().getName()) == null)
            throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.");
        
        if (task.getWorker().getId().length() > 0 &&
            !teamService.isMember(teamName, memberId)) {
            throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.");
        }
        
        taskService.add(task);
        return "redirect:list";
    }
    
    @RequestMapping("delete")
    public String delete(@RequestParam("no") int no, @PathVariable String teamName) throws Exception {
        if (taskService.delete(no) == 0) 
            throw new Exception("해당 작업이 존재하지 않습니다.");
        return "redirect:list";
    }
    
    @RequestMapping("form")
    public String form(
            @PathVariable String teamName,
            Map<String,Object> map) throws Exception {
        
        if (teamService.get(teamName) == null)
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        
        map.put("members", teamService.getMembers(teamName));
        map.put("teamName", teamName);
        return "task/form";
    }
    
    @RequestMapping("list{page}")
    public String list(@PathVariable String teamName, @MatrixVariable(defaultValue="1") int pageNo, 
                       @MatrixVariable(defaultValue="3") int pageSize, Map<String,Object> map) throws Exception {
        if (teamService.get(teamName) == null)
            throw new Exception(teamName + " 팀은 존재하지 않습니다.");
        
        map.put("list", taskService.list(teamName, pageNo, pageSize));
        map.put("teamName", teamName);
        
        return "task/list";
    }
    
    @RequestMapping("update")
    public String update(
            Task task,
            @PathVariable String teamName,
            @RequestParam("memberId") String memberId) throws Exception {
        
        task.setTeam(new Team().setName(teamName));
        task.setWorker(new Member().setId(memberId));
        
        if (taskService.update(task) == 0) 
            throw new Exception("<p>해당 작업이 없습니다.</p>");
        
        return "redirect:list";
    }
    
    @RequestMapping("{no}")
    public String view(@PathVariable int no, String teamName, Map<String,Object> map) throws Exception {
        Task task = taskService.get(no);
        if (task == null)
            throw new Exception("해당 작업을 찾을 수 없습니다.");
        
        List<Member> members = teamService.getMembers(task.getTeam().getName());
        
        map.put("task", task);
        map.put("members", members);
        map.put("teamName", teamName);
        
        return "task/view";
    }
}
