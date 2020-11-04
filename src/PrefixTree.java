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

  public String lookUp(String codeStr) {
    String rst = "";
    Node currNode = root;
    for (int i = 0; i < codeStr.length(); i++) {
      Node child = currNode.getChildNode(codeStr.charAt(i) - '0');
      if (child instanceof trieLeafNode) {
        rst += child.getData();
        currNode = root;
      } else {
        currNode = child;
      }
    }
    return rst;
  }
}
