
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
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

<<<<<<< HEAD
=======
/**
 * 
 * This class builds up our map for the navigation system
 *
 * @author kongw.
 *         Created Feb 19, 2015.
 */

>>>>>>> origin/wenjun
public class mapMaker extends JComponent{
	public JFrame frame;
	public String initialLocation;
	public String finalLocation;
	public String character;
	public String[] characterNames;
	public String distanceOrTime;
	public String costInput;
<<<<<<< HEAD
	private Graphics g;
	private Graphics2D g2d;
	private boolean drawMover;
	private Point2D.Double start;
	private Point2D.Double end;
=======
	private Graphics2D g2d;
	private boolean drawMover;
>>>>>>> origin/wenjun
	private ArrayList<Point2D.Double> nodes;
	private Character charac;
	private HashMap<String, Character> characters;
	private boolean reset;
	private Thread tic;
	private GPS gps;
	private String[] locations;
	
<<<<<<< HEAD
	public mapMaker(JFrame frame) {
		this.frame = frame;
		this.drawMover = false;
		this.start = null;
		this.end = null;
		this.charac = null;
		this.nodes = new ArrayList<Point2D.Double>();
		this.characters = new HashMap<String, Character>();
=======
	/**
	 * 
	 * Initialize all the fields in the constructor
	 *
	 * @param frame
	 */
	public mapMaker(JFrame frame) {
		this.frame = frame;
		this.drawMover = false;
		this.charac = null;
		this.nodes = new ArrayList<>();
		this.characters = new HashMap<>();
>>>>>>> origin/wenjun
		this.characterNames = new String[11];
		this.reset = false;
		this.tic = null;
		this.gps = new GPS();
		initLocations();
	}
	
<<<<<<< HEAD
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.g = g;
=======
	/**
	 * Paint all the components
	 * Created all possible user buttons and action listeners
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
>>>>>>> origin/wenjun
		this.g2d = (Graphics2D) g;
		File mapfile = new File("middle-earth-map.jpg");
		Image map1 = null;
		try {
			map1 = ImageIO.read(mapfile);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		this.g2d.drawImage(map1, 20, 30,840,640, null);
<<<<<<< HEAD
		if (nodes.size() != 0 && drawMover){
			System.out.print("x");
			this.charac = characters.get(character);
			Point2D.Double ctpt = new Point2D.Double(nodes.get(0).x,nodes.get(0).y);
			this.charac.setCtPt(ctpt);
			this.charac.drawOn(g2d);
			drawPath();
			timePassed();
		}
		if (nodes.size() != 0 && charac != null){
			this.charac.drawOn(g2d);
			drawPath();
=======
		
		// if drawMover is true, then draw the mover and path and let it move
		if (this.nodes.size() != 0 && this.drawMover){
			System.out.print("x");
			this.charac = this.characters.get(this.character);
			Point2D.Double ctpt = new Point2D.Double(this.nodes.get(0).x,this.nodes.get(0).y);
			this.charac.setCtPt(ctpt);
			this.charac.drawOn(this.g2d);
			drawPath();
			timePassed();
		}
		// if "move" button is clicked, and timepassed() is already running, keep
		// the path on the canvas and keep running the thread
		if (this.nodes.size() != 0 && this.charac != null){
			drawPath();
			this.charac.drawOn(this.g2d);
>>>>>>> origin/wenjun
		}
		
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new BoxLayout(userPanel,1));
		
		for (int i = 0; i < 4; i++) {
			userPanel.add(new JLabel(" "));
		}

		userPanel.add(new JLabel("Initial Location"));
		JComboBox initialPlaces = new JComboBox(this.locations);
		initialPlaces.setMaximumSize(new Dimension(210, 20));
		userPanel.add(initialPlaces);

		userPanel.add(new JLabel(" "));

		userPanel.add(new JLabel("Character"));
		String[] characters = { "Aragorn", "Balrog", "Frodo", "Galadriel", "Gandalf", "Gimli"
				, "lego gollum", "Legolas","nazgul","orc","Sam"};
		for (int i = 0; i < characters.length; i++){
<<<<<<< HEAD
			characterNames[i] = characters[i];
=======
			this.characterNames[i] = characters[i];
>>>>>>> origin/wenjun
		}
		createCharacters();
		JComboBox characterList = new JComboBox(characters);
		characterList.setMaximumSize(new Dimension(210, 20));
		userPanel.add(characterList);

		userPanel.add(new JLabel(" "));

		userPanel.add(new JLabel("Distance or Time"));
		JRadioButton distanceButton = new JRadioButton("Distance");
<<<<<<< HEAD
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
=======
		
		// create actionlistener of distanceButton and 
		// set up the field
		distanceButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mapMaker.this.distanceOrTime = "Distance";
			}
		});
		JRadioButton timeButton = new JRadioButton("Time");
		
		// create actionlistener of timeButton and set up the field
		timeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mapMaker.this.distanceOrTime = "Time";
				System.out.println(mapMaker.this.distanceOrTime);
>>>>>>> origin/wenjun
			}
		});
		ButtonGroup group = new ButtonGroup();
		group.add(timeButton);
		group.add(distanceButton);
		userPanel.add(timeButton);
		userPanel.add(distanceButton);
<<<<<<< HEAD
//		Checkbox cbox = new Checkbox("Specific Restrictions",false);
//		userPanel.add(cbox);
=======
>>>>>>> origin/wenjun
		JTextField textInput = new JTextField(20);
		JLabel label1 = new JLabel("Enter Integer Value");
		textInput.setMaximumSize(new Dimension(210,20));
		userPanel.add(label1);
		userPanel.add(textInput);

		userPanel.add(new JLabel(" "));

		userPanel.add(new JLabel("Final Location"));
		JComboBox finalPlacesList = new JComboBox(this.locations);
		finalPlacesList.setMaximumSize(new Dimension(210, 20));
		userPanel.add(finalPlacesList);

		for (int i = 0; i < 14; i++) {
			userPanel.add(new JLabel(" "));
		}
		
		JButton moveButton = new JButton("Move");
<<<<<<< HEAD
		// actionlistener of moveButton
		moveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				costInput = textInput.getText();
				initialLocation = (String) initialPlaces.getSelectedItem();
				finalLocation = (String) finalPlacesList.getSelectedItem();
				character = (String) characterList.getSelectedItem();
				findPath();
				reset = false;
				drawMover = true;
=======
		
		// create actionlistener of moveButton
		// set drawMover to be true and find the path as the input suggested
		moveButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mapMaker.this.costInput = textInput.getText();
				mapMaker.this.initialLocation = (String) initialPlaces.getSelectedItem();
				mapMaker.this.finalLocation = (String) finalPlacesList.getSelectedItem();
				mapMaker.this.character = (String) characterList.getSelectedItem();
				findPath();
				mapMaker.this.reset = false;
				mapMaker.this.drawMover = true;
>>>>>>> origin/wenjun
				repaint();
				System.out.println("Moved!");	
			}
		});
		userPanel.add(moveButton);
		userPanel.add(new JLabel(" "));
		JButton resetButton = new JButton("Reset");
<<<<<<< HEAD
		// actionlistener of resetButton
=======
		
		// create actionlistener of resetButton
		// reset everything
>>>>>>> origin/wenjun
		resetButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				
=======
				mapMaker.this.costInput = null;
				mapMaker.this.initialLocation = null;
				mapMaker.this.finalLocation = null;
				mapMaker.this.character = null;
				finalPlacesList.setSelectedIndex(0);
				initialPlaces.setSelectedIndex(0);
				characterList.setSelectedIndex(0);
				group.clearSelection();
				mapMaker.this.reset = true;
				mapMaker.this.drawMover = false;
				mapMaker.this.nodes = new ArrayList<>();
>>>>>>> origin/wenjun
				repaint();
				
			}
			
		});
		userPanel.add(resetButton);
		userPanel.add(new JLabel(" "));
		JButton infoButton = new JButton("Locations Informaion");
<<<<<<< HEAD
		// actionlistener of infoButton
=======
		
		// create actionlistener of infoButton
		// draw a pop up window for information of the locations
>>>>>>> origin/wenjun
		infoButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
//				JTextArea textArea = new JTextArea(6, 25);
//				File fl = new File("Info Text");
//				String a = new String(Files.readAllBytes("C:/EclipseWorkspaces/csse230/The FellowShip of the Tree/Info Text"));
//			      textArea;
//			      textArea.setEditable(false);
//			       
//			      // wrap a scrollpane around it
//			      JScrollPane scrollPane = new JScrollPane(textArea);
//			       
//			      // display them in a message dialog
//			      JOptionPane.showMessageDialog(frame, scrollPane);
=======
				new infoPage();
>>>>>>> origin/wenjun
			}
			
		});
		userPanel.add(infoButton);
<<<<<<< HEAD

=======
		
		// add the panel to the frame
>>>>>>> origin/wenjun
		this.frame.add(userPanel, BorderLayout.EAST);
		
	}
	
<<<<<<< HEAD
=======
	/**
	 * 
	 * This is a method that starts the thread and let the mover move
	 *
	 */
>>>>>>> origin/wenjun
	public void timePassed(){
			Runnable tickToc = new Runnable(){
				  @Override
				public void run(){
					  try {
<<<<<<< HEAD
						  for (int i = 0; i < nodes.size(); i++){
							  Point2D.Double currentDest = nodes.get(i);
							  charac.setEndPoint(currentDest);
							  double diff = Math.sqrt(Math.pow(currentDest.x-charac.centerPoint.x, 2)+Math.pow(currentDest.y-charac.centerPoint.y, 2));
							  while (diff > 0.001) {
								Thread.sleep(30);
								if (charac != null){
									charac.updatePosition();
									diff = Math.sqrt(Math.pow(currentDest.x-charac.centerPoint.x, 2)+Math.pow(currentDest.y-charac.centerPoint.y, 2));
								}
								drawMover = false;
=======
						  for (int i = 1; i < mapMaker.this.nodes.size(); i++){
							  Point2D.Double currentDest = mapMaker.this.nodes.get(i);
							  mapMaker.this.charac.setEndPoint(currentDest);
							  double diff = Math.sqrt(Math.pow(currentDest.x-mapMaker.this.charac.centerPoint.x, 2)+Math.pow(currentDest.y-mapMaker.this.charac.centerPoint.y, 2));
							  while (diff > 0.00000001) {
								Thread.sleep(30);
								if (mapMaker.this.charac != null){
									mapMaker.this.charac.updatePosition();
									diff = Math.sqrt(Math.pow(currentDest.x-mapMaker.this.charac.centerPoint.x, 2)+Math.pow(currentDest.y-mapMaker.this.charac.centerPoint.y, 2));
								}
								mapMaker.this.drawMover = false;
>>>>>>> origin/wenjun
								repaint();
							  }
						  }
						} catch (InterruptedException exception) {
							// Stop when interrupted
						}
				  }
			};
<<<<<<< HEAD
			tic = new Thread(tickToc);
			if (!reset){
				tic.start();
			}
	}
	
=======
			this.tic = new Thread(tickToc);
			if (!this.reset){
				this.tic.start();
			}
	}
	
	/**
	 * 
	 * This method creates all the characters and put it into a hashmap
	 *
	 */
>>>>>>> origin/wenjun
	public void createCharacters(){
		Character charac1 = new Character(null,"Aragorn",new ImageIcon("Aragorn.png"));
		Character charac2 = new Character(null,"Balrog",new ImageIcon("Balrog.png"));
		Character charac3 = new Character(null,"Frodo",new ImageIcon("Frodo.png"));
		Character charac4 = new Character(null,"Galadriel",new ImageIcon("Galadriel.png"));
		Character charac5 = new Character(null,"Gandalf",new ImageIcon("Gandalf.png"));
		Character charac6 = new Character(null,"Gimli",new ImageIcon("Gimli.png"));
		Character charac7 = new Character(null,"lego gollum",new ImageIcon("lego gollum.png"));
		Character charac8 = new Character(null,"Legolas",new ImageIcon("Legolas.png"));
		Character charac9 = new Character(null,"nazgui",new ImageIcon("nazgui.png"));
		Character charac10 = new Character(null,"orc",new ImageIcon("orc.jpg"));
		Character charac11 = new Character(null,"Sam",new ImageIcon("Sam.png"));
		
		Character[] chara = {charac1,charac2,charac3,charac4,charac5,charac6,charac7,charac8,
				charac9,charac10,charac11};
		
<<<<<<< HEAD
		for (int i = 0; i < characterNames.length; i++){
			characters.put(characterNames[i], chara[i]);
		}
	}
	
	public void drawPath(){
		for (int i = 0; i < this.nodes.size(); i++){
			if (i != 0 && i != this.nodes.size()-1){
				Ellipse2D dot = new Ellipse2D.Double(nodes.get(i).x,nodes.get(i).y,10,10);
				g2d.draw(dot);
				g2d.setColor(Color.blue);
				g2d.fill(dot);
			}
			if (i == 0 || i == this.nodes.size()-1){
				Ellipse2D dot = new Ellipse2D.Double(nodes.get(i).x,nodes.get(i).y,10,10);
				g2d.draw(dot);
				g2d.setColor(Color.red);
				g2d.fill(dot);
			}
		}
		
		for (int i = 0; i < nodes.size()-1; i++){
			g2d.setStroke(new BasicStroke(2));
			g2d.setColor(Color.blue);
			g2d.drawLine((int)nodes.get(i).x+5, (int)nodes.get(i).y+5, (int)nodes.get(i+1).x+5, (int)nodes.get(i+1).y+5);
=======
		for (int i = 0; i < this.characterNames.length; i++){
			this.characters.put(this.characterNames[i], chara[i]);
		}
	}
	
	/**
	 * 
	 * This method draws all the path on the canvas and mark the initial and
	 * final location as red.
	 *
	 */
	public void drawPath(){
		for (int i = 0; i < this.nodes.size(); i++){
			if (i != 0 && i != this.nodes.size()-1){
				Ellipse2D dot = new Ellipse2D.Double(this.nodes.get(i).x,this.nodes.get(i).y,10,10);
				this.g2d.draw(dot);
				this.g2d.setColor(Color.blue);
				this.g2d.fill(dot);
			}
			if (i == 0 || i == this.nodes.size()-1){
				Ellipse2D dot = new Ellipse2D.Double(this.nodes.get(i).x,this.nodes.get(i).y,10,10);
				this.g2d.draw(dot);
				this.g2d.setColor(Color.red);
				this.g2d.fill(dot);
			}
		}
		
		for (int i = 0; i < this.nodes.size()-1; i++){
			this.g2d.setStroke(new BasicStroke(2));
			this.g2d.setColor(Color.blue);
			this.g2d.drawLine((int)this.nodes.get(i).x+5, (int)this.nodes.get(i).y+5, (int)this.nodes.get(i+1).x+5, (int)this.nodes.get(i+1).y+5);
>>>>>>> origin/wenjun
		}
		
	}
	
<<<<<<< HEAD
	public void initLocations(){
		ArrayList<String> locs = new ArrayList<String>();
=======
	/**
	 * 
	 * initialize all the locations and store it into an array of strings
	 *
	 */
	public void initLocations(){
		ArrayList<String> locs = new ArrayList<>();
>>>>>>> origin/wenjun
		HashMap<String, Location> temp= this.gps.getList();
		for (String key: temp.keySet()){
			locs.add(key);
		}
		
		this.locations = new String[locs.size()+1];
		this.locations[0] = "None";
		for (int i = 1; i < locs.size()+1; i++){
			this.locations[i] = locs.get(i-1);
		}
	}
	
<<<<<<< HEAD
	public void findPath(){
		ArrayList<Location> route = new ArrayList<Location>();
		if (!initialLocation.equals("None") && !finalLocation.equals("None")){
			if (costInput == null || costInput.length() == 0){
				if (distanceOrTime == null || distanceOrTime.equals("Distance")){
					route = this.gps.findShortestPath(initialLocation, finalLocation);
				}
				else if (distanceOrTime.equals("Time")){
					route = this.gps.findLeastDangerousPath(initialLocation, finalLocation);
				}
				
				for (int i = 0; i < route.size(); i++){
					double x = 4*route.get(i).getGridX()+20;
					double y = 4*route.get(i).getGridY()+30;
					nodes.add(new Point2D.Double(x,y));
				}
			}
			else{
				int costinput = Integer.parseInt(costInput);
			}
		}
		
		else if (initialLocation.equals("None")){
=======
	/**
	 * 
	 * This method call the methods inside the path class and find the most appropriate
	 * path for the mover to move.
	 *
	 */
	public void findPath(){
		ArrayList<Location> route = new ArrayList<>();
		if (!this.initialLocation.equals("None") && !this.finalLocation.equals("None")){
			if (this.costInput == null || this.costInput.length() == 0){
				if (this.distanceOrTime == null || this.distanceOrTime.equals("Distance")){
					this.gps.findShortestPaths(this.initialLocation,Integer.MAX_VALUE);
					route = this.gps.getPath(this.finalLocation);
				}
				else if (this.distanceOrTime.equals("Time")){
					this.gps.findLeastDangerousPaths(this.initialLocation, Integer.MAX_VALUE);
					route = this.gps.getPath(this.finalLocation);
				}
			}
			else{
				int costinput = Integer.parseInt(this.costInput);
				if (this.distanceOrTime.equals("Distance")){
					this.gps.findShortestPaths(this.initialLocation, costinput);
					route = this.gps.getPath(this.finalLocation);
				}
				else if (this.distanceOrTime.equals("Time")){
					this.gps.findLeastDangerousPaths(this.initialLocation, costinput);
					route = this.gps.getPath(this.finalLocation);
				}
				else{
					String infomessage = "You need to specify which one to restrict.";
					JOptionPane.showMessageDialog(this.frame,infomessage,"Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		else if (this.initialLocation.equals("None")){
>>>>>>> origin/wenjun
			String infomessage = "You need to select a initial position to start!";
			JOptionPane.showMessageDialog(this.frame,infomessage,"Error",JOptionPane.INFORMATION_MESSAGE);
			
		}
<<<<<<< HEAD
		else if (finalLocation.equals("None")){
			if (costInput == null || costInput.length() == 0){
				String infomessage = "You need to either select a destination or specify your constraints!";
				JOptionPane.showMessageDialog(this.frame,infomessage,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
		}
=======
		else if (this.finalLocation.equals("None")){
			if (this.costInput == null || this.costInput.length() == 0){
				String infomessage = "You need to either select a destination or specify your constraints!";
				JOptionPane.showMessageDialog(this.frame,infomessage,"Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				if (this.distanceOrTime.equals("Distance")){
					int costinput = Integer.parseInt(this.costInput);
					this.gps.findShortestPaths(this.initialLocation, costinput);
					ArrayList<String> destination = this.gps.getDistanceList();
					String[] possibleDest = new String[destination.size()];
					for (int i = 0; i < destination.size(); i++){
						possibleDest[i] = destination.get(i);
					}
					this.finalLocation = (String)JOptionPane.showInputDialog(this.frame,
		                    "Select Your destination",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibleDest,
		                    possibleDest[0]);
					this.finalLocation = modifyString(this.finalLocation);
					System.out.println(this.finalLocation);
					route = this.gps.getPath(this.finalLocation);
				}
				else if (this.distanceOrTime.equals("Time")){
					int costinput = Integer.parseInt(this.costInput);
					this.gps.findLeastDangerousPaths(this.initialLocation, costinput);
					ArrayList<String> destination = this.gps.getDangerList();
					String[] possibleDest = new String[destination.size()];
					for (int i = 0; i < destination.size(); i++){
						possibleDest[i] = destination.get(i);
					}
					this.finalLocation = (String)JOptionPane.showInputDialog(this.frame,
		                    "Select Your destination",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null,
		                    possibleDest,
		                    possibleDest[0]);
					this.finalLocation = modifyString(this.finalLocation);
					route = this.gps.getPath(this.finalLocation);
				}
				else{
					String infomessage = "You need to specify which one to restrict.";
					JOptionPane.showMessageDialog(this.frame,infomessage,"Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		}
		
		if (route != null){
			for (int i = 0; i < route.size(); i++){
				double x = 4*route.get(i).getGridX()+20;
				double y = 4*route.get(i).getGridY()+30;
				this.nodes.add(new Point2D.Double(x,y));
			}
		}
		else {
			String infomessage = "You cannot travel that far!!!";
			JOptionPane.showMessageDialog(this.frame,infomessage,"Error",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * 
	 * This method chops the latter part of the string where it starts with
	 * a parantheses.
	 *
	 * @param e
	 * @return
	 */
	public String modifyString(String e){
		String ret = "";
		for (int i = 0; i < e.length(); i++){
			if (e.charAt(i) != '('){
				ret+=e.charAt(i);
			}
			else{
				break;
			}
		}
		ret = ret.substring(0,ret.length()-1);
		return ret;
>>>>>>> origin/wenjun
		
	}

}