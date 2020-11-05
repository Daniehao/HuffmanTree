import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * The class implements the CodeOperation interface.
 */
public class CodeOperationImpl implements CodeOperation {
  private Map<Character, String> prefixMap;
  private HuffmanTree tree;
  private String message;

  /**
   * Constructor for the CodeOperationImpl class.
   *
   * @param message   The message of user's input.
   * @param symbolNum The number of symbols required.
   */
  public CodeOperationImpl(String message, int symbolNum) {
    if (symbolNum <= 1) {
      throw new IllegalArgumentException("The number of symbol cannot be less or equals 1.");
    }
    prefixMap = new HashMap<>();
    generateDictionary(message, symbolNum);
    generateHuffmanTree(symbolNum);
    this.message = message;
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
    PriorityQueue<Pair<String, Integer>> queue = new
            PriorityQueue<Pair<String, Integer>>(new StrComparator());
    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
      queue.offer(new Pair<>(entry.getKey(), entry.getValue()));
    }
    while (queue.size() >= symbolNum) {
      String newKey = "";
      Integer newValue = 0;
      for (int i = 0; i < symbolNum; i++) {
        Pair<String, Integer> curr = queue.poll();
        String currStr = curr.getKey();
        newKey += curr.getKey();
        newValue += curr.getValue();
        for (char c : currStr.toCharArray()) {
          if (!prefixMap.containsKey(c)) {
            if (i > 9) {
              prefixMap.put(c, "" + ConvertToDecimal.convertToChar(i));
            } else {
              prefixMap.put(c, "" + i);
            }
          } else {
            if (i > 9) {
              prefixMap.put(c, "" + ConvertToDecimal.convertToChar(i) + prefixMap.get(c));
            } else {
              prefixMap.put(c, "" + i + prefixMap.get(c));
            }
          }
        }
      }
      Pair<String, Integer> pair = new Pair<String, Integer>(newKey, newValue);
      queue.offer(pair);
    }
    int n = queue.size();
    if (n != 1) {
      for (int i = 0; i < n; i++) {
        Pair<String, Integer> pair = queue.poll();
        String currStr = pair.getKey();
        for (char c : currStr.toCharArray()) {
          if (!prefixMap.containsKey(c)) {
            if (i > 9) {
              prefixMap.put(c, "" + ConvertToDecimal.convertToChar(i));
            } else {
              prefixMap.put(c, "" + i);
            }
          } else {
            if (i > 9) {
              prefixMap.put(c, "" + ConvertToDecimal.convertToChar(i) + prefixMap.get(c));
            } else {
              prefixMap.put(c, "" + i + prefixMap.get(c));
            }
          }
        }
      }
    }
  }

  /**
   * Class for setting the order of the priority queue by the ascending count of characters and then
   * by the Alphabetical order if the count of character are the same for different characters.
   */
  class StrComparator implements Comparator<Pair<String, Integer>> {
    @Override
    public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
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

  /**
   * Generate the Huffman tree from the prefix code map.
   */
  private void generateHuffmanTree(int symbolNum) {
    HuffmanTree tree = new HuffmanTree(symbolNum);
    for (Character c : prefixMap.keySet()) {
      tree.insert(c, prefixMap.get(c));
    }
    this.tree = tree;
  }

  @Override
  public String decode(String codeStr) throws IllegalArgumentException {
    return tree.lookUp(codeStr);
  }

  @Override
  public String encode(String uncodeStr) throws IllegalArgumentException {
    String ans = "";
    for (int i = 0; i < uncodeStr.length(); i++) {
      char key = uncodeStr.charAt(i);
      if (!prefixMap.containsKey(key)) {
        throw new IllegalArgumentException("The character is invalid!");
      }
      ans += prefixMap.get(key);
    }
    return ans;
  }

  @Override
  public Map<Character, String> getPrefixMap() {
    return prefixMap;
  }

  @Override
  public Map<String, Integer> getFreqMap(String message) {
    return generateFrequencyMap(message);
  }

  @Override
  public String getPrefixCoding() {
    StringBuilder sb = new StringBuilder();
    sb.append("The following shows the prefix code for each character in the message").append("\n");
    for (Character key : prefixMap.keySet()) {
      if (key == ' ') {
        sb.append("sp").append(": ").append(prefixMap.get(key)).append(", ");
        continue;
      } else {
        sb.append(key).append(": ").append(prefixMap.get(key)).append(", ");
      }
    }
    sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }

  @Override
  public String getMessage() {
    return message;
  }
}


