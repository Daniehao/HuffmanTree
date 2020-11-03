import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CodeOperationImpl implements CodeOperation {
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
    Map<String, Integer> freqMap = generateFrequencyMap(message);
    PriorityQueue<>
  }

  /**
   * Generate the frequency map by counting the number of each character in the input message.
   * @param message The input message.
   * @return The frequency map.
   */
  private Map<String, Integer> generateFrequencyMap(String message) {
    Map<String, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < message.length(); i++) {
      String s = "" + message.charAt(i);
      if (freqMap.containsKey(s)) {
        freqMap.put(s, freqMap.get(s) + 1);
      } else {
        freqMap.put(s, 1);
      }
    }
    return freqMap;
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


