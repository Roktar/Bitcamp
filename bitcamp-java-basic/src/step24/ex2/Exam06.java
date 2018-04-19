package step24.ex2;

// System 그룹의 자식 그룹들
public class Exam06 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        ThreadGroup group = t.getThreadGroup();
        ThreadGroup systemgroup = group.getParent();
        
        ThreadGroup[] groups = new ThreadGroup[100];
        int count = systemgroup.enumerate(groups, false);
        
        System.out.println("System 그룹의 자식 그룹들");
        for(int i=0; i< count; i++) {
            System.out.println("   => " + groups[i].getName());
        }
        
    }
}
