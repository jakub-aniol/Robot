package Settings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by jakub on 21.03.16.
 */
public class BookStore {
    String name;
    URL url;

    public BookStore(){
        this.name=getName();
        try {
            this.url=new URL("http://wpolityce.pl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public BookStore(String name, String url){
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setName() {
        System.out.println("Podaj nazwe ksiegarni");
        Scanner scanner = new Scanner("Legimi");
        this.url = scanner.nextLine();
    }

    public void setUrl() {
        System.out.println("Podaj adres URL ksiegarni, rozpoczyanjąc od \"www\"");
        Scanner scanner = new Scanner("www.legimi.com/pl/ebooki/darmowe");
        this.url = scanner.next();
    }


}
