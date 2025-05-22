//4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour
//Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is
//pressed by implementing the event handling mechanism with addActionListener( ).

package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Button Demo");
        JLabel label = new JLabel("Press an image button", JLabel.CENTER);

        // Load icons (place these images in the working directory or provide path)
        ImageIcon digitalIcon = new ImageIcon("C:\\Users\\Varun\\Downloads\\digital.jpg");

        ImageIcon hourglassIcon = new ImageIcon("C:\\Users\\Varun\\Downloads\\hourglass.jpg");


        JButton btnDigital = new JButton("Digital Clock", digitalIcon);
        JButton btnHourGlass = new JButton("Hour Glass", hourglassIcon);

        btnDigital.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        btnHourGlass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        frame.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnDigital);
        buttonPanel.add(btnHourGlass);

        frame.add(label, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
