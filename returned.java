import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class returned extends JFrame {
  ImageIcon icon = new ImageIcon("6.jpg");
  JTextField medname, returnedprice;
  private JLabel L1, L3;
  private JButton b1, b2;
  connnection db = new connnection();

  returned() {
    super("");
    Container container = getContentPane();
    container.setLayout(null);

    L1 = new JLabel("medname :", 10);
    L1.setBounds(280, 55, 170, 30);
    L1.setFont(new Font("mv Boli", Font.BOLD, 24));
    L1.setForeground(Color.DARK_GRAY);
    medname = new JTextField(20);

    medname.setBounds(460, 52, 560, 50);
    medname.setFont(new Font("mv Boli", Font.BOLD, 18));
    medname.setBackground(Color.WHITE);
    medname.setForeground(Color.DARK_GRAY);
    medname.setBorder(null);
    Handler handler = new Handler();
    medname.addActionListener(handler);

    b1 = new JButton("Submit");
    b1.setBounds(650, 500, 100, 40);
    b1.setBackground(new Color(53, 88, 154));
    b1.setFocusable(false);
    b1.setBorderPainted(true);
    b1.addActionListener(handler);

    b2 = new JButton("Cancel");
    b2.setBounds(500, 500, 100, 40);
    b2.setBackground(new Color(53, 88, 154));
    b2.setFocusable(false);
    b2.setBorderPainted(true);

    b2.addActionListener(handler);
    L3 = new JLabel();
    L3.setBounds(0, -150, 1440, 1024);
    L3.setIcon(icon);
    container.add(medname);

    container.add(L1);

    container.add(b1);
    container.add(b2);
    container.add(L3);

    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(false);
    setLocation(0, 0);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private class Handler implements ActionListener {
    public void actionPerformed(ActionEvent event) {

      if (event.getSource() == b1) {
        String quantity = JOptionPane.showInputDialog(null, "enter quantity");
        db.increase(medname.getText(), Integer.parseInt(quantity));
        dispose();
        new startpage();

      }
      if (event.getSource() == b2) {
        dispose();
        new startpage();
      }
    }

  }
}