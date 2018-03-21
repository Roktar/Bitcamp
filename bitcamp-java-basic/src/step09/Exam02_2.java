package step09;
// wrapper class
public class Exam02_2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(200);
        Integer i3 = new Integer(300);
        // 인스턴스 메소드 사용
        // 같으면 0, 다르면 1을 반환. 값을 비교한다.
        System.out.println(i2.compareTo(i1));
        System.out.println(i2.compareTo(i3));
        
        // 스태틱 메소드 사용
        int v2 = Integer.parseInt("1280");
        String s1 = Integer.toBinaryString(77);
        String s2 = Integer.toOctalString(77);
        String s3 = Integer.toHexString(77);
        System.out.printf("%d: %s %s %s\n", 77, s1, s2, s3);
        
        // 문자열에 저장되는 수는 기본적으로 10진수로 간주하고
        // 우측에 진법을 입력하면 그 진법에 맞게 변환되어 저장된다.
        Integer x1 = Integer.valueOf("44");
        Integer x2 = Integer.valueOf("44", 16);
        System.out.printf("%d %d\n", x1, x2);
        
        float f = Float.parseFloat("3.14f");
        boolean b = Boolean.parseBoolean("true");
        System.out.printf("%.4f %b", f, b);
    }

}
