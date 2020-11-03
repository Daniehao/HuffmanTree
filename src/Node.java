/**
 * The Node interface that has method to add element and has method to return the in order string of
 * the prefix tree.
 */
public interface Node {
  /**
   * Add a new node to the current node.
   *
   * @param symbol The data of the new node to be added.
   * @return The current node.
   */
  Node add(Character symbol, String code, int position);

  public void addChildren(int index, Node child);

}
