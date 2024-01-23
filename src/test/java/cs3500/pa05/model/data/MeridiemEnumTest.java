package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * test class for MeridiemEnum
 */
public class MeridiemEnumTest {

  /**
   * tests toString
   */
  @Test
  public void testToString() {
    assertEquals("AM", MeridiemEnum.AM.toString());
    assertEquals("PM", MeridiemEnum.PM.toString());
  }

  /**
   * testing enum values
   */
  @Test
  public void testEnumValues() {
    MeridiemEnum[] expected = {MeridiemEnum.AM, MeridiemEnum.PM};
    MeridiemEnum[] actual = MeridiemEnum.values();

    assertEquals(expected.length, actual.length);

    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}
