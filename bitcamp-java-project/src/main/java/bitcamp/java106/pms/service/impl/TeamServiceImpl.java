package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    TaskDao taskDao;
    public TeamServiceImpl(TeamDao teamDao, TeamMemberDao teamMemberDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.teamMemberDao = teamMemberDao;
        this.taskDao = taskDao;
    }

    @Transactional
    @Override
    public int delete(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("teamName", name);
        
        teamMemberDao.delete(params);
        taskDao.deleteByTeam(name);
        
        return teamDao.delete(name);
    }

    @Override
    public List<Team> list(int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo -1) * pageSize);
        params.put("pageSize", pageSize);
        
        return teamDao.selectList(params);
    }

    @Override
    public int add(Team team) {
        return teamDao.insert(team);
    }

    @Override
    public int update(Team team) {
        return teamDao.update(team);
    }

    @Override
    public Team get(String name) {
        return teamDao.selectOne(name);
    }

    @Override
    public Team getWithMembers(String name) {
        // TODO Auto-generated method stub
        return teamDao.selectOneWithMembers(name);
    }

    @Override
    public boolean isMember(String teamName, String memberId) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", teamName);
        params.put("memberId", memberId);
        
        return teamMemberDao.isExist(params);
    }

    @Override
    public int addMember(String teamName, String memberId) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", teamName);
        params.put("memberId", memberId);
        
        return teamMemberDao.insert(params);
    }

    @Override
    public int deleteMember(String teamName, String memberId) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("teamName", teamName);
        params.put("memberId", memberId);
        
        return teamMemberDao.delete(params);
    }

    @Override
    public List<Member> getMembers(String teamName) {
        return teamMemberDao.selectListWithEmailNoPage(teamName);
    }
}
