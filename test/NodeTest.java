import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for the Node interface to check the correctness of the TrieElementNode constructor, the
 * TrieLeafNode constructor, add method, as well as the addChildren method.
 */
public class NodeTest {
  Node leaf;
  Node element;

  @Before
  public void setup() {
    leaf = new TrieLeafNode('c', 2);
    element = new TrieElementNode(2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrieElementNodeConstructor() {
    Node elementNode = new TrieElementNode(-1);
    Node elementNode1 = new TrieElementNode(0);
    Node elementNode2 = new TrieElementNode(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrieLeafNodeConstructor() {
    Node elementNode = new TrieLeafNode('a', -1);
    Node elementNode1 = new TrieLeafNode('b', 0);
    Node elementNode2 = new TrieLeafNode('c', 1);
  }

  @Test
  public void testAddChildren() {
    Node child = new TrieLeafNode('x', 2);
    Node root = new TrieElementNode(2);
    root.addChildren(1, child);
    assertEquals(child, root.getChildNode(1));
    assertEquals('x', root.getChildNode(1).getData());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddInvalid() {
    Node node = new TrieElementNode(2);
    node.add('a', "10", 1);
    node.add('a', "101", 1);
  }
}
