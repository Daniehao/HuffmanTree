/**
 * Class for the non-leaf Node of prefix tree which implements the Node interface.
 *
 */
public class trieElementNode implements Node {
  private Node[] children;
  private int symbolNum;
  private Node curr;

  /**
   * Constructor for trieElementNode.
   * @param symbolNum
   */
  public trieElementNode(int symbolNum) {
    curr = new trieLeafNode(null, symbolNum);
    children = new Node[symbolNum];
    this.symbolNum = symbolNum;
  }

  @Override
  public Node add(Character symbol) {
    if (children[symbol - '1'] == null) {
      Node newNode = new trieElementNode(symbolNum);
      children[symbol - '1'] = newNode;
    }
    curr = children[symbol - '1'];
    return this;
  }
}
