package Robot;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Created by Jakub_Aniol
 * @version 1.0.0
 */
public class ScanningWWWTest {

    @Test
    public void wheatherInputStreamMakesAnArrayList() {
        //given
        ScanningWWW scanningWWW = new ScanningWWW();
        InputStream inputStream = mock(InputStream.class);
        //when
        ArrayList<String> result;
        result = scanningWWW.doScan(inputStream);
        //then
        assertThat(result).isNotEqualTo(null);
    }

}