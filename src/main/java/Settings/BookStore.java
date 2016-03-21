package Settings;

import java.net.MalformedURLException;
import java.net.URL;

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

    public BookStore(String name, URL url){
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public URL getUrl() {
        return this.url;
    }

}
