//4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing
//Programming in Blue color plain font with font size of 32 using Jframe and Jlabel
package swing;

import javax.swing.*;
import java.awt.*;

public class HelloSwing {
 public static void main(String[] args) {
     JFrame frame = new JFrame("Welcome Message");
     JLabel label = new JLabel("Hello! VI C, Welcome to Swing Programming", JLabel.CENTER);
     
     label.setFont(new Font("Serif", Font.PLAIN, 32));
     label.setForeground(Color.BLUE);
     
     frame.add(label);
     frame.setSize(600, 200);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
 }
}
