import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class loginpage extends JFrame {
  private JTextField name;
  static int x = 1;
  private JPasswordField passwd;
  private JLabel L3;
  private JButton b, b2;
  static String myString;
  connnection db = new connnection();
  Handler handler = new Handler();
  ImageIcon icon = new ImageIcon("1.jpg");
  JCheckBox c = new JCheckBox("show password");

  public loginpage() {
    super("login page");
    Container container = getContentPane();

    container.setLayout(null);
    getContentPane().setBackground(Color.BLACK);

    name = new JTextField(20);

    name.setBounds(190, 305, 140, 30);
    name.setFont(new Font("mv Boli", Font.BOLD, 16));
    name.setBackground(Color.WHITE);
    name.setForeground(Color.DARK_GRAY);
    name.setBorder(null);
    name.addActionListener(handler);
    ((AbstractDocument) name.getDocument()).setDocumentFilter(
        new LimitDocumentFilter(10));

    container.add(name);
    passwd = new JPasswordField(20);

    passwd.setBounds(190, 398, 140, 30);
    passwd.setFont(new Font("mv Boli", Font.BOLD, 16));
    passwd.setBackground(Color.WHITE);
    passwd.setForeground(Color.DARK_GRAY);
    passwd.setBorder(null);
    ((AbstractDocument) passwd.getDocument()).setDocumentFilter(
        new LimitDocumentFilter(8));

    passwd.setEchoChar('*');
    passwd.getEchoChar();
    container.add(passwd);

    c.setBounds(160, 450, 150, 20);
    c.setFont(new Font("mv Boli", Font.BOLD, 12));
    c.setBackground(Color.WHITE);
    c.setBorder(null);
    c.setFocusable(false);
    container.add(c);
    c.addActionListener(handler);

    b = new JButton("LOGIN");
    b.setBounds(180, 500, 120, 50);
    b.setBackground(new Color(53, 88, 154));

    b.setFocusable(false);
    container.add(b);

    b2 = new JButton("ADMIN");
    b2.setBounds(180, 580, 120, 50);
    b2.setBackground(new Color(53, 88, 154));
    b2.setFocusable(false);
    container.add(b2);

    L3 = new JLabel();
    L3.setBounds(0, -150, 1440, 1024);
    L3.setFont(new Font("italic", Font.PLAIN, 20));
    L3.setForeground(Color.red);
    L3.setIcon(icon);
    container.add(L3);

    b.addActionListener(handler);
    b2.addActionListener(handler);

    passwd.addActionListener(handler);

    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(false);
    setLocation(0, 0);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private class Handler implements ActionListener {

    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == b) {
        myString = name.getText();
        if (db.checkUser(myString, new String(passwd.getPassword()))) {
          dispose();
          new startpage();
        } else {
          JOptionPane.showMessageDialog(
              null,
              "No user found Or wrong password",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        }
      } else if (event.getSource() == b2) {
        String n = "sam";
        String p = "123";
        String adminname = JOptionPane.showInputDialog(null, "enter your name");
        String adminpass = JOptionPane.showInputDialog(null, "enter your pass");
        if (n.equals(adminname) && p.equals(adminpass)) {
          dispose();

          new admin();
        } else {
          JOptionPane.showMessageDialog(null, "Wrong information");
        }
      } else if (event.getSource() == c) {
        if (c.isSelected()) {
          passwd.setEchoChar((char) 0);
        }
      }
      if (!c.isSelected()) {
        passwd.setEchoChar('*');
      }
    }
  }

  public class LimitDocumentFilter extends DocumentFilter {
    private int limit;

    public LimitDocumentFilter(int limit) {
      if (limit <= 0) {
        throw new IllegalArgumentException("Limit can not be <= 0");
      }
      this.limit = limit;
    }

    @Override
    public void replace(
        FilterBypass fb,
        int offset,
        int length,
        String text,
        AttributeSet attrs)
        throws BadLocationException {
      int currentLength = fb.getDocument().getLength();
      int overLimit = (currentLength + text.length()) - limit - length;
      if (overLimit > 0) {
        text = text.substring(0, text.length() - overLimit);
      }
      if (text.length() > 0) {
        super.replace(fb, offset, length, text, attrs);
      }
    }
  }
}
