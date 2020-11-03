/**
 * The interface includes operations to generate code dictionary and prefix tree and also it has
 * decode and encode operations with a input string.
 */
public interface CodeOperation<T> {

  /**
   * Generate the prefix tree from the prefix code map.
   */
  public void generatePrefixTree();

  /**
   * Decode a coded string to a normal string with characters.
   * @param codeStr The coded string.
   * @return The normal string.
   */
  public String Decode(String codeStr);

  /**
   * Encode a normal string to a coded string.
   * @param  uncodeStr The uncoded normal string.
   * @return The coded string.
   */
  public String Encode(String uncodeStr);
}
