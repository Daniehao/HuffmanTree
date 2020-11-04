/**
 * Class for the leaf Node of prefix tree which implements the Node interface.
 */
public class trieLeafNode implements Node {
  private Character data;
  private int symbolNum;

  /**
   * The constructor for the trieLeafNode.
   */
  public trieLeafNode(Character data, int symbolNum) {
    this.data = data;
    this.symbolNum = symbolNum;
  }

  @Override
  public Node add(Character symbol, String code, int position) {
    if (position == code.length()) {
      data = symbol;
      return this;
    }
    Node node = new trieElementNode(symbolNum);
    node.addChildren(ConvertToDecimal.convert(code.charAt(position)), add(symbol, code,
            position + 1));
    return node;
  }

  @Override
  public void addChildren(int index, Node child) {
    return;
  }

  @Override
  public Node getChildNode(int index) {
    return null;
  }

  @Override
  public Character getData() {
    return data;
  }
}
