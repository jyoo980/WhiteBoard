package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * represents the drawing window - our whiteboarding zone
 */

public class DrawZone extends JComponent {

    /* This is the  pane in which we're going to draw our lines/shapes */
    private Image image;
    /* Allows for us to render our 2D shapes and etc.. */
    private Graphics2D g2;
    /* Current and past mouse coordinates */
    private int currentX, currentY, pastX, pastY;

    public DrawZone() {
        setDoubleBuffered(false);

        /**
         *  Captures the x,y - location of an initial MousePress, sets that to the pastX and pastY
         *  Will be the starting point for the line we draw
         */
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                pastX = e.getX();
                pastY = e.getY();

            }
        });

        /**
         * Captures the x,y - location(s) of a MouseDrag, sets that to the currentX and currentY.
         * We then draw the line from the pastX,Y to the currentX,Y - then update the frame and
         *
         */
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    g2.drawLine(pastX, pastY, currentX, currentY);
                    repaint();
                    pastX = currentX;
                    pastY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
            g2 = (Graphics2D) image.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // we then clear gui.DrawZone
            clear();
        }

        g.drawImage(image, 0, 0, null);

    }

    // Public methods below

    /**
     * Clears our drawing pane - fills it with white to clear
     */
    public void clear() {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.white);
        repaint();
    }

    /**
     * Below are methods which set the g2 to their respectively named colours
     */
    public void red() { g2.setPaint(Color.red); }
    public void black() { g2.setPaint(Color.black); }
    public void magenta() { g2.setPaint(Color.magenta); }
    public void green() { g2.setPaint(Color.green); }
    public void blue() { g2.setPaint(Color.blue); }


}
