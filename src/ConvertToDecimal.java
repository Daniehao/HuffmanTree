/**
 * The class includes methods to convert the prefix code character to a regular number as the index
 * of the child node or convert a child node index number to character.
 */
public class ConvertToDecimal {
  /**
   * Convert the prefix code character to a regular number.
   *
   * @param c The prefix code character.
   * @return The
   */
  public static int convert(Character c) {
    if (c >= '0' && c <= '9') {
      return c - '0';
    }
    if (c >= 'a' && c <= 'z') {
      return c - 'a' + 10;
    }
    return c - 'A' + 10;
  }

  /**
   * Convert the child node index to a prefix code character.
   *
   * @param num The child node index.
   * @return The prefix code character.
   */
  public static char convertToChar(int num) {
    char c;
    if (num >= 10) {
      c = (char) ('a' + (num - 10));
    } else {
      c = (char) ('0' + num);
    }
    return c;
  }
}
