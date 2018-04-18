package step23.ex5;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class StatelessServer_homework {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        HashMap<String, Integer> userPool = new HashMap<>();
        System.out.println("Server On");
        
        while(true) {
            Socket socket = ss.accept();
            processRequest(userPool, socket);
        }
    }
    
    static void processRequest(HashMap<String, Integer> userPool, Socket socket) throws IOException {
        try (
              Socket socket2 = socket;
              PrintStream out = new PrintStream(socket.getOutputStream());
              Scanner in = new Scanner(socket.getInputStream())) {
            
            String id = in.nextLine();
            System.out.print("Client Name : " + id);
            String str = in.nextLine();
            System.out.println(", value : " + str);
            
            if(str.equals("") || str == null) {
                out.println("결과 : " + userPool.get(id));
                return;
            }
            
            String target = (String) findUser(userPool, id);
            
            int val = Integer.parseInt(str);
            
            if(target == null)
                userPool.put(id, val);
            else
                userPool.put(id, userPool.get(id) + val);
        }
    }
    
    static Object findUser(HashMap<String, Integer> userPool, String id) {
        Collection c = userPool.keySet();
        for(Object obj : c ) {
            if(obj.equals(id))
                return obj;
        }
        return null;
    }
}
