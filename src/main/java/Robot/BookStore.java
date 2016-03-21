package Robot;

import java.util.Scanner;

/**
 * Created by jakub on 21.03.16.
 */
public class BookStore {
    String name;
    String url;

    public String getName() {
        //Scanner scanner = new Scanner(System.in);
        //String nazwaKsiegarni = scanner.nextLine();
        String nazwaKsiegarni = "XXX";
        return nazwaKsiegarni;
    }

    public String getUrl() {
        Scanner scanner = new Scanner("www.legimi.com/pl/ebooki/darmowe");
        String urlKsiegarni = "www.";
        urlKsiegarni= scanner.next();

        //String urlKsiegarni = "www.";

        return urlKsiegarni;
    }
}
