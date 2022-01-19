package test.java.com.stoiovici.leetcode.strings;

import static org.junit.Assert.*;

import main.java.com.stoiovici.leetcode.strings.LongestCommonPrefix;

public class LongestCommonPrefixTest {

  LongestCommonPrefix sut = new LongestCommonPrefix();

  @org.junit.Test
  public void longestCommonPrefixTest() {
    String[] strs = new String[3];
    strs[0]="flower";
    strs[1]="flow";
    strs[2]="flight";
    String prefix = sut.longestCommonPrefix(strs);

    assertEquals("fl", prefix  );
    assertNotEquals("fl1", prefix  );
  }
}