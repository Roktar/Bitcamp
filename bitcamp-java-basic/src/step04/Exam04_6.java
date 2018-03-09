package step04;

public class Exam04_6 {
    public static void main(String[] args) {

        // 다음 변수의 값을 조사하여 개발자가 
        // 어떤 프로그래밍 언어를 사용할 수 있는 지 출력하라.
        // 각 비트에 해당하는 프로그래밍 언어는 다음 순서를 따른다.
        // c, cpp, java, js, python, php, html, css;

        int lang = 0b1110_0011;

        if( (lang & 0b1000_0000) == 0x80 )
            System.out.print("c ");
        if( (lang & 0b0100_0000) == 0x40 )
            System.out.print("cpp ");
        if( (lang & 0b0010_0000) == 0x20 )
            System.out.print("java ");
        if( (lang & 0b0001_0000) == 0x10 )
            System.out.print("js ");
        if( (lang & 0b0000_1000) == 8)
            System.out.print("python ");
        if( (lang & 0b0000_0100) == 4 )
            System.out.print("php ");
        if( (lang & 0b0000_0010) == 2 )
            System.out.print("html ");
        if( (lang & 0b0000_0001) == 1 )
            System.out.print("css ");
        // 찾고싶은 값만 1로 세팅하고 나머지는 0으로 세팅하도록 한다.

    }
}