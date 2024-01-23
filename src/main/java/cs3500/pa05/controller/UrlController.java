package cs3500.pa05.controller;

import cs3500.pa05.JournalApp;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.scene.control.Hyperlink;


/**
 * The UrlController class provides a method to parse a given text and extract a valid URL.
 */
public class UrlController {

  /**
   * Parses the given text and returns a Hyperlink if a valid URL is found.
   *
   * @param text the text to parse for a URL
   * @return a Hyperlink representing the URL, or null if no valid URL is found
   */
  public static Hyperlink parseUrl(String text) {
    int urlStartIndex = text.indexOf("http");
    if (urlStartIndex != -1) {
      int urlEndIndex = text.indexOf(' ', urlStartIndex);
      if (urlEndIndex == -1) {
        urlEndIndex = text.length();
      }

      String url = text.substring(urlStartIndex, urlEndIndex);

      try {
        new URL(url);
        Hyperlink hyperlink = new Hyperlink(url);
        hyperlink.setOnAction(e -> new JournalApp().getHostServices().showDocument(url));
        return hyperlink;
      } catch (MalformedURLException e) {
        return null;
      }
    } else {
      return null;
    }
  }
}
