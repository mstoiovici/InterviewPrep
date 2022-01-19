package test.java.com.stoiovici.util.practice;

import static org.junit.Assert.*;


import main.java.com.stoiovici.util.practice.StringUtils;
import org.junit.Test;

public class StringUtilsTest {
  StringUtils cut = new StringUtils();
  @Test
  public void givenEmptyString_whenReverseIsCalled_thenEmptyStringIsReturned() {
    String actual = cut.reverse((""));
    String expected = "";

    // assertEquals without message
    assertEquals(expected, actual);
  }
  @Test
  public void givenNonNullString_whenReverseIsCalled_thenReversedStringIsReturned() {
    String actual = cut.reverse(("ABCD"));
    String expected = "DCBA";

    String message = "assertEquals succeeded";
    // assertEquals with message
    assertEquals(message, expected, actual);
  }



}