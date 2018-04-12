package step22.ex8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {

    OutputStream out;
    
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(OutputStream out) {
        this.out = out;
        // TODO Auto-generated constructor stub
    }
    
    public void write(int b) throws IOException {
        if(cursor == buf.length) {
            out.write(buf);
            cursor = 0;
        }
        buf[cursor++] = (byte)b;
    }
    
    public void close() throws IOException {
        if( cursor > 0 )
            out.write(buf);
        out.close();
    }
    
    public void flush() throws IOException {
        if( cursor > 0 ) {
            out.write(buf);
            cursor = 0;
        }
    }
}
