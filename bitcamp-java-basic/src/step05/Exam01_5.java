package step05;

class Exam01_5 {
    public static void main(String[] args) {
        int age = 15;

        if(age >= 19)
            if(age > 70)
                System.out.println("지하철 무임승차 대상");
        else
            System.out.println("미성년");

        if(age >= 19)
            if(age > 70)
                System.out.println("지하철 무임승차 대상");
            else
                System.out.println("미성년");

        if(age >= 19) {
            if(age > 70)
              System.out.println("지하철 무임승차 대상");
        } else
            System.out.println("미성년");
    }
}