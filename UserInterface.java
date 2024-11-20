import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface extends JFrame {
    public JTextField IPtextfield;
    public JButton connectButton;
    private JPanel IPsubmission;
    private JTextField PortTextfield;
    public String IP;
    public int Port;
    public volatile boolean connected;
    UserInterface(){
        this.setContentPane(IPsubmission);
        this.setTitle("Imtermet Protocol:");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(400,400);
        this.pack();
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IP = IPtextfield.getText();
                Port = Integer.parseInt(PortTextfield.getText());
                connected = true;
            }
        });
    }
}
