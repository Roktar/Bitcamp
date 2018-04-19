package step24.ex2;

// System 그룹에 소속된 스레드들 확인
public class Exam07 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        ThreadGroup group = t.getThreadGroup();
        ThreadGroup systemgroup = group.getParent();
        
        Thread[] arr = new Thread[100];
        int count = systemgroup.enumerate(arr, false);
        
        System.out.println("System 그룹에 소속된 스레드들");
        for(int i=0; i< count; i++) {
            System.out.println("   => " + arr[i].getName());
        }
        
    }
}
