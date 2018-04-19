package step24.ex2;

// 하위 그룹의 부모 그룹 확인
public class Exam05 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        ThreadGroup group = t.getThreadGroup();
        
        // 하위 그룹의 부모 그룹을 알고싶을 때는 다음과 같이 사용한다.
        ThreadGroup parent = group.getParent();
        System.out.println(parent.getName());
        
        ThreadGroup grandparent = parent.getParent();
        if(grandparent != null)
            System.out.println(grandparent.getName());
    }
}
