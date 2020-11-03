import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CodeOperationImpl implements CodeOperation {
  private Map<String, String> prefixMap;

  /**
   * Constructor for the CodeOperationImpl class.
   *
   * @param message   The message of user's input.
   * @param SymbolNum The number of symbols required.
   */
  public CodeOperationImpl(String message, int SymbolNum) {
    prefixMap = new HashMap<>();
    generateDictionary(message, SymbolNum);
  }

  /**
   * Generate a map from each Character in the message to a prefix code by using the Huffman
   * encoding algorithm.
   *
   * @param message   The user's input message.
   * @param symbolNum The number of symbols required.
   */
  private void generateDictionary(String message, int symbolNum) {
    Map<String, Integer> freqMap = generateFrequencyMap(message);
    PriorityQueue<Map.Entry<String, Integer>> queue = new
            PriorityQueue<Map.Entry<String, Integer>>(new strComparator());
    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
      queue.offer(entry);
    }
    while (queue.size() >= symbolNum) {
      for (int i = 0; i < symbolNum; i++) {
        Map.Entry<String, Integer> curr = queue.poll();
        String currStr = curr.getKey();
        for (char c : currStr.toCharArray()) {
          String key = "" + c;
          if (!prefixMap.containsKey(key)) {
            prefixMap.put(key, "" + symbolNum);
          } else {
            prefixMap.put(key, "" + symbolNum + prefixMap.get(key));
          }
        }
      }
    }

  }

  /**
   * Class for setting the order of the priority queue by the ascending count of characters and then
   * by the Alphabetical order if the count of character are the same for different characters.
   */
  class strComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
      if (o1.getValue() - o2.getValue() != 0) {
        return o1.getValue() - o2.getValue();
      }
      return o1.getKey().compareTo(o2.getKey());
    }
  }

  /**
   * Generate the frequency map by counting the number of each character in the input message.
   *
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


