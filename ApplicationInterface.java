import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationInterface extends JFrame {
    public JTextField input;
    public JButton sendButton;
    private JPanel Applicationinterface;
    public JLabel ipaddress;
    public JLabel portaddress;
    private JButton Receive;
    public String message = "hi";
    int x =100,y = 100,width =100 ,height = 200;
    public JLabel messages;
    public volatile  boolean isButtonstate;
    public volatile boolean receivestate = false;
    public int count = 1;
    public boolean buttonstate;
    public String receivedmessage;
    ApplicationInterface(){
        this.setContentPane(Applicationinterface);
        this.setTitle("Client Application Interface");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(400,200);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = input.getText();
                isButtonstate = true;
                JLabel mylabel = new JLabel("Client:"+message);
                Applicationinterface.add(mylabel);
                height = height+50;
                Applicationinterface.revalidate();
                Applicationinterface.repaint();
            }
        });

        Receive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receivestate = true;
                JLabel msgreceive = new JLabel("Server:"+receivedmessage);
                Applicationinterface.add(msgreceive);
                Applicationinterface.repaint();
                Applicationinterface.revalidate();
            }
        });
    }
}
