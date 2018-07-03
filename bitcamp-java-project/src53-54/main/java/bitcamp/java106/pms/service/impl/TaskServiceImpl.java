package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.service.TaskService;

@Service 
public class TaskServiceImpl implements TaskService {

    TaskDao taskDao;
    
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    
    @Override
    public int delete(int no) {
        return taskDao.delete(no);
    }

    @Override
    public int deleteByTeam(String teamName) {
        return taskDao.deleteByTeam(teamName);
    }

    @Override
    public List<Task> list(String teamName, int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("teamName", teamName);
        params.put("startRowNo", (pageNo -1) * pageSize);
        params.put("pageSize", pageSize);
        
        return taskDao.selectList(params);
    }

    @Override
    public int add(Task task) {
        return taskDao.insert(task);
    }

    @Override
    public int update(Task task) {
        return taskDao.update(task);
    }

    @Override
    public Task get(int no) {
        return taskDao.selectOne(no);
    }

    @Override
    public int updateState(int state, int no) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("no", no);
        params.put("state", state);
        // TODO Auto-generated method stub
        return taskDao.updateState(params);
    }
}
