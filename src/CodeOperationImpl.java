import java.util.HashMap;
import java.util.Map;

public class CodeOperationImpl<T> implements CodeOperation<T> {
  private Map<String, String> prefixMap;
  /**
   * Constructor for the CodeOperationImpl class.
   * @param message The message of user's input.
   * @param SymbolNum The number of symbols required.
   */
  public CodeOperationImpl(String message, int SymbolNum) {
    prefixMap = new HashMap<>();
    generateDictionary(message, SymbolNum);
  }

  /**
   * Generate a map from each Character in the message to a prefix code by using the Huffman
   * encoding algorithm.
   * @param message The user's input message.
   * @param symbolNum The number of symbols required.
   */
  private void generateDictionary(String message, int symbolNum) {
  }

  @Override
  public void generatePrefixTree() {

  }

  @Override
  public String Decode(String codeStr) {
    return null;
  }

  @Override
  public String Encode(String uncodeStr) {
    return null;
  }
}


