import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException, InterruptedException {
    ServerConnectionInterface sci = new ServerConnectionInterface();
     ServerSocket serverSocket = new ServerSocket(8000);
     Socket socket = serverSocket.accept();
     String msgreceived;
     if(socket != null) {
         System.out.println("Client connected");
         sci.connectinglabel.setText("Connected Host:"+socket.getRemoteSocketAddress().toString());
         Thread.sleep(2000);
         sci.dispose();
         ServerApplicationInterface serverApp = new ServerApplicationInterface();
         while(true) {
             if(serverApp.receivestate){
                 System.out.println("Server is receiving message"+serverApp.receivedmessage);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 msgreceived = in.readLine();
                System.out.println(msgreceived);
                serverApp.receivedmessage = msgreceived;
                serverApp.receivestate = false;

         }
             else if(serverApp.sendstate) {
                 System.out.println("Server is sending message"+serverApp.message);
                 String msg = serverApp.message;
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 out.println(msg);
                 System.out.println(serverApp.message);

             }
     }
     }
    }
}
