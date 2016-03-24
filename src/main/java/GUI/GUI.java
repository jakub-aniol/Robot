package GUI;

import Robot.FileReaderToSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa odpowiedzialna za interfejs użytkownika
 * 
 * @author slawomir
 *
 */

public class GUI extends JFrame {

	private JButton buttonSelect = new JButton("Select");

	public GUI() {
		/**
		 * Ustawienie parametrów interfejsu: Tekst nagłówka, położenie
		 * komponentów
		 */
		super("ROBOT");
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		String[] bookStores = new String[] { "LEGIMI", "UPOLUJ EBOOKA", "28 KSIĄŻEK" };

		/**
		 * Utworzenie komponentu combo box wyświetlającego poszczególne
		 * księgarnie na podstawie tablicy bookStores
		 */

		final JComboBox<String> bookStoreList = new JComboBox<String>(bookStores);

		/**
		 * Ustawienie parametrów wyglądu interfejsu
		 */

		bookStoreList.setForeground(Color.BLACK);
		bookStoreList.setFont(new Font("Arial", Font.BOLD, 14));
		bookStoreList.setMaximumRowCount(10);

		/**
		 * Metody ustawiające zdarzenia dla przycisku "Select" Wyświetlanie
		 * danych log dla danej księgarni
		 */

		buttonSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedBookstore = (String) bookStoreList.getSelectedItem();
				if (selectedBookstore.equals(bookStores[0])) {
					JOptionPane.showMessageDialog(GUI.this,
							FileReaderToSwing.OpenLogFile("logingRobot.log", "Legimi"));
				}
				if (selectedBookstore.equals(bookStores[1])) {
					JOptionPane.showMessageDialog(GUI.this,
							FileReaderToSwing.OpenLogFile("logingRobot.log", "Upolujebooka"));
				}
				if (selectedBookstore.equals(bookStores[2])) {
					JOptionPane.showMessageDialog(GUI.this,
							FileReaderToSwing.OpenLogFile("logingRobot.log", "28Ksiazek"));
				}
			}
		});

		/**
		 * Dodanie komponentów do intefjesu
		 */

		add(bookStoreList);
		add(buttonSelect);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	/**
	 * Metoda odpowiedzialna za wywołanie okna i ustawienie go jako widocznego
	 */
	public void run() {
		new GUI().setVisible(true);
	}

}