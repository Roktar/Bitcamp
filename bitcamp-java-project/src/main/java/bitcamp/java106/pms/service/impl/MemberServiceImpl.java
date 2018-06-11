package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
    MemberDao memberDao;
    
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @Override
    public int delete(String id) {
        return memberDao.delete(id);
    }

    @Override
    public List<Member> list(int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo -1) * pageSize);
        params.put("pageSize", pageSize);
        
        return memberDao.selectList(params);
    }

    @Override
    public int add(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public int update(Member member) {
        return memberDao.update(member);
    }

    @Override
    public Member get(String id) {
        return memberDao.selectOne(id);
    }

    @Override
    public Member getWithPassword(Map<String, Object> params) {
        // TODO Auto-generated method stub
        return memberDao.selectOneWithPassword(params);
    }

    @Override
    public boolean isExist(String id, String password) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("password", password);
        
        return memberDao.count(params) > 0 ? true : false;
    }
}
