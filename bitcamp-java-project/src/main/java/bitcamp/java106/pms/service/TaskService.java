package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Task;

public interface TaskService {
    int delete(int no);
    int deleteByTeam(String teamName);
    List<Task> list(String teamName, int pageNo, int pageSize);
    int add(Task task);
    int update(Task task);
    Task get(int no);
    int updateState(int no, int state);
}
