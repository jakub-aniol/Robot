package Robot;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.net.URLConnection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Created by Jakub_Aniol
 * @version 1.0.0
 */
public class InputStreamWWWTest {

    @Test
    public void wheatherOpeningConectionGivesInputStream(){
        //given
        InputStreamWWW inputStreamWWW = new InputStreamWWW();
        URLConnection urlConnection = mock(URLConnection.class);
        InputStream expected =  null;
        //when
        InputStream result;
        result = inputStreamWWW.pullWWW(urlConnection);

        //then
        assertThat(result).isEqualTo(expected);
    }
}