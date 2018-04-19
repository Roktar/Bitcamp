package step24.ex2;

// 쓰레드 그룹에 소속된 하위 그룹
public class Exam04 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        ThreadGroup group = t.getThreadGroup();
        
        // 쓰레드 그룹에 소속된 쓰레드 목록을 알고싶을 때는 다음과 같이 사용한다.
        ThreadGroup[] arr = new ThreadGroup[100];
        int count = group.enumerate(arr, false);
        
        System.out.println("-- main 그룹에 소속된 하위 그룹들");
        for(int i=0; i<count; i++)
            System.out.println("> " + arr[i].getName());
        
        
    }
}
