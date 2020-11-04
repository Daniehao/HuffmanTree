import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * The class implements the CodeOperation interface.
 */
public class CodeOperationImpl implements CodeOperation {
  private Map<Character, String> prefixMap;
  private PrefixTree tree;

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
            PriorityQueue<Pair<String, Integer>>(new strComparator());
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
            prefixMap.put(c, "" + i);
          } else {
            prefixMap.put(c, "" + i + prefixMap.get(c));
          }
        }
      }
      Pair<String, Integer> pair = new Pair<String, Integer>(newKey, newValue);
      queue.offer(pair);
    }
    int n = queue.size();
    for (int i = 0; i < n; i++) {
      Pair<String, Integer> pair = queue.poll();
      String currStr = pair.getKey();
      for (char c : currStr.toCharArray()) {
        if (!prefixMap.containsKey(c)) {
          prefixMap.put(c, "" + i);
        } else {
          prefixMap.put(c, "" + i + prefixMap.get(c));
        }
      }
    }
  }

  /**
   * Class for setting the order of the priority queue by the ascending count of characters and then
   * by the Alphabetical order if the count of character are the same for different characters.
   */
  class strComparator implements Comparator<Pair<String, Integer>> {
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

  @Override
  public void generatePrefixTree(int SymbolNum) {
    PrefixTree tree = new PrefixTree(SymbolNum);
    for (Character c : prefixMap.keySet()) {
      tree.insert(c, prefixMap.get(c));
    }
    this.tree = tree;
  }

  @Override
  public String decode(String codeStr) {
    return tree.lookUp(codeStr);
  }

  @Override
  public String encode(String uncodeStr) {
    String ans = "";
    for (int i = 0; i < uncodeStr.length(); i++) {
      char key = uncodeStr.charAt(i);
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
}


