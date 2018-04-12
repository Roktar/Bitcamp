package step22.ex8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// InputStream에 붙이는 플로그인을 다른 플러그인에 붙이려면,
// 플러그인 클래스도 InputStream을 지원해야한다.

// InputStream을 상속받아 InputStream 타입도 지원하도록 한다.
// 단, 상속받은 기능은 사용하려는 목적이 아니라 받아들일 수 있게하기위함이다.
public class BufferedInputStream extends InputStream {
    
    InputStream in;
    
    byte[] buf = new byte[8196];
    int size;
    int cursor;
    
    public BufferedInputStream(InputStream in) throws FileNotFoundException {
        this.in = in;
    }
    
    public int read() throws IOException {
        if ( cursor == size ) {
            
            if( (size = in.read(buf)) == -1)
                return -1; 
            
            cursor = 0; 
        }
        return 0x000000ff & buf[cursor++];
    }
    
    public void close() throws IOException {
        in.close();
    }
}
