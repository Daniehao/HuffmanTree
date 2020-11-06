/**
 * The Node interface that has method to add element and has method to return the in order string of
 * the Huffman tree.
 */
public interface Node {
  /**
   * Add a new node to the current node.
   *
   * @param symbol The data of the new node to be added.
   * @return The current node.
   */
  public Node add(Character symbol, String code, int position);

  /**
   * Add a child node to a specific position based on the character value in the current prefix.
   * code.
   *
   * @param index The index to insert the child node.
   * @param child The child node to be inserted.
   */
  public void addChildren(int index, Node child);

  /**
   * Return the child node based on the character value in the current prefix.
   *
   * @param index The index to get the child node.
   * @return The child node at a position.
   */
  public Node getChildNode(int index);

  /**
   * Get data value of the current node.
   *
   * @return Data of the current node.
   */
  public char getData();

  /**
   * Use the deepeast-first search to traverse the Huffman tree.
   *
   * @param sb       The string builder to store the leaves that have been traversed.
   * @param currPath The string builder to store the whole path from root to leaf.
   */
  public void dfs(StringBuilder sb, StringBuilder currPath);
}
