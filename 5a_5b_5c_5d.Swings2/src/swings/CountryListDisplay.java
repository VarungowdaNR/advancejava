//5a. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada,
//Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and
//display them on console whenever the countries are selected on the list.


package swings;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryListDisplay {
 public static void main(String[] args) {
     JFrame frame = new JFrame("Country List");
     String[] countries = {
         "USA", "India", "Vietnam", "Canada", "Denmark",
         "France", "Great Britain", "Japan", "Africa", "Greenland", "Singapore"
     };

     JList<String> countryList = new JList<>(countries);
     countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

     countryList.addListSelectionListener(new ListSelectionListener() {
         public void valueChanged(ListSelectionEvent e) {
             if (!e.getValueIsAdjusting()) {
                 java.util.List<String> selected = countryList.getSelectedValuesList();
                 for (String c : selected) {
                     System.out.println("Selected country: " + c);
                 }
             }
         }
     });

     frame.add(new JScrollPane(countryList));
     frame.setSize(300, 300);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
 }
}
