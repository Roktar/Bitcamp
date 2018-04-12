package step22.ex5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
    byte[] buf = new byte[8196];
    int size; // count of bytes
    int cursor; // index of array read byte
    
    
    public BufferedInputStream(String name) throws FileNotFoundException {
        super(name);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public int read() throws IOException {
        if ( cursor == size ) { // 이거슨 버퍼에 있는 모든 데이터를 읽었다는 의미가 된다.
/*            size = this.read(buf, 0, buf.length);
            
            if(size == -1) // 읽을 데이터가 없다.
                return -1;*/
            
            if( (size = this.read(buf)) == -1)
                return -1; //읽을 데이터가 없다는 걸 의미하는 게 -1
            
            cursor = 0; // 다시 배열의 처음부터 채울 것이기때문에 인덱스를 처음으로 조정한다.
        }
        // 처음엔 size, cursor 전부 0이라서 위의 if문에 걸린다.
        // size는 데이터가 입력된 횟수이므로 배열의 맥스치인 8196이 된다.(그 이하인 경우 그 값으로 지정)
        // count는 0부터 size까지 돌아보게된다.
        // 만약 8196==8196이 되는 경우, 다음 데이터를 다시 읽고 cursor만 0으로 바뀐다.
        // size는 다시 읽어온 만큼의 데이터 숫자만큼이 되고, cursor는 0부터 다시 읽어온 만큼의 데이터 숫자까지 이동한다.
        
        // 음수가 나올 수 없는데 음수가 나오면 거기서 끝나게될 수 있다.
        // 따라서 간혹 나올 음수를 양수로 변환한다.
        // 음수가 나오는 이유는 aa를 읽었을 때, a는 1010이다.
        // 즉, 앞의 수가 1이면 앞의 모든 수는 1로 채워진다는 것이다.
        // 그래서 음수로 바뀌게 되는 것이다. 
        // 하지만 이 입력에서는 음수가 나올 일이 없기때문에 양수로 마스킹하는 것이다.
        return 0x000000ff & buf[cursor++];
    }
}
