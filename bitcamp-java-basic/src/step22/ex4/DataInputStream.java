package step22.ex4;

import java.io.FileInputStream;

public class DataInputStream extends FileInputStream {

    public DataInputStream(String name) throws Exception {
        super(name);
    }
    
    public String readUTF() throws Exception {
        byte[] bytes = new byte[100];
        int cnt = this.read(); // 먼저 Length를 write했기때문에 Length를 먼저 뺀다.
        this.read(bytes, 0, cnt); // 그 뒤가 실제 데이터이므로 그 뒤부터 입력한다.
        
        return new String(bytes, 0, cnt, "UTF-8");
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
