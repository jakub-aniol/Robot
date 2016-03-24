package Scanners;

import Settings.BookStore;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Created by Jakub_Aniol
 * @version 1.0.0
 */
public class ScanRobotLegimiTest {

    @Test
    public void wheatherSubArrayListIsFilled() {

        //given
        BookStore bookStore = null;
        try {
            bookStore = new BookStore("name", new URL("http://www.legimi.com/pl/ebooki/darmowe"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ScanRobotLegimi scanRobotLegimi = new ScanRobotLegimi(bookStore);
        List<String> list = mock(List.class);
        //when
        List<String> result;
        result = scanRobotLegimi.doSubContentWWW(list);
        //then
        assertThat(result).isNotEqualTo(null);


    }


}

