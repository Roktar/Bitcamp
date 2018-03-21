package bitcamp.java106.pms.dao;
import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;
    int currentIndex = -1;
    
    public void insert(Member member) {
        this.members[this.memberIndex++] = member;
    }
    
    public Member[] list() {
        Member[] arr = new Member[memberIndex];
        for (int i = 0; i < memberIndex; i++) 
            arr[i] = members[i];
        return arr;
    }
    
    public Member get(String id) {
        for(int i=0; i<members.length; i++) {
            if(members[i].id.equals(id.toLowerCase())) {
                currentIndex = i;
                return members[i];
            }
        }
        return null;
    }
    
/*    public int get(String id) {
        for(int i=0; i<members.length; i++) {
            if(members[i].id.equals(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }*/
    
    public void update(Member member) {
        members[currentIndex] = member;
        currentIndex = -1;
    }
    
    public void delete() {
        members[currentIndex] = null;
        currentIndex = -1;
    }
}
