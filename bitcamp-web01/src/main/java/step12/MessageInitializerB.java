package step12;

import java.util.Map;

import bitcamp.mylib.MessageInitializer;

public class MessageInitializerB implements MessageInitializer {

    @Override
    public void onStartUp(Map<String, String> msgMap) {
        System.out.println("MessageInitializerB.onStartUp");
        msgMap.put("password", "123123");
        msgMap.put("id", "IDID");
    }
}
