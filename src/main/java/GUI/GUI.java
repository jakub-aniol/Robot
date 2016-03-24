package GUI;

import Robot.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {

	private JButton buttonSelect = new JButton("Select");
	private JButton buttonRemove = new JButton("Remove");
	
	public GUI() {
		super("ROBOT");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		String[] bookStores = new String[] { "LEGIMI", "UPOLUJ EBOOKA" };

		// create a combo box with items specified in the String array:
		final JComboBox<String> bookStoreList = new JComboBox<String>(bookStores);

		// customize some appearance:
		bookStoreList.setForeground(Color.BLACK);
		bookStoreList.setFont(new Font("Arial", Font.BOLD, 14));
		bookStoreList.setMaximumRowCount(10);

		// make the combo box editable so we can add new item when needed
		bookStoreList.setEditable(true);

		// add an event listener for the combo box
		bookStoreList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				String selectedBookstore = (String) combo.getSelectedItem();

				DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();

				int selectedIndex = model.getIndexOf(selectedBookstore);
				if (selectedIndex < 0) {
					// if the selected book does not exist before,
					// add it into this combo box
					model.addElement(selectedBookstore);
				}

			}
		});

		// add event listener for the button Select
		buttonSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedBookstore = (String) bookStoreList.getSelectedItem();
				if (selectedBookstore.equals(bookStores[0])) {
					JOptionPane.showMessageDialog(GUI.this, FileReaderToSwing.OpenLogFile("logingRobot.log", "Legimi"));
				}
				if (selectedBookstore.equals(bookStores[1])) {
					JOptionPane.showMessageDialog(GUI.this, FileReaderToSwing.OpenLogFile("logingRobot.log", "Upolujebooka"));
				}
			}
		});

		// add event listener for the button Remove
		buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedBookstore = (String) bookStoreList.getSelectedItem();
				bookStoreList.removeItem(selectedBookstore);
			}			
			
			
		});

		// add components to this frame
		add(bookStoreList);
		add(buttonSelect);
		//add(buttonRemove);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void run() {
		new GUI().setVisible(true);
	}
	
}