package step22.ex7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 버퍼 기능을 I/O 플러그인으로 전환

public class BufferedInputStream {
    
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
