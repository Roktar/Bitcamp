package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Member;

@Component
public class MemberDao extends AbstractDAO<Member>{
    
    public int getIndex(Object key) {
        String id = (String) key;
        for(int i=0; i<data.size(); i++) {    
            if( data.get(i).getId().equalsIgnoreCase(id) )
                return i;
        }
        return -1;
    }
}

//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - MemberController로부터 데이터 관리 기능을 분리하여 MemberDao 생성.