import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.*;

public class startpage extends JFrame {
  ImageIcon icon = new ImageIcon("2.jpg");
  private JButton b1, b2, b3, b5, b6;
  private JMenu menu1, menu2;
  private JMenuItem showItem, returnItem, aboutItem;
  private JLabel L1, L2, L3, L4, L5, L7;
  private JTextField name1;
  connnection db = new connnection();

  startpage() {
    super("");
    Container container = getContentPane();

    container.setLayout(null);
    getContentPane().setBackground(new Color(53, 88, 154));
    L1 = new JLabel("welocome  : " + loginpage.myString);
    L1.setBounds(50, 30, 800, 30);
    L1.setFont(new Font("mv Boli", Font.BOLD, 26));
    L1.setForeground(Color.DARK_GRAY);

    container.add(L1);
    L2 = new JLabel("Medcine status : ");
    L2.setBounds(400, 250, 400, 20);
    L2.setFont(new Font("mv Boli", Font.BOLD, 20));
    L2.setForeground(Color.DARK_GRAY);
    L2.setVisible(false);
    container.add(L2);
    L3 = new JLabel("Medcine price : ");
    L3.setBounds(400, 300, 400, 20);
    L3.setFont(new Font("mv Boli", Font.BOLD, 20));
    L3.setForeground(Color.DARK_GRAY);
    L3.setVisible(false);
    container.add(L3);

    L4 = new JLabel("Medcine expire : ");
    L4.setBounds(400, 350, 400, 20);
    L4.setFont(new Font("mv Boli", Font.BOLD, 20));
    L4.setForeground(Color.DARK_GRAY);
    L4.setVisible(false);
    container.add(L4);
    L5 = new JLabel("disease        : ");
    L5.setBounds(400, 400, 400, 20);
    L5.setFont(new Font("mv Boli", Font.BOLD, 20));
    L5.setForeground(Color.DARK_GRAY);
    L5.setVisible(false);
    container.add(L5);

    b5 = new JButton("Finish");
    b5.setBounds(500, 500, 100, 30);
    b5.setBackground(new Color(53, 88, 154));
    b5.setFocusable(false);
    b5.setBorderPainted(true);
    container.add(b5);
    b5.setVisible(false);

    b6 = new JButton("Cancel");
    b6.setBounds(650, 500, 100, 30);
    b6.setBackground(new Color(53, 88, 154));
    b6.setFocusable(false);
    b6.setBorderPainted(true);
    container.add(b6);
    b6.setVisible(false);

    name1 = new JTextField();
    name1.setBounds(510, 150, 500, 30);
    name1.setFont(new Font("mv Boli", Font.BOLD, 18));
    name1.setBackground(Color.WHITE);
    name1.setForeground(Color.DARK_GRAY);
    name1.setBorder(null);

    container.add(name1);

    b1 = new JButton("search");
    b1.setBounds(1100, 150, 100, 30);
    b1.setBackground(new Color(53, 88, 154));
    b1.setFocusable(false);
    b1.setBorderPainted(true);

    container.add(b1);
    Handler handler = new Handler();
    b1.addActionListener(handler);
    /*               */
    b2 = new JButton("EDIT");
    b2.setBounds(1100, 500, 100, 30);
    b2.setBackground(new Color(53, 88, 154));
    b2.setFocusable(false);
    b2.setBorderPainted(true);
    container.add(b2);
    Handler handler2 = new Handler();

    b2.addActionListener(handler2);
    /***************** */
    b3 = new JButton("logout");
    b3.setBounds(1100, 550, 100, 30);
    b3.setBackground(new Color(53, 88, 154));
    b3.setFocusable(false);
    b3.setBorderPainted(true);
    container.add(b3);
    Handler handler3 = new Handler();

    b3.addActionListener(handler3);

    JMenuBar bar = new JMenuBar(); // [1]create menubar
    setJMenuBar(bar); // [2] set menubar for the JFrame
    bar.setBackground(Color.GRAY);
    // [3] Create the First Menu
    menu1 = new JMenu("SETTINGS");
    menu1.setMnemonic('S'); // once press Alt+f from Keyboard

    returnItem = new JMenuItem("return Medcine");
    Handler handler1 = new Handler();
    returnItem.addActionListener(handler1);
    showItem = new JMenuItem("Pharmacy meds");
    Handler handler4 = new Handler();
    showItem.addActionListener(handler4);

    menu1.add(returnItem);
    menu1.add(showItem);

    menu2 = new JMenu("Help");
    menu2.setMnemonic('h');
    aboutItem = new JMenuItem("About...");
    Handler handler5 = new Handler();
    aboutItem.addActionListener(handler5);

    menu2.add(aboutItem);

    bar.add(menu1);
    bar.add(menu2);
    L7 = new JLabel();
    L7.setBounds(25, -180, 1440, 1024);
    L7.setFont(new Font("mv Boli", Font.BOLD, 26));
    L7.setForeground(Color.DARK_GRAY);
    L7.setIcon(icon);
    container.add(L7);

    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(false);
    setLocation(0, 0);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private class Handler implements ActionListener {
    static ResultSet rs;
    static String na;
    static int price;
    static String date;
    static String disease;
    static int QTY;

    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == b1) {
        na = name1.getText();
        if (!na.equals("")) {

          if (db.checkdrug(na)) {
            L2.setText("Medcine status : ");
            L3.setText("Medcine price  : ");
            L4.setText("Medcine expire : ");
            L5.setText("disease        : ");
            rs = db.retriveDrug(na);
            try {
              int y = 0;
              while (rs.next()) {
                if (y < 1) {
                  price = rs.getInt("price");
                  na = rs.getString("name");
                  date = rs.getString("date");
                  QTY = rs.getInt("QTY");
                  disease = rs.getString("disease");
                  L2.setText(L2.getText() + "  available");
                  L3.setText(L3.getText() + "  " + price);
                  L4.setText(L4.getText() + "  " + date);
                  L5.setText(L5.getText() + "  " + disease);
                  y++;
                }
              }
            } catch (SQLException e) {
              JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (QTY > 0) {
              L2.setVisible(true);
              L3.setVisible(true);
              L4.setVisible(true);
              L5.setVisible(true);
              b5.setVisible(true);
              b6.setVisible(true);
            } else {

              JOptionPane.showMessageDialog(null, na + "is out of stock", "Error", JOptionPane.ERROR_MESSAGE);
            }
          }
        } else {
          JOptionPane.showMessageDialog(null, na + "is out of stock", "Error", JOptionPane.ERROR_MESSAGE);
        }
        Handler handlerr2 = new Handler();
        b6.addActionListener(handlerr2);

        b5.addActionListener(handlerr2);
      } else if (event.getSource() == b3) {
        int result = JOptionPane.showConfirmDialog(
            null,
            "Are you sure",
            "Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
          dispose();
          new loginpage();
        } else if (result == JOptionPane.NO_OPTION) {
          System.out.println();
        }
      }
      if (event.getSource() == b2) {
        dispose();
        new edit();
      }
      if (event.getSource() == showItem) {

        dispose();

        new logs();

      }
      if (event.getSource() == returnItem) {
        dispose();
        new returned();
      }
      if (event.getSource() == aboutItem) {
        JOptionPane.showMessageDialog(
            null,
            "some access are restrict to user only admin can see details edit things");
      }

      if (event.getSource() == b5) {
        String qu = JOptionPane.showInputDialog(null, "enter quantity");
        if (Integer.parseInt(qu) <= QTY) {

          JOptionPane.showMessageDialog(null, "the total is : " + (Integer.parseInt(qu) * price));
          db.decreas(na, Integer.parseInt(qu));
          db.log(na, (new Date()).toString(), price, "" + (Integer.parseInt(qu) * price));
          L2.setVisible(false);
          L3.setVisible(false);
          L4.setVisible(false);
          L5.setVisible(false);
          b5.setVisible(false);
          b6.setVisible(false);
          L2.setText("Medcine status : ");
          L3.setText("Medcine price  : ");
          L4.setText("Medcine expire : ");
          L5.setText("disease        : ");
        } else {
          JOptionPane.showMessageDialog(null, "not enough quantity available is " + QTY);
        }
      }
      if (event.getSource() == b6) {
        // JOptionPane.showMessageDialog(null, "done");
        new startpage();
      }
    }
  }
}
