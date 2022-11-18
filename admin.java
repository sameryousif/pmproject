import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class admin extends JFrame {
  JTextField name, phone, email, passwd, confpass, uname;
  private JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
  private JButton b1, b2, b3, b4, b11;
  ImageIcon icon = new ImageIcon("4.jpg");
  ImageIcon icon2 = new ImageIcon("6.jpg");
  private int currentCard = 1;
  connnection db = new connnection();

  private CardLayout cl;
  JComboBox<String> j1;
  JComboBox<String> j2;
  JComboBox<String> j3;

  admin() {
    setTitle("");

    JPanel cardPanel = new JPanel();

    cl = new CardLayout();

    cardPanel.setLayout(cl);

    JPanel jp1 = new JPanel();
    jp1.setLayout(null);

    JPanel jp2 = new JPanel();
    jp2.setLayout(null);

    JPanel jp3 = new JPanel();
    // jp3.setLayout(null);

    String[] year = {
        "1990",
        "1991",
        "1992",
        "1993",
        "1994",
        "1995",
        "1996",
        "1997",
        "1998",
        "1999",
        "2000",
        "2001",
        "2002",
        "2003",
        "2004",
    };
    String[] month = {
        "january",
        "february",
        "march",
        "april",
        "may",
        "june",
        "july",
        "august",
        "septemper",
        "october",
        "november",
        "december",
    };
    String[] day = {
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",
        "21",
        "22",
        "23",
        "24",
        "25",
        "26",
        "27",
        "28",
        "29",
        "30",
        "31",
    };

    L1 = new JLabel("Name   :", 10);
    L1.setBounds(350, 60, 170, 30);
    L1.setFont(new Font("mv Boli", Font.BOLD, 24));
    L1.setForeground(Color.DARK_GRAY);

    name = new JTextField(20);

    name.setBounds(510, 60, 550, 30);
    name.setFont(new Font("mv Boli", Font.BOLD, 18));
    name.setBackground(Color.WHITE);
    name.setBorder(null);
    name.setForeground(Color.DARK_GRAY);
    Handler handler1 = new Handler();
    name.addActionListener(handler1);
    ((AbstractDocument) name.getDocument()).setDocumentFilter(
        new LimitDocumentFilter(10));

    L2 = new JLabel("Password :", 10);

    L2.setBounds(350, 150, 170, 30);
    L2.setFont(new Font("mv Boli", Font.BOLD, 24));
    L2.setForeground(Color.DARK_GRAY);

    passwd = new JTextField(20);

    passwd.setBounds(510, 155, 550, 30);
    passwd.setFont(new Font("mv Boli", Font.BOLD, 18));
    passwd.setBackground(Color.WHITE);
    passwd.setBorder(null);
    passwd.setForeground(Color.DARK_GRAY);
    Handler handler2 = new Handler();
    passwd.addActionListener(handler2);
    ((AbstractDocument) passwd.getDocument()).setDocumentFilter(
        new LimitDocumentFilter(8));

    L6 = new JLabel("confpass :", 10);

    L6.setBounds(350, 250, 170, 30);
    L6.setFont(new Font("mv Boli", Font.BOLD, 24));
    L6.setForeground(Color.DARK_GRAY);

    confpass = new JTextField(20);

    confpass.setBounds(510, 250, 550, 30);
    confpass.setFont(new Font("mv Boli", Font.BOLD, 18));
    confpass.setBackground(Color.WHITE);
    confpass.setBorder(null);
    confpass.setForeground(Color.DARK_GRAY);
    Handler handler3 = new Handler();
    confpass.addActionListener(handler3);
    ((AbstractDocument) confpass.getDocument()).setDocumentFilter(
        new LimitDocumentFilter(8));

    L3 = new JLabel("phone    :", 10);
    L3.setBounds(350, 340, 170, 30);
    L3.setFont(new Font("mv Boli", Font.BOLD, 24));
    L3.setForeground(Color.DARK_GRAY);

    phone = new JTextField(20);

    phone.setBounds(510, 340, 550, 30);
    phone.setBorder(null);
    phone.setFont(new Font("mv Boli", Font.BOLD, 18));
    phone.setBackground(Color.WHITE);

    L4 = new JLabel("email   :", 10);
    L4.setBounds(350, 440, 170, 30);
    L4.setFont(new Font("mv Boli", Font.BOLD, 24));
    L4.setForeground(Color.DARK_GRAY);

    email = new JTextField(20);
    email.setBounds(510, 440, 550, 30);
    email.setBorder(null);
    email.setFont(new Font("mv Boli", Font.BOLD, 18));
    email.setBackground(Color.WHITE);

    Handler handler4 = new Handler();
    email.addActionListener(handler4);

    L5 = new JLabel("age     :", 10);
    L5.setBounds(350, 540, 170, 30);
    L5.setFont(new Font("mv Boli", Font.BOLD, 24));
    L5.setForeground(Color.DARK_GRAY);

    j1 = new JComboBox<>(day);
    j1.setBounds(510, 550, 140, 20);
    j1.setBorder(null);
    j1.setFocusable(false);

    j2 = new JComboBox<>(month);
    j2.setBounds(680, 550, 140, 20);
    j2.setBorder(null);
    j2.setFocusable(false);

    j3 = new JComboBox<>(year);
    j3.setBounds(850, 550, 140, 20);
    j3.setBorder(null);
    j3.setFocusable(false);

    b1 = new JButton("Save all");
    b1.setBounds(800, 630, 150, 40);
    b1.setBackground(new Color(53, 88, 154));
    b1.setFocusable(false);
    b1.setBorderPainted(true);

    b2 = new JButton("Ignore");
    b2.setBounds(570, 630, 150, 40);
    b2.setBackground(new Color(53, 88, 154));
    b2.setFocusable(false);
    b2.setBorderPainted(true);

    Handler handler = new Handler();
    b1.addActionListener(handler);
    b2.addActionListener(handler);
    L7 = new JLabel();
    L7.setBounds(20, -150, 1440, 1024);
    L7.setFont(new Font("mv Boli", Font.BOLD, 26));
    L7.setForeground(Color.DARK_GRAY);
    L7.setIcon(icon);

    L8 = new JLabel("username :", 10);
    L8.setBounds(280, 55, 170, 30);
    L8.setFont(new Font("mv Boli", Font.BOLD, 24));
    L8.setForeground(Color.DARK_GRAY);
    uname = new JTextField(20);

    uname.setBounds(460, 52, 560, 50);
    uname.setFont(new Font("mv Boli", Font.BOLD, 18));
    uname.setBackground(Color.WHITE);
    uname.setForeground(Color.DARK_GRAY);
    uname.setBorder(null);

    uname.addActionListener(handler);

    b3 = new JButton("Submit");
    b3.setBounds(650, 500, 100, 40);
    b3.setBackground(new Color(53, 88, 154));
    b3.setFocusable(false);
    b3.setBorderPainted(true);
    b3.addActionListener(handler);

    b4 = new JButton("Cancel");
    b4.setBounds(500, 500, 100, 40);
    b4.setBackground(new Color(53, 88, 154));
    b4.setFocusable(false);
    b4.setBorderPainted(true);

    b4.addActionListener(handler);
    L9 = new JLabel();
    L9.setBounds(0, -150, 1440, 1024);
    L9.setIcon(icon2);

    ResultSet rs = db.returnLogs();
    String data[][] = new String[new connnection().getlength("logs")][4];

    try {
      int i = 0;
      while (rs.next()) {
        data[i][0] = rs.getString("name");
        data[i][1] = rs.getString("date");
        data[i][2] = rs.getString("QTY");
        data[i][3] = rs.getString("price");
        i++;
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "error",
          JOptionPane.ERROR_MESSAGE);
    }

    String column[] = { "Medcine name", "date", "quantity", "price" };
    JTable jt = new JTable(data, column);
    jt.setBounds(100, 100, 200, 800);
    jt.setBackground(Color.LIGHT_GRAY);
    JScrollPane sp = new JScrollPane(jt);
    b11 = new JButton("done");
    b11.setBounds(700, 600, 80, 40);
    b11.setBorderPainted(true);
    b11.setFocusable(false);
    b11.setBackground(new Color(53, 88, 154));
    sp.setVisible(true);
    b11.setVisible(true);
    Handler h = new Handler();
    b11.addActionListener(h);

    jp1.add(name);
    jp1.add(passwd);
    jp1.add(confpass);
    jp1.add(phone);
    jp1.add(email);
    jp1.add(L1);
    jp1.add(L2);
    jp1.add(L3);
    jp1.add(L4);
    jp1.add(L5);
    jp1.add(L6);
    jp1.add(j1);
    jp1.add(j2);
    jp1.add(j3);
    jp1.add(b1);
    jp1.add(b2);
    jp1.add(L7);
    jp2.add(L8);
    jp2.add(uname);
    jp2.add(b3);
    jp2.add(b4);
    jp2.add(L9);

    jp3.add(b11);
    jp3.add(sp);
    cardPanel.add(jp1, "1");

    cardPanel.add(jp2, "2");

    cardPanel.add(jp3, "3");
    cardPanel.setBounds(15, 30, 1332, 929);

    JPanel buttonPanel = new JPanel();
    buttonPanel.setBackground(new Color(53, 88, 154));

    JButton addbtn = new JButton("new user");
    addbtn.setBounds(750, 250, 100, 30);
    addbtn.setBackground(Color.LIGHT_GRAY);
    addbtn.setFocusable(false);
    addbtn.setBorderPainted(true);

    JButton deletebtn = new JButton("delete user");
    deletebtn.setBounds(750, 250, 200, 30);
    deletebtn.setBackground(Color.LIGHT_GRAY);
    deletebtn.setFocusable(false);
    deletebtn.setBorderPainted(true);

    JButton sellsBtn = new JButton("pharmacy sells");
    sellsBtn.setBounds(750, 250, 100, 30);
    sellsBtn.setBackground(Color.LIGHT_GRAY);
    sellsBtn.setFocusable(false);
    sellsBtn.setBorderPainted(true);

    buttonPanel.add(addbtn);

    buttonPanel.add(deletebtn);

    buttonPanel.add(sellsBtn);

    setVisible(true);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    // setUndecorated(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    addbtn.addActionListener(
        new ActionListener() {

          public void actionPerformed(ActionEvent arg0) {
            currentCard = 1;

            cl.show(cardPanel, "" + (currentCard));
          }
        });

    deletebtn.addActionListener(
        new ActionListener() {

          public void actionPerformed(ActionEvent arg0) {
            currentCard = 2;

            cl.show(cardPanel, "" + (currentCard));
          }
        });

    sellsBtn.addActionListener(
        new ActionListener() {

          public void actionPerformed(ActionEvent arg0) {
            currentCard = 3;

            cl.show(cardPanel, "" + (currentCard));
          }
        });

    getContentPane().add(cardPanel, null);

    getContentPane().add(buttonPanel, null);
  }

  private class Handler implements ActionListener {

    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == b1) {
        if (name.getText().equals("")) {
          JOptionPane.showMessageDialog(
              null,
              "NAME MUST  NOT BE EMPTY ",
              " NAME NOT VALID ",
              JOptionPane.ERROR_MESSAGE);
        }
        if (passwd.getText().equals("")) {
          JOptionPane.showMessageDialog(
              null,
              "PASSWORD MUST  NOT BE EMPTY ",
              " PASSWORD NOT VALID ",
              JOptionPane.ERROR_MESSAGE);
        }
        if (confpass.getText().equals("")) {
          JOptionPane.showMessageDialog(
              null,
              "CONFIRMATION PASSWORD  MUST  NOT BE EMPTY ",
              " PASSWORD NOT VALID ",
              JOptionPane.ERROR_MESSAGE);
        }
        if (!passwd.getText().equals(confpass.getText())) {
          JOptionPane.showMessageDialog(
              null,
              "WRONG PASSWORD",
              "WRONG PASSWORD",
              JOptionPane.ERROR_MESSAGE);
        }
        if (phone.getText().equals("")) {
          JOptionPane.showMessageDialog(
              null,
              "PHONE MUST  NOT BE EMPTY ",
              " PHONE NOT VALID ",
              JOptionPane.ERROR_MESSAGE);
        }

        if (email.getText().equals("")) {
          JOptionPane.showMessageDialog(
              null,
              "EMAIL MUST  NOT BE EMPTY ",
              " EMAIL NOT VALID ",
              JOptionPane.ERROR_MESSAGE);
        } else if (!email.getText().trim().contains("@")) {
          JOptionPane.showMessageDialog(
              null,
              "EMAIL MUST CONTAIN @",
              " EMAIL NOT VALID ",
              JOptionPane.ERROR_MESSAGE);
        } else if (passwd.getText().equals(confpass.getText()) &&
            email.getText().trim().contains("@")) {
          db.addUser(
              name.getText(),
              passwd.getText(),
              phone.getText(),
              email.getText(),
              j1.getSelectedItem(),
              j2.getSelectedItem(),
              j3.getSelectedItem());
          dispose();
          new loginpage();
        }
      }
      if (event.getSource() == b2) {
        dispose();
        new loginpage();
      }
      if (event.getSource() == b3) {
        if (db.checkUser(uname.getText())) {
          db.delete(uname.getText());
          JOptionPane.showMessageDialog(null, "deleted successfully");
          dispose();
          new loginpage();
        } else {
          JOptionPane.showMessageDialog(null, "User not found",
              "User not found",
              JOptionPane.ERROR_MESSAGE);
        }
      }
      if (event.getSource() == b4) {
        dispose();
        new loginpage();
      }
      if (event.getSource() == b11) {
        dispose();
        new loginpage();
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
