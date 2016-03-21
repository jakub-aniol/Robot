package Robot;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jakub on 21.03.16.
 */
public class BookStoreTest {
    public static void main() {
    }

    @Test
    public static void ifBookStoreNameExistTest() {
        //given

        String expected = null;
        //when
        String result = BookStore.getName();
        //then
        assertThat(result).isNotEqualTo(expected);

    }

    @Test
    public static void ifBookStoreUrlExistTest() {
        //given
        String expected = null;
        //when
        String result = BookStore.getUrl();
        //then
        assertThat(result).isNotEqualTo(expected);

    }

    @Test
    public static void ifBookStoreUrlAddressIsProper(){
        //given
        Boolean expected = true;
        //when
        Boolean result = BookStore.getUrl().startsWith("www.");
        //then
        assertThat(result).isEqualTo(expected);
    }


}
