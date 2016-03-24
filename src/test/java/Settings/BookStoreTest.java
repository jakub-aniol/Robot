package Settings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Jakub_Aniol
 * @version 1.0.0
 */
public class BookStoreTest {

    BookStore bookstore;

    @BeforeMethod
    public void setUp(){
        bookstore = null;
    }

    @Test
    public void ifBookStoreNameExistTest() {
        //given
       // BookStore bookstore = null;

        try {
            bookstore = new BookStore("legimi", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String expected = null;
        //when
        String result = bookstore.getName();
        //then
        assertThat(result).isNotEqualTo(expected);

    }

    @Test
    public void ifBookStoreUrlExistTest() {
        //given
        //BookStore bookstore = null;

        try {
            bookstore = new BookStore("legimi", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String expected = null;
        //when
        URL result = bookstore.getUrl();
        //then
        assertThat(result).isNotEqualTo(expected);

    }

    @Test
    public void ifBookStoreUrlAddressIsProper(){
        //BookStore bookstore = null;

        try {
            bookstore = new BookStore("legimi", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Boolean expected = true;
        //when
        Boolean result = bookstore.getUrl().toString().startsWith("http://");
        //then
        assertThat(result).isEqualTo(expected);
    }

    @AfterMethod
    public void cleanUp(){
        bookstore = null;
    }


}
