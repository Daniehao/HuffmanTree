/**
 * Class for the non-leaf Node of prefix tree which implements the Node interface.
 *
 */
public class trieElementNode implements Node {
  private Node[] children;
  private int symbolNum;

  /**
   * Constructor for trieElementNode.
   * @param symbolNum
   */
  public trieElementNode(int symbolNum) {
    children = new Node[symbolNum];
    this.symbolNum = symbolNum;
  }

  @Override
  public Node add(Character symbol, String code, int position) {
    Node node;
    if (children[ConvertToDecimal.convert(code.charAt(position))] == null) {
      node = new trieLeafNode(null, symbolNum);
    } else {
      node = children[ConvertToDecimal.convert(code.charAt(position))];
    }
    children[ConvertToDecimal.convert(code.charAt(position))] = node.add(symbol, code,
            position + 1);
    return this;
  }

  public void addChildren(int index, Node child) {
    children[index] = child;
  }
}
