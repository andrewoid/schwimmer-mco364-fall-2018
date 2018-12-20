package schwimmer.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PhoneNumberTest {

    @Test
    public void testPhoneNumberMatching() {

        // given
        Pattern pattern = Pattern.compile("(\\d{3}[\\s\\-]?)?\\d{3}[\\s\\-]?\\d{4}");

        String text = "Here is some text with 123 456 7890 a phone number " +
                "in it and here is another 999 9999";

        // when
        Matcher matcher = pattern.matcher(text);

        assertTrue(matcher.find());
        assertEquals("123 456 7890",
                text.substring(matcher.start(), matcher.end()));

        assertTrue(matcher.find());
        assertEquals("999 9999",
                text.substring(matcher.start(), matcher.end()));

        assertFalse(matcher.find());

    }

}
