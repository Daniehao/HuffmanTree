/**
 * Class for the leaf Node of prefix tree which implements the Node interface.
 */
public class trieLeafNode implements Node {
  private final Character data;
  private int symbolNum;

  /**
   * The constructor for the trieLeafNode.
   */
  public trieLeafNode(Character data, int symbolNum) {
    this.data = data;
    this.symbolNum = symbolNum;
  }

  @Override
  public Node add(Character symbol) {
    return new trieElementNode(symbolNum);
  }

}
