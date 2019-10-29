import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

public class TransformerTest {
    String sentence;

    @Before
    public void before() {
        sentence = "aaa aBCd ekL";
    }

    @Test
    public void testLength3UpperCase() {
        String input = "aaa aBCd ekL";
        String expected = "AAA aBCd EKL";

        Function<String, String> f = s -> s.toUpperCase();
        Predicate<String> p = t -> t.length() == 3;

        String actual = Transformer.transform(input, p, f);

        assertEquals(expected, actual);
    }

    @Test
    public void testLength4LowerCase() {
        String input = "aaa aBCd ekL";
        String expected = "aaa aBCd ekL";

        Function<String, String> f = s -> s.toLowerCase();
        Predicate<String> p = t -> t.length() == 4;

        String actual = Transformer.transform(input, p, f);

        assertEquals(expected, actual);
    }


}
