package step22.ex6;

import java.io.ByteArrayInputStream;

public class ByteArrayDataInputStream extends ByteArrayInputStream {

    public ByteArrayDataInputStream(byte[] bytes) throws Exception {
        super(bytes);
    }
    
    public String readUTF() throws Exception {
        int cnt = this.read(); // 먼저 Length를 write했기때문에 Length를 먼저 뺀다.
        this.read(this.buf); // 그 뒤가 실제 데이터이므로 그 뒤부터 입력한다.
        
        return new String(this.buf, "UTF-8");
    }
    
    public int readInt() throws Exception {
        int value = 0;
        
        value = this.read() >> 24;
        value += this.read() >> 16;
        value += this.read() >> 8;
        value += this.read();
        
        return value;
    }
    
    public boolean readBoolean() throws Exception {
        if(this.read() == 1 )
            return true;
        else
            return false;
    }
}
