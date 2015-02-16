
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private Graphics g;
	private Graphics2D g2d;
	private boolean drawMover;
	private Point2D.Double start;
	private Point2D.Double end;
	private Character charac;
	
	public mapMaker(JFrame frame) {
		this.frame = frame;
		this.drawMover = false;
		this.start = null;
		this.end = null;
		this.charac = null;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.g = g;
		this.g2d = (Graphics2D) g;
		File mapfile = new File("middle-earth-map.jpg");
		Image map1 = null;
		try {
			map1 = ImageIO.read(mapfile);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		this.g2d.drawImage(map1, 30, 50, null);
		if (drawMover){
			if (character.equals("Gandalf")){
				this.charac = new Character(start,"Gandalf",new ImageIcon("gandalf.png"));
			}
			if (character.equals("Frodo")){
				this.charac = new Character(start,"Frodo",new ImageIcon("frodo.gif"));
			}
			if (character.equals("Sam")){
				this.charac = new Character(start,"Sam",new ImageIcon("sam.gif"));
			}
			this.charac.drawOn(g2d);
			timePassed();
		}
		
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
				//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				// change the initial start location info and end location info here!
				// obtain the info from the location objects
				start = new Point2D.Double(800,300);
				end = new Point2D.Double(200,550);
				//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				drawMover = true;
				repaint();
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
				drawMover = false;
				repaint();
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
				infoPage newinfo = new infoPage();
			}
			
		});
		userPanel.add(infoButton);

		this.frame.add(userPanel, BorderLayout.EAST);
		
	}
	
	public void timePassed(){
		
			Runnable tickToc = new Runnable(){
				  @Override
				public void run(){
					  try {
							while (true) {
								Thread.sleep(30);								
								charac.updatePosition(end);
								repaint();
							}
						} catch (InterruptedException exception) {
							// Stop when interrupted
						}
				  }
			};
			new Thread(tickToc).start();
	}

}