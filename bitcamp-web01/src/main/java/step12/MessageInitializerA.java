package step12;

import java.util.Map;

import bitcamp.mylib.MessageInitializer;

public class MessageInitializerA implements MessageInitializer {

    @Override
    public void onStartUp(Map<String, String> msgMap) {
        System.out.println("MessageInitializerA.onStartUp");
        msgMap.put("title", "제목");
        msgMap.put("content", "내용");
    }
}
