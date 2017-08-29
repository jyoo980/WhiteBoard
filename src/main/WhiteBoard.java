package main;

import gui.DrawZone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WhiteBoard {

    /* These are the buttons which we'll use to toggle our colours/delete */
    private static JButton clearButton, redButton, blackButton, magentaButton, greenButton, blueButton;
    /* The drawing pane we'll use */
    private DrawZone whiteBoard;

    private ActionListener actionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object actn = e.getSource();
            if (actn == clearButton) {
                whiteBoard.clear();
            } else if (actn == redButton) {
                whiteBoard.red();
            } else if (actn == blackButton) {
                whiteBoard.black();
            } else if (actn == magentaButton) {
                whiteBoard.magenta();
            } else if (actn == greenButton) {
                whiteBoard.green();
            } else if (actn == blueButton) {
                whiteBoard.blue();
            }
        }
    };

    private void draw() {
        /* We declare and instantiate our WhiteBoard here */
        JFrame frame = new JFrame("WhiteBoard");
        Container content = frame.getContentPane();
        /* We set the layout on our content frame */
        content.setLayout(new BorderLayout());

        /* Here's where we create our DrawArea */
        whiteBoard = new DrawZone();
        content.add(whiteBoard, BorderLayout.CENTER);
        JPanel controls = new JPanel();

        clearButton = new JButton("Clear");
        clearButton.addActionListener(actionListener);
        redButton = new JButton("Red");
        redButton.addActionListener(actionListener);
        blackButton = new JButton("Black");
        blackButton.addActionListener(actionListener);
        magentaButton = new JButton("Magenta");
        magentaButton.addActionListener(actionListener);
        greenButton = new JButton("Green");
        greenButton.addActionListener(actionListener);
        blueButton = new JButton("Blue");
        blueButton.addActionListener(actionListener);

        /* The following lines of code add all the buttons to the controls panel */
        controls.add(clearButton);
        controls.add(redButton);
        controls.add(blackButton);
        controls.add(magentaButton);
        controls.add(greenButton);
        controls.add(blueButton);

        /* We now add the controls panel to the JFrame, at the bottom of the frame, like where
        * markers would be on an actual whiteboard */
        content.add(controls, BorderLayout.SOUTH);

        /* Sets the size of the frame, 1000 X 900 */
        frame.setSize(1000, 900);
        /* Exits on the close of the window */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WhiteBoard().draw();
    }


}
