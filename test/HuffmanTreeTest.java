import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HuffmanTreeTest {
  HuffmanTree huffmanTree1;
  HuffmanTree huffmanTree2;

  @Before
  public void setup() {
    huffmanTree1 = new HuffmanTree(2);
    huffmanTree2 = new HuffmanTree(16);
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
    assertEquals("00:  , 010: e, 0110: g, 0111: h, 10: o, 110: r, 1110: t, 11110: ?," +
                    " 11111: F",
            huffmanTree1.toString());
  }

  @Test
  public void testInsert2() {
    huffmanTree2.insert(' ', "3c");
    huffmanTree2.insert('!', "30");
    huffmanTree2.insert('a', "3d");
    huffmanTree2.insert('b', "3e");
    huffmanTree2.insert('c', "3f");
    huffmanTree2.insert('d', "3b");
    huffmanTree2.insert('e', "3a");
    huffmanTree2.insert('f', "38");
    huffmanTree2.insert('g', "39");
    huffmanTree2.insert('h', "31");
    huffmanTree2.insert('i', "32");
    huffmanTree2.insert('j', "33");
    huffmanTree2.insert('k', "34");
    huffmanTree2.insert('l', "0");
    huffmanTree2.insert('m', "35");
    huffmanTree2.insert('n', "36");
    huffmanTree2.insert('o', "2");
    huffmanTree2.insert('p', "1");
    huffmanTree2.insert('q', "37");
    assertEquals("0: l, 1: p, 2: o, 30: !, 31: h, 32: i, 33: j, 34: k, 35: m, 36: n, " +
                    "37: q, 38: f, 39: g, 3a: e, 3b: d, 3c:  , 3d: a, 3e: b, 3f: c",
            huffmanTree2.toString());
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

  @Test
  public void testLookUp2() {
    huffmanTree2.insert(' ', "3c");
    huffmanTree2.insert('!', "30");
    huffmanTree2.insert('a', "3d");
    huffmanTree2.insert('b', "3e");
    huffmanTree2.insert('c', "3f");
    huffmanTree2.insert('d', "3b");
    huffmanTree2.insert('e', "3a");
    huffmanTree2.insert('f', "38");
    huffmanTree2.insert('g', "39");
    huffmanTree2.insert('h', "31");
    huffmanTree2.insert('i', "32");
    huffmanTree2.insert('j', "33");
    huffmanTree2.insert('k', "34");
    huffmanTree2.insert('l', "0");
    huffmanTree2.insert('m', "35");
    huffmanTree2.insert('n', "36");
    huffmanTree2.insert('o', "2");
    huffmanTree2.insert('p', "1");
    huffmanTree2.insert('q', "37");
    assertEquals(" ", huffmanTree2.lookUp("3c"));
    assertEquals("!", huffmanTree2.lookUp("30"));
    assertEquals("a", huffmanTree2.lookUp("3d"));
    assertEquals("b", huffmanTree2.lookUp("3e"));
    assertEquals("c", huffmanTree2.lookUp("3f"));
    assertEquals("d", huffmanTree2.lookUp("3b"));
    assertEquals("e", huffmanTree2.lookUp("3a"));
    assertEquals("f", huffmanTree2.lookUp("38"));
    assertEquals("g", huffmanTree2.lookUp("39"));
    assertEquals("h", huffmanTree2.lookUp("31"));
    assertEquals("i", huffmanTree2.lookUp("32"));
    assertEquals("j", huffmanTree2.lookUp("33"));
    assertEquals("k", huffmanTree2.lookUp("34"));
    assertEquals("l", huffmanTree2.lookUp("0"));
    assertEquals("m", huffmanTree2.lookUp("35"));
    assertEquals("n", huffmanTree2.lookUp("36"));
    assertEquals("o", huffmanTree2.lookUp("2"));
    assertEquals("p", huffmanTree2.lookUp("1"));
    assertEquals("q", huffmanTree2.lookUp("37"));
  }
}
