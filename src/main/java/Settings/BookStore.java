package Settings;

import java.net.URL;

/**
 * Created by jakub on 21.03.16.
 */
public class BookStore {
    String name;
    URL url;

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
