package bitcamp.java106.pms.service;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Member;

public interface MemberService {
    int delete(String id);
    List<Member> list(int pageNo, int pageSize);
    int add(Member member);
    int update(Member member);
    Member get(String id);
    Member getWithPassword(Map<String,Object> params);
    boolean isExist(String id, String password);
}
