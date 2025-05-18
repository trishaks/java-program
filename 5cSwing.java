package swings;
import javax.swing.*;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;
	import java.util.HashMap;
	import java.util.Map;
public class CountryCapitalList extends JFrame{
	    private JList<String> countryList;
	    private Map<String, String> capitalMap;

	    public CountryCapitalList() {
	        // Initialize the capital map
	        capitalMap = new HashMap<>();
	        capitalMap.put("USA", "Washington D.C.");
	        capitalMap.put("India", "New Delhi");
	        capitalMap.put("Vietnam", "Hanoi");
	        capitalMap.put("Canada", "Ottawa");
	        capitalMap.put("Denmark", "Copenhagen");
	        capitalMap.put("France", "Paris");
	        capitalMap.put("Great Britain", "London");
	        capitalMap.put("Japan", "Tokyo");
	        capitalMap.put("Africa", "Addis Ababa");
	        capitalMap.put("Greenland", "Nuuk");
	        capitalMap.put("Singapore", "Singapore");

	        // Create the list model and add countries
	        DefaultListModel<String> listModel = new DefaultListModel<>();
	        for (String country : capitalMap.keySet()) {
	            listModel.addElement(country);
	        }

	        // Create the list
	        countryList = new JList<>(listModel);

	        // Add selection listener to the list
	        countryList.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    String selectedCountry = countryList.getSelectedValue();
	                    if (selectedCountry != null) {
	                        String capital = capitalMap.get(selectedCountry);
	                        System.out.println("Capital of " + selectedCountry + " is: " + capital);
	                    }
	                }
	            }
	        });

	        // Add the list to a scroll pane and the frame
	        add(new JScrollPane(countryList));

	        // Set frame properties
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setTitle("Country Capital List");
	        setSize(200, 200);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new CountryCapitalList();
	    }
	}
