import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class edit extends JFrame {
    JTextField medname, expdate, price, disease, crtdate, quantity, name1, name2, medname1, expdate1, price1, disease1,
            crtdate1, quantity1;
    private JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L21, L31, L41, L51, L61, L111, L50, L60, L70;
    private JButton b1, b2, b3, b4, b6, bb, b11, b61;
    ImageIcon icon = new ImageIcon("3.jpg");
    ImageIcon icon2 = new ImageIcon("6.jpg");
    ImageIcon icon3 = new ImageIcon("6.jpg");

    private int currentCard = 1;

    private CardLayout cl;

    connnection db = new connnection();

    public edit() {

        setTitle("");

        JPanel cardPanel = new JPanel();

        cl = new CardLayout();

        cardPanel.setLayout(cl);

        JPanel jp1 = new JPanel();
        jp1.setLayout(null);

        JPanel jp2 = new JPanel();
        jp2.setLayout(null);

        JPanel jp3 = new JPanel();
        jp3.setLayout(null);

        JLabel jl1 = new JLabel();

        JLabel jl2 = new JLabel();
        L1 = new JLabel("medname :", 10);
        L1.setBounds(300, 60, 170, 30);
        L1.setFont(new Font("mv Boli", Font.BOLD, 24));
        L1.setForeground(Color.DARK_GRAY);
        medname = new JTextField(20);

        medname.setBounds(500, 60, 550, 30);
        medname.setFont(new Font("mv Boli", Font.BOLD, 18));
        medname.setBackground(Color.WHITE);
        medname.setForeground(Color.DARK_GRAY);
        Handler handler1 = new Handler();
        medname.setBorder(null);
        medname.addActionListener(handler1);
        L2 = new JLabel("disease :", 10);

        L2.setBounds(300, 150, 170, 30);
        L2.setFont(new Font("mv Boli", Font.BOLD, 24));
        L2.setForeground(Color.DARK_GRAY);
        disease = new JTextField(20);

        disease.setBounds(500, 150, 550, 30);
        disease.setBackground(Color.WHITE);
        disease.setForeground(Color.DARK_GRAY);
        disease.setFont(new Font("mv Boli", Font.BOLD, 18));
        disease.setBorder(null);
        Handler handler2 = new Handler();
        disease.addActionListener(handler2);
        L6 = new JLabel("crtdate:", 10);

        L6.setBounds(300, 250, 170, 30);
        L6.setFont(new Font("mv Boli", Font.BOLD, 24));
        L6.setForeground(Color.DARK_GRAY);
        crtdate = new JTextField(20);
        crtdate.setBounds(500, 250, 550, 30);
        crtdate.setBackground(Color.WHITE);
        crtdate.setForeground(Color.DARK_GRAY);
        crtdate.setFont(new Font("mv Boli", Font.BOLD, 18));
        crtdate.setBorder(null);
        Handler handler3 = new Handler();
        crtdate.addActionListener(handler3);
        L3 = new JLabel("expdate:", 10);
        L3.setBounds(300, 340, 170, 30);
        L3.setFont(new Font("mv Boli", Font.BOLD, 24));
        L3.setForeground(Color.DARK_GRAY);
        expdate = new JTextField(20);
        expdate.setBounds(500, 340, 550, 30);
        expdate.setFont(new Font("mv Boli", Font.BOLD, 18));
        expdate.setBorder(null);
        L4 = new JLabel("price  :", 10);
        L4.setBounds(300, 440, 170, 30);
        L4.setFont(new Font("mv Boli", Font.BOLD, 24));
        L4.setForeground(Color.DARK_GRAY);
        price = new JTextField(20);
        price.setBounds(500, 440, 550, 30);
        price.setFont(new Font("mv Boli", Font.BOLD, 18));
        price.setBorder(null);
        L5 = new JLabel("quantity  :", 10);
        L5.setBounds(300, 540, 170, 30);
        L5.setFont(new Font("mv Boli", Font.BOLD, 24));
        L5.setForeground(Color.DARK_GRAY);
        quantity = new JTextField(20);
        quantity.setBounds(500, 540, 550, 30);
        quantity.setFont(new Font("mv Boli", Font.BOLD, 18));
        quantity.setBorder(null);
        b1 = new JButton("Submit");
        b1.setBounds(650, 625, 100, 40);
        b1.setBackground(new Color(53, 88, 154));
        b1.setFocusable(false);
        b1.setBorderPainted(true);
        Handler handler = new Handler();
        b1.addActionListener(handler);

        b6 = new JButton("Cancel");
        b6.setBounds(500, 625, 100, 40);
        b6.setBackground(new Color(53, 88, 154));
        b6.setFocusable(false);
        b6.setBorderPainted(true);
        Handler handler5 = new Handler();
        b6.addActionListener(handler5);

        name1 = new JTextField();
        name1.setBounds(515, 60, 500, 30);
        name1.setFont(new Font("mv Boli", Font.BOLD, 18));
        name1.setBackground(Color.WHITE);
        name1.setForeground(Color.DARK_GRAY);
        name1.setBorder(null);
        b3 = new JButton("search");
        b3.setBounds(1100, 60, 100, 30);
        b3.setBackground(new Color(53, 88, 154));
        b3.setFocusable(false);
        b3.setBorderPainted(true);
        Handler h = new Handler();
        b3.addActionListener(h);

        b2 = new JButton("Delete");
        b2.setBounds(650, 500, 100, 30);
        b2.setBackground(new Color(53, 88, 154));
        b2.setFocusable(false);
        b2.setBorderPainted(true);
        Handler handlerr1 = new Handler();
        b2.addActionListener(handlerr1);

        b4 = new JButton("Igonre");
        b4.setBounds(500, 500, 100, 30);
        b4.setBackground(new Color(53, 88, 154));
        b4.setFocusable(false);
        b4.setBorderPainted(true);
        // b4.setVisible(false);
        Handler handlerr11 = new Handler();
        b4.addActionListener(handlerr11);

        L7 = new JLabel("Medcine name : ");
        L7.setBounds(300, 200, 400, 20);
        L7.setFont(new Font("mv Boli", Font.BOLD, 20));
        L7.setForeground(Color.DARK_GRAY);
        L7.setVisible(false);

        L8 = new JLabel("Medcine price : ");
        L8.setBounds(300, 250, 400, 20);
        L8.setFont(new Font("mv Boli", Font.BOLD, 20));
        L8.setForeground(Color.DARK_GRAY);
        L8.setVisible(false);

        L9 = new JLabel("Medcine expire: ");
        L9.setBounds(300, 300, 400, 20);
        L9.setFont(new Font("mv Boli", Font.BOLD, 20));
        L9.setForeground(Color.DARK_GRAY);
        L9.setVisible(false);
        L10 = new JLabel("disease:");
        L10.setBounds(300, 350, 200, 20);
        L10.setFont(new Font("mv Boli", Font.BOLD, 20));
        L10.setForeground(Color.DARK_GRAY);
        L10.setVisible(false);

        name2 = new JTextField();
        name2.setBounds(515, 60, 500, 30);
        name2.setFont(new Font("mv Boli", Font.BOLD, 18));
        name2.setBackground(Color.WHITE);
        name2.setForeground(Color.DARK_GRAY);
        name2.setBorder(null);
        bb = new JButton("search");
        bb.setBounds(1100, 60, 100, 30);
        bb.setBackground(new Color(53, 88, 154));
        bb.setFocusable(false);
        bb.setBorderPainted(true);

        bb.addActionListener(h);

        L111 = new JLabel("medname :", 10);
        L111.setBounds(350, 150, 170, 30);
        L111.setFont(new Font("mv Boli", Font.BOLD, 24));
        L111.setForeground(Color.DARK_GRAY);
        L111.setVisible(false);
        medname1 = new JTextField(20);

        medname1.setBounds(500, 150, 300, 30);
        medname1.setFont(new Font("mv Boli", Font.BOLD, 18));
        medname1.setBackground(Color.WHITE);
        medname1.setForeground(Color.DARK_GRAY);
        medname1.setVisible(false);

        medname1.addActionListener(handler);
        L21 = new JLabel("disease :", 10);

        L21.setBounds(350, 200, 170, 30);
        L21.setFont(new Font("mv Boli", Font.BOLD, 24));
        L21.setForeground(Color.DARK_GRAY);
        L21.setVisible(false);
        disease1 = new JTextField(20);

        disease1.setBounds(500, 200, 300, 30);
        disease1.setBackground(Color.WHITE);
        disease1.setForeground(Color.DARK_GRAY);
        disease1.setVisible(false);
        disease1.addActionListener(handler);
        L61 = new JLabel("crtdate:", 10);

        L61.setBounds(350, 250, 170, 30);
        L61.setFont(new Font("mv Boli", Font.BOLD, 24));
        L61.setForeground(Color.DARK_GRAY);
        L61.setVisible(false);
        crtdate1 = new JTextField(20);
        crtdate1.setBounds(500, 250, 300, 30);
        crtdate1.setBackground(Color.WHITE);
        crtdate1.setForeground(Color.DARK_GRAY);
        crtdate1.setVisible(false);

        crtdate1.addActionListener(handler);
        L31 = new JLabel("expdate:", 10);
        L31.setBounds(350, 300, 170, 30);
        L31.setFont(new Font("mv Boli", Font.BOLD, 24));
        L31.setForeground(Color.DARK_GRAY);
        L31.setVisible(false);
        expdate1 = new JTextField(20);

        expdate1.setBounds(500, 300, 300, 30);
        expdate1.setVisible(false);
        L41 = new JLabel("price  :", 10);
        L41.setBounds(350, 350, 170, 30);
        L41.setFont(new Font("mv Boli", Font.BOLD, 24));
        L41.setForeground(Color.DARK_GRAY);
        L41.setVisible(false);
        price1 = new JTextField(20);
        price1.setBounds(500, 350, 300, 30);
        price1.setVisible(false);
        L51 = new JLabel("quantity  :", 10);
        L51.setBounds(350, 400, 170, 30);
        L51.setFont(new Font("mv Boli", Font.BOLD, 24));
        L51.setForeground(Color.DARK_GRAY);
        L51.setVisible(false);
        quantity1 = new JTextField(20);
        quantity1.setBounds(500, 400, 300, 30);
        quantity1.setVisible(false);
        b11 = new JButton("Submit");
        b11.setBounds(650, 550, 100, 40);
        b11.setBackground(new Color(53, 88, 154));
        b11.setFocusable(false);
        b11.setBorderPainted(true);

        b11.addActionListener(handler);

        b61 = new JButton("Cancel");
        b61.setBounds(500, 550, 100, 40);
        b61.setBackground(new Color(53, 88, 154));
        b61.setFocusable(false);
        b61.setBorderPainted(true);

        b61.addActionListener(handler5);

        L60 = new JLabel();
        L60.setBounds(0, -150, 1440, 1024);
        L60.setIcon(icon);
        L50 = new JLabel();
        L50.setBounds(0, -150, 1440, 1024);
        L50.setIcon(icon2);
        L70 = new JLabel();
        L70.setBounds(0, -150, 1440, 1024);
        L70.setIcon(icon3);

        jp1.add(jl1);
        jp1.add(L1);
        jp1.add(medname);
        jp1.add(L2);
        jp1.add(disease);
        jp1.add(L6);
        jp1.add(crtdate);
        jp1.add(L3);
        jp1.add(expdate);
        jp1.add(L4);
        jp1.add(price);
        jp1.add(L5);
        jp1.add(quantity);
        jp1.add(b1);
        jp1.add(b6);
        jp1.add(L60);

        jp2.add(jl2);
        jp2.add(name1);
        jp2.add(b3);
        jp2.add(b2);
        jp2.add(b4);
        jp2.add(L7);
        jp2.add(L8);
        jp2.add(L9);
        jp2.add(L10);
        jp2.add(L50);

        jp3.add(name2);
        jp3.add(bb);
        jp3.add(L111);
        jp3.add(medname1);
        jp3.add(L21);
        jp3.add(disease1);
        jp3.add(L61);
        jp3.add(crtdate1);
        jp3.add(L31);
        jp3.add(expdate1);
        jp3.add(L41);
        jp3.add(price1);
        jp3.add(L51);
        jp3.add(quantity1);
        jp3.add(b11);
        jp3.add(b61);
        jp3.add(L70);
        cardPanel.add(jp1, "1");

        cardPanel.add(jp2, "2");

        cardPanel.add(jp3, "3");
        cardPanel.setBounds(15, 30, 1440, 1024);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(53, 88, 154));

        JButton addbtn = new JButton("new drug");
        addbtn.setBounds(750, 250, 100, 30);
        addbtn.setBackground(Color.LIGHT_GRAY);
        addbtn.setFocusable(false);
        addbtn.setBorderPainted(true);

        JButton deletebtn = new JButton("delete drug");
        deletebtn.setBounds(750, 250, 200, 30);
        deletebtn.setBackground(Color.LIGHT_GRAY);
        deletebtn.setFocusable(false);
        deletebtn.setBorderPainted(true);

        JButton updatebtn = new JButton("update drug");
        updatebtn.setBounds(750, 250, 100, 30);
        updatebtn.setBackground(Color.LIGHT_GRAY);
        updatebtn.setFocusable(false);
        updatebtn.setBorderPainted(true);

        buttonPanel.add(addbtn);

        buttonPanel.add(deletebtn);

        buttonPanel.add(updatebtn);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // setUndecorated(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                currentCard = 1;

                cl.show(cardPanel, "" + (currentCard));

            }
        });

        deletebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                currentCard = 2;

                cl.show(cardPanel, "" + (currentCard));

            }
        });

        updatebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                currentCard = 3;

                cl.show(cardPanel, "" + (currentCard));

            }
        });

        getContentPane().add(cardPanel, null);

        getContentPane().add(buttonPanel, null);
    }

    private class Handler implements ActionListener {
        ResultSet rs;

        public void actionPerformed(ActionEvent event) {
            // add button
            if (event.getSource() == b1) {
                db.addDrug(medname.getText(), disease.getText(), price.getText(), expdate.getText(),
                        quantity.getText());
                dispose();
                new startpage();

            }
            // search button
            if (event.getSource() == b3) {
                if (db.checkdrug(name1.getText())) {
                    rs = db.retriveDrug(name1.getText());
                    try {
                        while (rs.next()) {
                            L7.setText(L7.getText() + "  " + rs.getString("name"));
                            L8.setText(L8.getText() + "  " + rs.getInt("price"));
                            L9.setText(L9.getText() + "  " + rs.getString("date"));
                            L10.setText(L10.getText() + "  " + rs.getString("disease"));
                        }
                        L7.setVisible(true);
                        L8.setVisible(true);
                        L9.setVisible(true);
                        L10.setVisible(true);
                        b4.setVisible(true);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "NOT FOUND", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
            // delete button
            if (event.getSource() == b2) {
                JOptionPane.showMessageDialog(null, "deleted successfully");
                db.deleteDrug(name1.getText());
                L7.setVisible(false);
                L8.setVisible(false);
                L9.setVisible(false);
                L10.setVisible(false);
                b4.setVisible(false);
                L7.setText("Medcine name : ");
                L8.setText("Medcine price  : ");
                L9.setText("Medcine expire : ");
                L10.setText("disease        : ");
                dispose();
                new startpage();

            }
            // cancel button
            if (event.getSource() == b4) {
                dispose();
                new startpage();

            }
            // ignore button
            if (event.getSource() == b6) {
                dispose();
                new startpage();

            }
            // search button
            if (event.getSource() == bb) {
                if (db.checkdrug(name2.getText())) {
                    rs = db.retriveDrug(name2.getText());
                    try {
                        while (rs.next()) {
                            medname1.setText(rs.getString("name"));
                            disease1.setText(rs.getString("disease"));
                            expdate1.setText(rs.getString("date"));
                            quantity1.setText(rs.getString("QTY"));
                            price1.setText(rs.getString("price"));
                            medname1.setVisible(true);
                            L111.setVisible(true);
                            disease1.setVisible(true);
                            L21.setVisible(true);
                            crtdate1.setVisible(false);
                            expdate1.setVisible(true);
                            quantity1.setVisible(true);
                            price1.setVisible(true);
                            L41.setVisible(true);
                            L51.setVisible(true);
                            L61.setVisible(false);
                            L31.setVisible(true);
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            // cancel button
            if (event.getSource() == b61) {
                dispose();
                new startpage();

            }
            // submit button
            if (event.getSource() == b11) {
                db.changeDrug(name2.getText(), medname1.getText(), disease1.getText(), expdate1.getText(),
                        quantity1.getText(), price1.getText());
                dispose();
                new startpage();

            }
        }

    }
}