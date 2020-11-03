/**
 * Class to implement operations on prefix tree, for example, look up the character by given the
 * prefix code or insert a prefix code to the tree's root.
 */
public class PrefixTree {

  public Node insert(Character c, String code, int symbolNum) {
    Node root = new trieElementNode(symbolNum);
    for (int i = 0; i < code.length(); i++) {
      root.add(code.charAt(i));
    }
  }

  public Character lookUp() {

  }
}
