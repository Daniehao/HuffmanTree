import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class NodeTest {
  Node leaf;
  Node element;

  @Before
  public void setup() {
    leaf = new trieLeafNode('c', 2);
    element = new trieElementNode(2);
  }

  @Test
  public void testAdd() {
  }
}
