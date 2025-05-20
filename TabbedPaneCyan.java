package swings;
	import javax.swing.*;
	import java.awt.*;

	public class TabbedPaneCyan extends JFrame{
	    public TabbedPaneCyan() {
	        setTitle("Color Tabbed Pane");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create a JTabbedPane
	        JTabbedPane tabbedPane = new JTabbedPane();

	        // Create panels for each tab with specific background colors
	        JPanel cyanPanel = new JPanel();
	        cyanPanel.setBackground(Color.CYAN);
	        tabbedPane.addTab("Cyan", cyanPanel);

	        JPanel magentaPanel = new JPanel();
	        magentaPanel.setBackground(Color.MAGENTA);
	        tabbedPane.addTab("Magenta", magentaPanel);

	        JPanel yellowPanel = new JPanel();
	        yellowPanel.setBackground(Color.YELLOW);
	        tabbedPane.addTab("Yellow", yellowPanel);

	        // Add the tabbed pane to the frame
	        add(tabbedPane);

	        // Center the window on screen
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        // Run the GUI in the Event Dispatch Thread
	        SwingUtilities.invokeLater(() -> new TabbedPaneCyan());
	    }
	}


