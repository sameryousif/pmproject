import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class disease extends JFrame {
    private JLabel L1, L2, L3, L4, L5, L7;
    ImageIcon icon = new ImageIcon("6.jpg");
    JTextField medname, returnedprice;
    private JLabel L1, L3;
    private JButton b1, b2;
    connnection db = new connnection();

    disease() {
        super("");
        Container container = getContentPane();
        container.setLayout(null);

        L1 = new JLabel("enter disease :", 10);
        L1.setBounds(200, 55, 190, 30);
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
        static ResultSet rs;
        static String na;
        static int price;
        static String date;
        static String disease;
        static int QTY;

        public void actionPerformed(ActionEvent event) {
            String na;
            if (event.getSource() == b1) {
                na = medname.getText();
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

                            JOptionPane.showMessageDialog(null, na + "is out of stock", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, na + "is out of stock", "Error", JOptionPane.ERROR_MESSAGE);
                }
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