import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        UserInterface ui = new UserInterface();
        Thread.sleep(10000);
        Socket socket = new Socket(ui.IP + "", ui.Port);
        System.out.println("IP:" + ui.IP);
        System.out.println("Port:" + ui.Port);
        String msgreceived;

        if (socket.isConnected()) {
            ui.dispose();
            ApplicationInterface ai = new ApplicationInterface();
            ai.ipaddress.setText("IP Address:"+ui.IP);
            ai.portaddress.setText("Port Address:"+ui.Port);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


            while (true) {
                if (ai.isButtonstate) {
                    System.out.println("Client is sending message"+ai.message);
                    String msg = ai.message;
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(msg);
                    ai.isButtonstate = false;

                }
                else if(ai.receivestate){
                    System.out.println("Client is receiving message");
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    msgreceived = input.readLine();
                    System.out.println(msgreceived);
                    ai.receivedmessage = msgreceived;
                    ai.receivestate = false;

                }

            }
        }
    }
}