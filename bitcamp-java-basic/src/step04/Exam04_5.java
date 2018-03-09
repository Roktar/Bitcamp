package step04;

public class Exam04_5 {
    public static void main(String[] args) {

        // 비트연산자 사용 전
        // - 각각의 상태를 별도의 변수에 저장해야한다. = > 총 32바이트를 사용.
        boolean c, cpp, java, js, python, php, html, css;
        c = true;
        cpp = false;
        java = true;
        js = false;
        python = true;
        php = false;
        html = true;
        css = false;

        // 배열 사용 가능.
        // - 배열을 JVM에서 다룰 때는 각 boolean에 대해 1바이트를 사용한다.
        // => 총 8바이트 사용
        boolean[] lang = new boolean[8];
        lang[0] = true;
        lang[1] = false;
        lang[2] = true;
        lang[3] = false;
        lang[4] = true;
        lang[5] = false;
        lang[6] = true;
        lang[7] = false;

        // 비트연산자 사용 후
        // - 4바이트 변수 1개만 있으면 최대 32개의 데이터를 저장할 수 있다.
        // true인 것만 확인해서 체크, false는 0x00 고정값.
        int lang2 = 0;
        lang2 = 0x80; // c= true, 0000 0000 | 1000 0000 => 1000_0000
        //lang2 |= 0x00; // c++ = false
        lang2 = 0x20; // java = true, 1000 0000 | 0010 0000 => 1010_0000
        //lang2 |= 0x00;
        lang2 |= 0x08; // python = true, 1010 0000 | 0000 1000 => 1010_1000
        //lang2 |= 0x00; // php = false;
        lang2 |= 0x04; // html = true, 1010 1000 | 0000 0001 => 1010_1001
        //lang2 |= 0x00; // css = false;

        // 비트를 이용하여 각 데이터의 true/false를 표현한다.
    }
}