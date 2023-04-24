import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyWindow extends JFrame{ 
    public MyWindow(){
        super("Ma première application swing");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(new JButton("click me !"));
        contentPane.add(new JButton("push me !!!"));
        contentPane.add(new JCheckBox("check me"));
        contentPane.add(new JTextField("edit me"));
    }
    public static void main(String[] args){
        MyWindow mainWindow = new MyWindow();
        mainWindow.setVisible(true);
    }
}
