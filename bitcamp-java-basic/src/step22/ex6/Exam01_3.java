package step22.ex6;

// 데이터를 멤버 객체에 저장
public class Exam01_3 {
    public static void main(String[] args) throws Exception {
        byte[] buf = { 0x0b, 0x41, 0x42, 
                      (byte) 0xea, (byte) 0xb0, (byte) 0x80, 
                      (byte) 0xea, (byte) 0xb0, (byte) 0x81, 
                      (byte) 0xea, (byte) 0xb0, (byte) 0x84, 
                      0x00, 0x00, 0x00, 0x1b, 0x01 };
        
        // 바이트 배열에서 데이터를 읽는 도구
        ByteArrayDataInputStream in = new ByteArrayDataInputStream(buf);
        
        int b;
        
        Member member = new Member();
        
        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        // ByteArrayData와 Data클래스는 생성자만 제외하고는 같은 소스를 가지고있다.
        // 하지만 코드 복사를 제외한 다른 방법으로는 재사용할 수 있는 방법이 없다.
        // 이것이 상속의 한계점이다.
        // 여기서 해결책으로는 새로운 클래스를 만들었다.
        // 하지만 다른 해결책으로 "데코레이터" 패턴을 통해 해결할 수 있다.
        // 
        
        System.out.println(member);
        
        in.close();
    }
}
