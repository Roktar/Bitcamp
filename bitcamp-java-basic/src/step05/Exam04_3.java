package step05;

public class Exam04_3 {
    public static void main(String[] args) {
        String[] names = {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};
        
        String[] names2 = new String[5];
        names2[0] = "홍길동";
        names2[1] = "임꺽정";
        names2[2] = "유관순";
        names2[3] = "윤봉길";
        names2[4] = "안중근";

        String[] names3 = new String[] {"홍길동", "임꺽정", "유관순", "윤봉길", "안중근"};

        for (int i=0; i< names.length; i++)
            System.out.println(names[i]);
        System.out.println("-------------------------------");

        for(String name : names) 
            System.out.println(name); //for-each

        // String c; 
        // for(c : names)
        //     System.out.println(c); // 컴파일 오류, 외부에 선언한 변수를 쓸 수 없음
        
    }
}