package Robot;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.net.URLConnection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class InputStreamWWWTest {

    @Test
    public void wheatherOpeningConectionGivesInputStream() {
        //given
        InputStreamWWW inputStreamWWW = new InputStreamWWW();
        URLConnection urlConnection = mock(URLConnection.class);
        //when
        InputStream result = inputStreamWWW.pullWWW(urlConnection);
        //then
        assertThat(result).isEqualTo(null);
    }
}