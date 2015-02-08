import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class mapMaker {
	public JFrame frame;

	public mapMaker(JFrame frame) {
		this.frame = frame;
		ImageIcon map = new ImageIcon("Images\\middle-earth-map.jpg");
		JLabel mapLabel = new JLabel(map);
		mapLabel.setMaximumSize(new Dimension(30,20));
		this.frame.add(mapLabel, BorderLayout.CENTER);

		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BoxLayout(userPanel, 1));
		
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
		JRadioButton timeButton = new JRadioButton("Time");
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
		userPanel.add(moveButton);
		userPanel.add(new JLabel(" "));
		JButton resetButton = new JButton("Reset");
		userPanel.add(resetButton);
		userPanel.add(new JLabel(" "));
		JButton infoButton = new JButton("Locations Informaion");
		userPanel.add(infoButton);

		this.frame.add(userPanel, BorderLayout.EAST);
	}

}
