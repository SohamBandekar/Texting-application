import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerApplicationInterface extends JFrame {
    public JTextField inputtext;
    private JButton sendButton;
    private JPanel ServerApplicationInterfacepanel;
    public JButton receiveButton;
    public volatile boolean receivestate = false;
    public String receivedmessage;
    public volatile boolean sendstate = false;
    public String message;
    ServerApplicationInterface(){
       this.setContentPane(ServerApplicationInterfacepanel);
       this.setSize(400, 200);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);

       this.setTitle("Server Application Interface");
        receiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receivestate = true;
                JLabel msgreceive = new JLabel("Client:"+receivedmessage);
                ServerApplicationInterfacepanel.add(msgreceive);
                ServerApplicationInterfacepanel.repaint();
                ServerApplicationInterfacepanel.revalidate();
            }
        });
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendstate = true;
                message = inputtext.getText();
                JLabel mylabel = new JLabel("Server:"+message);
                ServerApplicationInterfacepanel.add(mylabel);
                ServerApplicationInterfacepanel.revalidate();
                ServerApplicationInterfacepanel.repaint();
                sendstate = false;
            }
        });
    }
}
