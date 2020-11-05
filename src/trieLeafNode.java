/**
 * Class for the leaf Node of the Huffman tree which implements the Node interface.
 */
public class trieLeafNode implements Node {
  private Character data;
  private int symbolNum;

  /**
   * The constructor for the trieLeafNode.
   */
  public trieLeafNode(Character data, int symbolNum) {
    if (symbolNum <= 1) {
      throw new IllegalArgumentException("The number of symbol cannot be less or equals 1.");
    }
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
  public char getData() {
    return data;
  }

  @Override
  public void dfs(StringBuilder sb, StringBuilder currPath) {
    sb.append(currPath).append(": ").append(data).append(", ");
  }
}
