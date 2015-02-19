import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class infoPage {
	private JFrame infoFrame;
	// private JTextArea textPanel;// was JPANEL
	private JPanel textPanel;
	private int currentPosition;
	private ArrayList<JLabel> labels;

	class MyAdjustmentListener implements AdjustmentListener {
		@Override
		public void adjustmentValueChanged(AdjustmentEvent e) {
			currentPosition = e.getValue();
			if (currentPosition < 0)
				currentPosition = 0;
			if (currentPosition > labels.size()*labels.get(1).getHeight())
				currentPosition = labels.size() * labels.get(1).getHeight();
			redraw();
		}
	}

	private void redraw() {
		textPanel.removeAll();
		for (int i = currentPosition; i < currentPosition + 60; i++) {
			if (i <= labels.size()-1) {
				textPanel.add(labels.get(i));
			}
		}
		textPanel.updateUI();
	}

	public infoPage() {
		currentPosition = 0;
		infoFrame = new JFrame("Location Information");
		infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		infoFrame.setSize(new Dimension(620, 1000));
		textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		File textFile = new File("Info Text");
		labels = new ArrayList<JLabel>();
		try {
			Scanner input = new Scanner(textFile);
			while (input.hasNextLine()) {
				labels.add(new JLabel(input.nextLine()));
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 50, 0,
				labels.size());
		scrollBar.addAdjustmentListener(new MyAdjustmentListener());
		infoFrame.add(scrollBar, BorderLayout.EAST);
		infoFrame.add(textPanel);
		redraw();
		infoFrame.setVisible(true);
	}

}