package Robot;

import java.util.Scanner;

/**
 * Created by jakub on 21.03.16.
 */
public class BookStore {
    String name;
    String url;

    BookStore(){
        this.name=getName();
        this.url=getUrl();
    }


    public String getName() {
        System.out.println("Podaj nazwe ksiegarni");
        Scanner scanner = new Scanner("Legimi");
        String nazwaKsiegarni = scanner.nextLine();
        //String nazwaKsiegarni = "XXX";
        return nazwaKsiegarni;
    }

    public String getUrl() {
        System.out.println("Podaj adres URL ksiegarni, rozpoczyanjąc od \"www\"");
        Scanner scanner = new Scanner("www.legimi.com/pl/ebooki/darmowe");
        String urlKsiegarni = "www.";
        urlKsiegarni= scanner.next();
        //String urlKsiegarni = "www.";
        return urlKsiegarni;
    }
}
