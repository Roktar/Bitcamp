package step08;



public class Exam01_4 {
    
    static class Student {
        // ㅁ모든 인스턴스가 공유하는 값을 저장할 때는 클래스 변수 사용
        static int count;
        
        // 인스턴스마다 개별적으로 관리하는 값은 인스턴스 변수를 사용
        String name;
        int age;
    }

    public static void main(String[] args) {
        Student.count = 0;
        
        Student s1 = new Student();
        s1.name="길동홍";
        s1.age=20;
        Student.count++;
        
        Student s2 = new Student();
        s2.name="꺽정임";
        s2.age=20;
        Student.count++;        
        
        Student s3 = new Student();
        s3.name="유관순";
        s3.age=30;
        Student.count++;
        
        System.out.printf("%d %s %d\n", Student.count, s1.name, s1.age);
        System.out.printf("%d %s %d\n", Student.count, s2.name, s2.age);
        System.out.printf("%d %s %d", Student.count, s3.name, s3.age);
        
        
        
    }
}
