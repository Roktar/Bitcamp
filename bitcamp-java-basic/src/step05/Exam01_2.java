package step05;

class Exam01_2 {
    public static void main(String[] args) {
        //int age = 20;
        int age = 17;
     
        if(age >= 19)
            System.out.println("성인이다"); // 범위지정 안하면 여기까지가 if문의 범위.
            System.out.println("군대 가야한다");
            System.out.println("일해야 한다");
            System.out.println("세금 납부해야 한다.");

        if(age >= 19) {
            System.out.println("성인이다"); 
            System.out.println("군대 가야한다");
            System.out.println("일해야 한다");
            System.out.println("세금 납부해야 한다.");
        }
    }
}