package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public interface TeamService {
    int delete(String name);
    List<Team> list(int pageNo, int pageSize);
    int add(Team team);
    int update(Team team);
    Team get(String name);
    Team getWithMembers(String name);
    
    // TeamMember 기능
    boolean isMember(String teamName, String memberId);
    int addMember(String teamName, String memberId);
    int deleteMember(String teamName, String memberId);
    List<Member> getMembers(String teamName);
}
