// 역할: 서버 요청 정보를 다룬다. 
package bitcamp.java106.pms.server;

import java.net.URLDecoder;
import java.util.HashMap;

public class ServerRequest {
    
    protected String path;
    protected HashMap<String,String> paramMap = new HashMap<>();
    
    public ServerRequest(String requestLine) throws Exception {
        // requestLine의 예) /board/add?title=aaa&content=bbb
        
        String[] arr = requestLine.split("\\?");
        
        this.path = arr[0]; // 예) /board/add
        if (arr.length > 1) {
            toParamMap(arr[1]);
        }
    }
    
    private void toParamMap(String queryString) {
        // queryString 예) title=aaa&content=bbb
        // 데이터는 key와 value로 분리하여 맵에 저장한다.
        String[] entryArr = queryString.split("&");
        
        for (String entry : entryArr) {
            String[] keyValue = entry.split("=");
            try {
                this.paramMap.put(keyValue[0], URLDecoder.decode(keyValue[1], "UTF-8"));
                //this.paramMap.put(keyValue[0], keyValue[1]);
                // keyValue는 UTF-8코드를 ASCII 문자화 시킨 것으로
                // UTF-8로 다시 만든 다음 UTF-16으로 만들어 자바 String 객체를 반환
            } catch(Exception e) {
                System.out.println("URL DECODING ERROR");
            }
        }
    }
    
    public String getServerPath() {
        return this.path;
    }
    
    public String getParameter(String name) {
        return paramMap.get(name);
    }
}

//ver 28 - 클래스 추가




