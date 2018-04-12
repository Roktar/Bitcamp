package step22.ex5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {

    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(String name) throws FileNotFoundException {
        super(name);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void write(int b) throws IOException {
        // 버퍼에 데이터가 다 채워지면, 버퍼에 있는 데이터를 한 번에 전부 출력
        if(cursor == buf.length) {
            this.write(buf);
            cursor = 0;
        }
        
        // 1바이트 출력을 요구하면 버퍼에 저장, 버퍼를 채운다.
        buf[cursor++] = (byte)b;
        // 버퍼가 아직 다 안채워졌기때문에 버퍼를 우선적으로 채운다.
    }
    
    @Override
    public void close() throws IOException {
        if( cursor > 0 )
            this.write(buf);
        super.close();
    }
    
    @Override
    public void flush() throws IOException {
        if( cursor > 0 ) {
            this.write(buf);
            cursor = 0;
        }
    } // 커서의 내용을 강제로 비운다. (도중에 개발자 임의대로 비우기)
}
