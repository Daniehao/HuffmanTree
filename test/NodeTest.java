import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the Node interface to check if
 */
public class NodeTest {
  Node leaf;
  Node element;

  @Before
  public void setup() {
    leaf = new trieLeafNode('c', 2);
    element = new trieElementNode(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrieElementNodeConstructor() {
    Node elementNode = new trieElementNode(-1);
    Node elementNode1 = new trieElementNode(0);
    Node elementNode2 = new trieElementNode(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrieLeafNodeConstructor() {
    Node elementNode = new trieLeafNode('a', -1);
    Node elementNode1 = new trieLeafNode('b', 0);
    Node elementNode2 = new trieLeafNode('c', 1);
  }

  @Test
  public void testAddChildren() {
    Node child = new trieLeafNode('x', 2);
    Node root = new trieElementNode(2);
    root.addChildren(1, child);
    assertEquals(child, root.getChildNode(1));
    assertEquals('x', root.getChildNode(1).getData());
  }
}
