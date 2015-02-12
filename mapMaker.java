
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class mapMaker extends JComponent{
	public JFrame frame;
	public String initialLocation;
	public String finalLocation;
	public String character;
	public String distanceOrTime;
	public String costInput;
	
	public mapMaker(JFrame frame) {
		this.frame = frame;
		ImageIcon map = new ImageIcon("middle-earth-map.jpg");
		JLabel mapLabel = new JLabel(map);
		mapLabel.setMaximumSize(new Dimension(30,20));
		this.frame.add(mapLabel, BorderLayout.CENTER);

		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BoxLayout(userPanel,1));
		
		for (int i = 0; i < 4; i++) {
			userPanel.add(new JLabel(" "));
		}

		userPanel.add(new JLabel("Initial Location"));
		String[] places = { "Helm's Deep", "Mordor", "Rivendell", "Dale" };
		JComboBox initialPlaces = new JComboBox(places);
		initialPlaces.setMaximumSize(new Dimension(210, 20));
		userPanel.add(initialPlaces);

		userPanel.add(new JLabel(" "));

		userPanel.add(new JLabel("Character"));
		String[] characters = { "Gandalf", "Frodo", "Sam" };
		JComboBox characterList = new JComboBox(characters);
		characterList.setMaximumSize(new Dimension(210, 20));
		userPanel.add(characterList);

		userPanel.add(new JLabel(" "));

		userPanel.add(new JLabel("Distance or Time  "));
		JRadioButton distanceButton = new JRadioButton("Distance");
		// actionlistener of distanceButton
		distanceButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				distanceOrTime = "Distance";
				System.out.println(distanceOrTime);
			}
		});
		JRadioButton timeButton = new JRadioButton("Time");
		// actionlistener of timeButton
		timeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				distanceOrTime = "Time";
				System.out.println(distanceOrTime);
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(timeButton);
		group.add(distanceButton);
		userPanel.add(timeButton);
		userPanel.add(distanceButton);
		JTextField textInput = new JTextField(20);
		textInput.setMaximumSize(new Dimension(210,20));
		userPanel.add(new JLabel("Enter Integer Value"));
		userPanel.add(textInput);

		userPanel.add(new JLabel(" "));

		userPanel.add(new JLabel("Final Location"));
		String[] finalPlaces = { "Helm's Deep", "Mordor" };
		JComboBox finalPlacesList = new JComboBox(finalPlaces);
		finalPlacesList.setMaximumSize(new Dimension(210, 20));
		userPanel.add(finalPlacesList);

		for (int i = 0; i < 14; i++) {
			userPanel.add(new JLabel(" "));
		}
		
		JButton moveButton = new JButton("Move");
		// actionlistener of moveButton
		moveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				costInput = textInput.getText();
				initialLocation = (String) initialPlaces.getSelectedItem();
				finalLocation = (String) finalPlacesList.getSelectedItem();
				character = (String) characterList.getSelectedItem();
				
//				System.out.println(initialLocation);
//				System.out.println(finalLocation);
//				System.out.println(character);
				System.out.println("Moved!");	
			}
		});
		userPanel.add(moveButton);
		userPanel.add(new JLabel(" "));
		JButton resetButton = new JButton("Reset");
		// actionlistener of resetButton
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				initialLocation = null;
				finalLocation = null;
				distanceOrTime = null;
				character = null;
				costInput = null;
				finalPlacesList.setSelectedIndex(0);
				initialPlaces.setSelectedIndex(0);
				characterList.setSelectedIndex(0);
				group.clearSelection();
				textInput.setText(null);
			}
			
		});
		userPanel.add(resetButton);
		userPanel.add(new JLabel(" "));
		JButton infoButton = new JButton("Locations Informaion");
		// actionlistener of infoButton
		infoButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String a = "Here should display the related information about the location selected.";
				JOptionPane.showMessageDialog(frame, "<html><body><p style='width: 300px;'>"+a+"</body></html>", 
						"Location Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		userPanel.add(infoButton);

		this.frame.add(userPanel, BorderLayout.EAST);
	}

}