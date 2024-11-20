import javax.swing.*;

public class ServerConnectionInterface extends JFrame{
    private JPanel serverconnectionpanel;
    public JLabel connectinglabel;
    ServerConnectionInterface(){
        this.setContentPane(serverconnectionpanel);
        this.setTitle("Server Connection");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(250,100);
    }
}
