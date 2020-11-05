/**
 * Class to implement operations on Huffman tree, for example, look up the character by given the
 * prefix code or insert a prefix code to the tree's root.
 */
public class HuffmanTree {
  Node root;

  /**
   * Constructor for the HuffmanTree.
   *
   * @param symbolNum The total number of symbols.
   */
  public HuffmanTree(int symbolNum) {
    root = new trieLeafNode(null, symbolNum);
  }

  /**
   * Insert one of the codes into the Huffman tree.
   *
   * @param c    The current character to be inserted.
   * @param code The string of code.
   */
  public void insert(Character c, String code) {
    root = root.add(c, code, 0);
  }

  /**
   * Generate the decode result by input a coded string.
   *
   * @param codeStr The coded string.
   * @return The decoded normal string.
   */
  public String lookUp(String codeStr) {
    String rst = "";
    Node currNode = root;
    for (int i = 0; i < codeStr.length(); i++) {
      Node child = currNode.getChildNode(ConvertToDecimal.convert(codeStr.charAt(i)));
      if (child instanceof trieLeafNode) {
        rst += child.getData();
        currNode = root;
      } else {
        currNode = child;
      }
    }
    return rst;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    StringBuilder currPath = new StringBuilder();
    root.dfs(sb, currPath);
    sb.delete(sb.length() - 2, sb.length());
    return sb.toString();
  }
}
