import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class homepage extends JFrame implements MouseListener {
    ImageIcon icon = new ImageIcon("ssss.png");
    JLabel l = new JLabel();

    homepage() {
        super("home page");
        Container container = getContentPane();

        container.setLayout(new FlowLayout());
        l.setBounds(0, 0, 1440, 1024);
        l.setHorizontalTextPosition(JLabel.CENTER);
        l.setVerticalTextPosition(JLabel.CENTER);
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("mv Boli", Font.PLAIN, 20));
        l.setIcon(icon);
        l.addMouseListener(this);
        container.add(l);

        // setSize(1366, 786);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setLocation(0, 0);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        dispose();
        new loginpage();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}