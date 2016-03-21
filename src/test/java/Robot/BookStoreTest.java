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
        public static void ifBookStoreNameExistTest(){
            //given
            String expected = null;
            //when
            String result = BookStore.getName("MojaKsiegarnia");
            //then
            assertThat(result).isNotEqualTo(expected);

        }



}
