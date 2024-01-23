package cs3500.pa05.model.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * test class for ThemeEnum
 */
public class ThemeEnumTest {

  /**
   * tests for toString
   */
  @Test
  public void testToString() {
    assertEquals("LIGHT", ThemeEnum.LIGHT.toString());
    assertEquals("DARK", ThemeEnum.DARK.toString());
    assertEquals("RETRO", ThemeEnum.RETRO.toString());
  }

  /**
   * test for toStyle
   */
  @Test
  public void testToStyle() {
    assertEquals("-fx-text-fill: #579BB1; -fx-font-size: 18px;", ThemeEnum.LIGHT.toStyle());
    assertEquals("-fx-text-fill: #ECE8DD; -fx-font-size: 18px;", ThemeEnum.DARK.toStyle());
    assertEquals("-fx-text-fill: beige; -fx-font-size: 18px;", ThemeEnum.RETRO.toStyle());
  }
}
