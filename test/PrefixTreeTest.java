import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrefixTreeTest {
  PrefixTree prefixTree1;

  @Before
  public void setup() {
    prefixTree1 = new PrefixTree(2);
  }

  @Test
  public void testConstructor() {
    assertEquals(": null", prefixTree1.toString());
  }

  @Test
  public void testInsert() {
    prefixTree1.insert(' ', "00");
    prefixTree1.insert('e', "010");
    prefixTree1.insert('g', "0110");
    prefixTree1.insert('h', "0111");
    prefixTree1.insert('o', "10");
    prefixTree1.insert('r', "110");
    prefixTree1.insert('t', "1110");
    prefixTree1.insert('?', "11110");
    prefixTree1.insert('F', "11111");
    assertEquals("00:  , 110: r, 0110: g, 0111: h, 10: o, 1110: t, 11110: ?, 11111: F",
            prefixTree1.toString());
  }

  @Test
  public void testLookUp() {
    prefixTree1.insert(' ', "00");
    prefixTree1.insert('e', "010");
    prefixTree1.insert('g', "0110");
    prefixTree1.insert('h', "0111");
    prefixTree1.insert('o', "10");
    prefixTree1.insert('r', "110");
    prefixTree1.insert('t', "1110");
    prefixTree1.insert('?', "11110");
    prefixTree1.insert('F', "11111");
    assertEquals(" ", prefixTree1.lookUp("00"));
    assertEquals("e", prefixTree1.lookUp("010"));
    assertEquals("g", prefixTree1.lookUp("0110"));
    assertEquals("h", prefixTree1.lookUp("0111"));
    assertEquals("o", prefixTree1.lookUp("10"));
    assertEquals("r", prefixTree1.lookUp("110"));
    assertEquals("t", prefixTree1.lookUp("1110"));
    assertEquals("?", prefixTree1.lookUp("11110"));
    assertEquals("F", prefixTree1.lookUp("11111"));
  }
}
