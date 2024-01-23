package cs3500.pa05.model.data;

/**
 * The ThemeEnum enum represents the available themes with their respective theme string
 * and style string.
 */
public enum ThemeEnum {

  /**
   * light theme enum
   */
  LIGHT("LIGHT", "-fx-text-fill: #579BB1; -fx-font-size: 18px;"),

  /**
   * dark theme enum
   */
  DARK("DARK", "-fx-text-fill: #ECE8DD; -fx-font-size: 18px;"),

  /**
   * retro theme enum
   */
  RETRO("RETRO", "-fx-text-fill: beige; -fx-font-size: 18px;");

  private final String themeString;
  private final String styleString;

  /**
   * Constructs a ThemeEnum with the specified theme string and style string.
   *
   * @param themeString the string representation of the theme
   * @param styleString the string representation of the style
   */
  ThemeEnum(String themeString, String styleString) {
    this.themeString = themeString;
    this.styleString = styleString;
  }

  /**
   * Returns the string representation of the theme.
   *
   * @return the string representation of the theme
   */
  public String toString() {
    return this.themeString;
  }

  /**
   * Returns the style string associated with the theme.
   *
   * @return the style string associated with the theme
   */
  public String toStyle() {
    return this.styleString;
  }
}
