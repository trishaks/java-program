package Program1;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ImageButtonExample {
	

	    JLabel label;

	    ImageButtonExample() {
	        JFrame frame = new JFrame("Image Button Example");
	        frame.setSize(600, 400);
	        frame.setLayout(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Label to display messages
	        label = new JLabel("");
	        label.setBounds(50, 50, 500, 100);
	        label.setFont(new Font("Arial", Font.BOLD, 24));
	        frame.add(label);

	        // Image icons
	        ImageIcon digitalIcon = new ImageIcon("digital_clock.png"); // Replace with actual image path
	        ImageIcon hourGlassIcon = new ImageIcon("hourglass.png");   // Replace with actual image path

	        // Buttons with images
	        JButton digitalClockButton = new JButton(digitalIcon);
	        digitalClockButton.setBounds(100, 200, 100, 100);
	        digitalClockButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                label.setText("Digital Clock is pressed");
	            }
	        });

	        JButton hourGlassButton = new JButton(hourGlassIcon);
	        hourGlassButton.setBounds(300, 200, 100, 100);
	        hourGlassButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                label.setText("Hour Glass is pressed");
	            }
	        });

	        frame.add(digitalClockButton);
	        frame.add(hourGlassButton);
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        new ImageButtonExample();
	    }
	}

