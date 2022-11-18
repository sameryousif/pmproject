import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class packMan extends JFrame implements MouseListener {
    JLabel l1 = new JLabel();

    packMan() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        l1.setBounds(150, 150, 100, 100);
        l1.addMouseListener(this);
        add(l1);
        setVisible(true);
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        g2d.fillRect(0, 0, 600, 600);
        g2d.setPaint(Color.GREEN);
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.fill(new Arc2D.Double(150, 150, 100, 100, 30, 300, Arc2D.PIE));
    }

    public static void main(String[] args) {
        new packMan();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Graphics2D g = (Graphics2D) getGraphics();

        g.setColor(Color.YELLOW);
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_ROUND,
                BasicStroke.CAP_SQUARE, 0, new float[] { 9 }, 0);
        g.setStroke(dashed);
        g.drawLine(210, 200, 300, 200);
        g.drawLine(300, 200, 300, 100);
        g.drawLine(300, 100, 120, 100);
        g.drawLine(120, 100, 120, 280);
        g.drawLine(120, 280, 350, 280);
        g.drawLine(350, 280, 350, 50);
        g.drawLine(350, 50, 50, 50);
        g.drawLine(50, 50, 50, 350);
        g.drawLine(50, 350, 400, 350);
        g.drawLine(400, 350, 400, 150);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}