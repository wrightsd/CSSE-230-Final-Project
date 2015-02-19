import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class infoPage {
               private JFrame infoFrame;
               private JPanel textPanel;

               class MyAdjustmentListener implements AdjustmentListener {
                              @SuppressWarnings("deprecation")
                              @Override
                              public void adjustmentValueChanged(AdjustmentEvent e) {
                                             textPanel.move(0,-e.getValue());
                              }
               }

               public infoPage() {
                              infoFrame = new JFrame("Location Information");
                              infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                              infoFrame.setSize(new Dimension(400, 800));
                              infoFrame.setLayout(new BorderLayout());
                              textPanel = new JPanel();
                              textPanel.setLayout(new BoxLayout(textPanel, 1));
                              File textFile = new File("Info Text");
                              try {
                                             Scanner input = new Scanner(textFile);
                                             while (input.hasNextLine()) {
                                                            textPanel.add(new JLabel(input.nextLine()));
                                             }
                              } catch (FileNotFoundException e) {
                                             e.printStackTrace();
                              }
                              JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL, 0, 20, 0,
                                                            100);
                              scrollBar.addAdjustmentListener(new MyAdjustmentListener());
                              infoFrame.add(scrollBar, BorderLayout.EAST);

                              infoFrame.add(textPanel);
                              infoFrame.setVisible(true);
               }
}


