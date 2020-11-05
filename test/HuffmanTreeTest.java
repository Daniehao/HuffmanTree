import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HuffmanTreeTest {
  HuffmanTree huffmanTree1;

  @Before
  public void setup() {
    huffmanTree1 = new HuffmanTree(2);
  }

  @Test
  public void testConstructor() {
    assertEquals(": null", huffmanTree1.toString());
  }

  @Test
  public void testInsert() {
    huffmanTree1.insert(' ', "00");
    huffmanTree1.insert('e', "010");
    huffmanTree1.insert('g', "0110");
    huffmanTree1.insert('h', "0111");
    huffmanTree1.insert('o', "10");
    huffmanTree1.insert('r', "110");
    huffmanTree1.insert('t', "1110");
    huffmanTree1.insert('?', "11110");
    huffmanTree1.insert('F', "11111");
    assertEquals("00:  , 110: r, 0110: g, 0111: h, 10: o, 1110: t, 11110: ?, 11111: F",
            huffmanTree1.toString());
  }

  @Test
  public void testLookUp() {
    huffmanTree1.insert(' ', "00");
    huffmanTree1.insert('e', "010");
    huffmanTree1.insert('g', "0110");
    huffmanTree1.insert('h', "0111");
    huffmanTree1.insert('o', "10");
    huffmanTree1.insert('r', "110");
    huffmanTree1.insert('t', "1110");
    huffmanTree1.insert('?', "11110");
    huffmanTree1.insert('F', "11111");
    assertEquals(" ", huffmanTree1.lookUp("00"));
    assertEquals("e", huffmanTree1.lookUp("010"));
    assertEquals("g", huffmanTree1.lookUp("0110"));
    assertEquals("h", huffmanTree1.lookUp("0111"));
    assertEquals("o", huffmanTree1.lookUp("10"));
    assertEquals("r", huffmanTree1.lookUp("110"));
    assertEquals("t", huffmanTree1.lookUp("1110"));
    assertEquals("?", huffmanTree1.lookUp("11110"));
    assertEquals("F", huffmanTree1.lookUp("11111"));
  }
}
