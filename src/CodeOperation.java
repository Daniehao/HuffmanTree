import java.util.Map;

/**
 * The interface includes operations to generate code dictionary and Huffman tree and also it has
 * decode and encode operations with a input string.
 */
public interface CodeOperation {

  /**
   * Generate the Huffman tree from the prefix code map.
   */
  public void generateHuffmanTree(int SymbolNum);

  /**
   * Decode a coded string to a normal string with characters.
   *
   * @param codeStr The coded string.
   * @return The normal string.
   */
  public String decode(String codeStr);

  /**
   * Encode a normal string to a coded string.
   *
   * @param uncodeStr The uncoded normal string.
   * @return The coded string.
   */
  public String encode(String uncodeStr);

  /**
   * Get the prefix map with a character and code relationship.
   * @return The prefix map.
   */
  public Map<Character, String> getPrefixMap();

  /**
   * Get the frequency map with a Character String to frequency relationship.
   * @return The frequency map of each character in the input message.
   */
  public Map<String, Integer> getFreqMap(String message);

  /**
   * Return the string of the prefix coding.
   * @return The string of the prefix coding.
   */
  public String getPrefixCoding();
}
