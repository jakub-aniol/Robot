package GUI;

import Robot.FileBuffer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
	static final String bookStoreList[] = { "Legimi" };
	JComboBox bookStoreComboBox;
	JButton applyButton = new JButton("Apply");
	JTextArea txtLog = new JTextArea();

	final static int maxGap = 5;
	GridLayout experimentLayout = new GridLayout(0, 2);

	public GUI(String name) {
		super(name);
		setResizable(true);
	}

	public void initBookstores() {
		bookStoreComboBox = new JComboBox(bookStoreList);

	}

	public void addComponentsToPane(final Container pane) {
		initBookstores();
		final JPanel Robot = new JPanel();
		Robot.setLayout(experimentLayout);
		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(2, 3));

		// Set up components preferred size
		JButton b = new JButton("Just fake button");
		Dimension buttonSize = b.getPreferredSize();
		Robot.setPreferredSize(new Dimension((int) (buttonSize.getWidth() * 1.5) + maxGap,
				(int) (buttonSize.getHeight() * 1.5) + maxGap * 2));

		// Add buttons to experiment with Grid Layout
		Robot.add(new JButton("Show"));

		// Add TextArea
		txtLog.setLineWrap(true);
		txtLog.setText(FileBuffer.OpenLogFile("logingRobot2.log"));
		
		Robot.add(txtLog, BorderLayout.EAST);

		controls.add(new Label("Bookstore List:"));
		controls.add(new Label(" "));
		controls.add(bookStoreComboBox);

		// Process the Apply gaps button press
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get the horizontal gap value
				String bookStore = (String) bookStoreComboBox.getSelectedItem();
				// Set up the horizontal gap value
				experimentLayout.setHgap(Integer.parseInt(bookStore));
				// Set up the layout of the buttons
				experimentLayout.layoutContainer(Robot);
			}
		});
		pane.add(Robot, BorderLayout.SOUTH);
		pane.add(new JSeparator(), BorderLayout.CENTER);
		pane.add(controls, BorderLayout.NORTH);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		GUI frame = new GUI("ROBOT");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set up the content pane.
		frame.addComponentsToPane(frame.getContentPane());
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		/* Use an appropriate Look and Feel */
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		/* Turn off metal's use of bold fonts */
		UIManager.put("swing.boldMetal", Boolean.FALSE);

		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}