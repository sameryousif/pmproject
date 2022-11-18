import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logs extends JFrame {
    JButton b = new JButton("Done");
    connnection db = new connnection();

    logs() {
        super("");
        setBackground(Color.LIGHT_GRAY);
        ResultSet rs = db.returnDrugsTable();
        String data[][] = new String[new connnection().getlength("drugs")][5];
        try {
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("disease");
                data[i][2] = rs.getString("date");
                data[i][3] = rs.getString("price");
                data[i][4] = rs.getString("QTY");
                i++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String column[] = { "Medcine", "disease", "date", "price", "QTY" };
        JTable jt = new JTable(data, column);
        jt.setBounds(100, 100, 200, 800);
        jt.setBackground(Color.LIGHT_GRAY);
        JScrollPane sp = new JScrollPane(jt);

        b.setBounds(600, 600, 80, 40);
        b.setBorderPainted(false);
        b.setFocusable(false);
        b.setBackground(new Color(53, 88, 154));
        Handler h = new Handler();
        b.addActionListener(h);
        add(b);
        add(sp);
        // setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class Handler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == b) {
                dispose();
                new startpage();
            }
        }
    }

}
