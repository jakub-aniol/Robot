package Scanners;

import Settings.BookStore;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * @author Created by Jakub_Aniol on 22.03.16.
 * @version 1.0.0
 */
public class ScanRobotUpolujEbooka {

	final static Logger logger = Logger.getLogger(ScanRobotUpolujEbooka.class);

	private final BookStore bsUpolujEbooka;

	public ScanRobotUpolujEbooka(BookStore bookStore) {
		bsUpolujEbooka = bookStore;
	}

	/**
	 * Metoda odpowiedzialna za wydzielenie sublisty ograniczającej wielkość listę zawierającą
	 * całą stronę www do mniejszego obszaru, z ktorego latwiej mozna wyodrębnić darmowe e-booki
	 * @param contentWWW klasy List<String>
	 * @return subContentWWW klasy List</String>
	 * @throws IndexOutOfBoundsException
	 */
	public List<String> doSubContentWWW(List<String> contentWWW) {
		List<String> subContentWWW = null;
		int firstOccurence = 0;
		int lastOccurence = 0;
		try {
			firstOccurence = contentWWW.indexOf("class=\"OfferListingOne\">");
			lastOccurence = contentWWW.indexOf("id=\"amazon_offer\">");
			subContentWWW = contentWWW.subList(firstOccurence, lastOccurence);
		} catch (IndexOutOfBoundsException e) {
			logger.error(
					"Nie można wydzielic sublisty brak występowania ogranicznikow" + firstOccurence + lastOccurence, e);
		}
		return subContentWWW;
	}

	/**
	 * Metoda zawierająca algorytm zczytania odpowiednich treści pozawalajaych na wyświeltenie darmowych książek
	 * @param list - Klasy List
	 * @throws NullPointerException
	 */
	public void showUpolujEbookaBooks(List list) {
		ListIterator<String> iterWWW;
		Set<String> titles = new HashSet<>();
		List<String> author = new ArrayList<>();

		try {
			iterWWW = list.listIterator();

			String starts;
			String tytul;
			String autor;

			while (iterWWW.hasNext()) {
				starts = iterWWW.next();
				if (starts.startsWith("000003", 29)) {
					tytul = starts.substring(59, starts.length() - 5);
					titles.add(tytul);
				}

				if (starts.contains("href=\"/autor,")) {
					autor = starts.substring(19, starts.length() - 6);
					author.add(autor);
				}

			}

			String[] ttab = new String[titles.size()];
			titles.toArray(ttab);

			String[] atab = new String[author.size()];
			author.toArray(atab);

			for (int i = 0; i < atab.length; i++) {
				logger.info(bsUpolujEbooka.getName() + " " + ttab[i] + "-" + atab[i]);
			}

		} catch (NullPointerException e) {
			logger.error("Brak danych", e);
		}
	}
}
