package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * test class for MiniViewerEnum
 */
public class MiniViewerEnumTest {

  /**
   * tests for toString
   */
  @Test
  public void testToString() {
    assertEquals("OK", MiniViewerEnum.OK.toString());
    assertEquals("EDIT", MiniViewerEnum.EDIT.toString());
    assertEquals("DELETE", MiniViewerEnum.DELETE.toString());
  }

  /**
   * tests for EnumValues
   */
  @Test
  public void testEnumValues() {
    MiniViewerEnum[] expected = {MiniViewerEnum.OK, MiniViewerEnum.EDIT, MiniViewerEnum.DELETE};
    MiniViewerEnum[] actual = MiniViewerEnum.values();

    assertEquals(expected.length, actual.length);

    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}
