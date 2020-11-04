import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixTreeTest {
  PrefixTree prefixTree1;

  @Test
  public void testConstructor() {
    prefixTree1 = new PrefixTree(2);
    assertEquals(": null", prefixTree1.toString());
  }

  @Test
  public void testInsert() {
    prefixTree1 = new PrefixTree(2);
    prefixTree1.insert(' ', "00");
    prefixTree1.insert('e', "010");
    prefixTree1.insert('g', "011");
    prefixTree1.insert('h', "0111");
    prefixTree1.insert('o', "10");
    prefixTree1.insert('r', "010");
    prefixTree1.insert('t', "1110");
    prefixTree1.insert('?', "11110");
    prefixTree1.insert('F', "11111");
    assertEquals("00:  , 010: r, 0111: h, 10: o, 1110: t, 11110: ?, 11111: F",
            prefixTree1.toString());
  }

  @Test
  public void testLookUp() {

  }
}
