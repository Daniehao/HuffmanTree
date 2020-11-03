/**
 * Class to implement operations on prefix tree, for example, look up the character by given the
 * prefix code or insert a prefix code to the tree's root.
 */
public class PrefixTree {
  Node root;

  public PrefixTree(int symbolNum) {
    root = new trieLeafNode(null, symbolNum);
  }

  public void insert(Character c, String code) {
    root = root.add(c, code, 0);
  }

  public Character lookUp() {

  }
}
