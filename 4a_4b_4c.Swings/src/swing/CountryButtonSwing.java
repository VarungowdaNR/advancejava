
//
//4b. Develop a Swing program in Java to display a message “Srilanka is pressed” or “India is
//pressed” depending upon the Jbutton either Srilanka or India is pressed by implementing the
//event handling mechanism with addActionListener( ).
package swing;


import javax.swing.*;

public class CountryButtonSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Country Button");
        JButton btnIndia = new JButton("India");
        JButton btnSrilanka = new JButton("Srilanka");
        JLabel label = new JLabel("Press a button");

        btnIndia.addActionListener(e -> label.setText("India is pressed"));
        btnSrilanka.addActionListener(e -> label.setText("Srilanka is pressed"));

        JPanel panel = new JPanel();
        panel.add(btnIndia);
        panel.add(btnSrilanka);
        panel.add(label);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
