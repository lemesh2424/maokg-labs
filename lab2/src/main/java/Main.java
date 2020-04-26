import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.GradientPaint;
import java.awt.BasicStroke;
import java.awt.AlphaComposite;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener {
    Timer timer;
    private float alpha = 1;
    private float delta = 0.01f;

    private double dx = 1;
    private double tx = 0;
    private double dy = 1;
    private double ty = 0;
    private static int maxWidth;
    private static int maxHeight;

    private static final int imageHeight = 190;
    private static final int imageWidth = 200;

    private static final double[][] flowerPoints = {
            {80.0, 0.0},
            {100.0, 85.0},
            {120.0, 10.0},
            {200.0, 40.0},
            {170.0,  110.0},
            {100.0, 85.0},
            {150.0, 140.0},
            {90.0, 190.0},
            {40.0, 130.0},
            {100.0, 85.0},
            {25.0, 100.0},
            {0.0, 20.0},
            {80.0, 0.0}
    };

    private static final double[][] flowerCenterPoints = {
            {-50.0, -50.0},
            {50.0, -30.0},
            {-5.0, 47.0},
            {-50.0, -50.0}
    };

    public Main() {
        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setBackground(new Color(127, 145, 150));
        g2d.clearRect(0, 0, maxWidth, maxHeight);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.translate(maxWidth / 4, maxHeight / 2);
        paintImage(g2d);
        g2d.translate(-maxWidth / 4, -maxHeight / 2);

        BasicStroke bs1 = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        g2d.setStroke(bs1);
        g2d.drawRect(maxWidth/2, 0,maxWidth / 2 - 1, maxHeight - 1);
        g2d.setStroke(new BasicStroke());
        g2d.translate(maxWidth * 3/4, maxHeight / 2);

        g2d.translate(tx, ty);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        paintImage(g2d);
    }

    private void paintImage(Graphics2D g2d) {
        int startCanvasX = -imageWidth / 2;
        int startCanvasY = -imageHeight / 2;

        GeneralPath flower = new GeneralPath();
        GradientPaint gradient = new GradientPaint(0, 0, new Color(185, 43, 39),
                0, 140, new Color(21, 101, 192));
        g2d.setPaint(gradient);
        flower.moveTo(startCanvasX + flowerPoints[0][0], startCanvasY + flowerPoints[0][1]);
        for (int k = 1; k < flowerPoints.length; k++) {
            flower.lineTo(startCanvasX + flowerPoints[k][0], startCanvasY + flowerPoints[k][1]);
        }
        flower.closePath();
        g2d.fill(flower);

        g2d.setColor(new Color(128, 0, 128));
        g2d.setStroke(new BasicStroke(4f));
        g2d.draw(new Line2D.Double(flowerCenterPoints[0][0], flowerCenterPoints[0][1],
                flowerCenterPoints[1][0], flowerCenterPoints[1][1]));
        g2d.draw(new Line2D.Double(flowerCenterPoints[1][0], flowerCenterPoints[1][1],
                flowerCenterPoints[2][0], flowerCenterPoints[2][1]));
        g2d.draw(new Line2D.Double(flowerCenterPoints[2][0], flowerCenterPoints[2][1],
                flowerCenterPoints[3][0], flowerCenterPoints[3][1]));

        g2d.setColor(Color.BLACK);
        g2d.fillOval(startCanvasX + 95, startCanvasY + 80, 10,10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Main());
        frame.setVisible(true);
        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    @SuppressWarnings("all")
    public void actionPerformed(ActionEvent e) {
        if (alpha < 0.01f || alpha > 0.99f) {
            delta = -delta;
        }

        double minTx = -maxWidth / 4 + imageWidth / 2;
        double minTy = -maxHeight / 2 + imageHeight / 2;
        double maxTx = maxWidth / 4 - imageWidth / 2;
        double maxTy = maxHeight / 2 - imageHeight / 2;

        dy = 0;
        dx = 0;

        if (tx < maxTx || ty <= minTy) {
            dy = 0;
            dx = 1;
        }

        if (tx >= maxTx) {
            dy = 1;
            dx = 0;
        }

        if (ty >= maxTy) {
            dx = -1;
            dy = 0;
        }

        if (tx <= minTx && ty > minTy) {
            dx = 0;
            dy = -1;
        }

        tx += dx;
        ty += dy;

        alpha += delta;

        repaint();
    }
}
