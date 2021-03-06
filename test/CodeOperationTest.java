import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * This class checks the correctness of the methods in the CodeOperation interface as well as the
 * CodeOperationImpl class. It includes tests on the correctness on CodeOperationImpl constructor,
 * the prefix map, the frequency map, encoding result, decoding result, and prefix coding.
 */
public class CodeOperationTest {
  private CodeOperation codeOperation;
  private CodeOperation codeOperation2;
  private CodeOperation codeOperation3;

  @Before
  public void setup() {
    codeOperation = new CodeOperationImpl("For here or to go?",
            2);
    codeOperation2 = new CodeOperationImpl("For here or to go?",
            3);
    codeOperation3 = new CodeOperationImpl("abc abcd abcde abcedfg abcdefghijk "
            + "lllllmnoooooopppppq!",
            16);
  }

  @Test
  public void testConstructor() {
    codeOperation = new CodeOperationImpl("For here or to go?", 2);
    Map<Character, String> map = new HashMap<>();
    assertEquals("For here or to go?", codeOperation.getMessage());
  }

  @Test
  public void testConstructor2() {
    codeOperation = new CodeOperationImpl("", 2);
    Map<Character, String> map = new HashMap<>();
    assertEquals("", codeOperation.getMessage());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor() {
    codeOperation = new CodeOperationImpl("For here or to go?", 1);
    codeOperation = new CodeOperationImpl("For here or to go?", 0);
    codeOperation = new CodeOperationImpl("For here or to go?", -1);
  }

  @Test
  public void testFreqMap() {
    Map<String, Integer> map = new HashMap<>();
    map.put(" ", 4);
    map.put("r", 3);
    map.put("t", 1);
    map.put("e", 2);
    map.put("F", 1);
    map.put("g", 1);
    map.put("h", 1);
    map.put("o", 4);
    map.put("?", 1);
    assertEquals(codeOperation.getFreqMap("For here or to go?"), map);
  }

  @Test
  public void testPrefixMap() {
    Map<Character, String> prefixMap = new HashMap<>();
    prefixMap.put(' ', "00");
    prefixMap.put('r', "110");
    prefixMap.put('t', "1110");
    prefixMap.put('e', "010");
    prefixMap.put('F', "11111");
    prefixMap.put('g', "0110");
    prefixMap.put('h', "0111");
    prefixMap.put('?', "11110");
    prefixMap.put('o', "10");
    assertEquals(prefixMap, codeOperation.getPrefixMap());
  }

  @Test
  public void testPrefixMap2() {
    Map<Character, String> prefixMap = new HashMap<>();
    prefixMap.put(' ', "22");
    prefixMap.put('r', "21");
    prefixMap.put('t', "01");
    prefixMap.put('e', "02");
    prefixMap.put('F', "201");
    prefixMap.put('g', "202");
    prefixMap.put('h', "00");
    prefixMap.put('?', "200");
    prefixMap.put('o', "1");
    assertEquals(prefixMap, codeOperation2.getPrefixMap());
  }

  @Test
  public void testPrefixMap3() {
    Map<Character, String> prefixMap = new HashMap<>();
    prefixMap.put(' ', "3c");
    prefixMap.put('!', "30");
    prefixMap.put('a', "3d");
    prefixMap.put('b', "3e");
    prefixMap.put('c', "3f");
    prefixMap.put('d', "3b");
    prefixMap.put('e', "3a");
    prefixMap.put('f', "38");
    prefixMap.put('g', "39");
    prefixMap.put('h', "31");
    prefixMap.put('i', "32");
    prefixMap.put('j', "33");
    prefixMap.put('k', "34");
    prefixMap.put('l', "0");
    prefixMap.put('m', "35");
    prefixMap.put('n', "36");
    prefixMap.put('o', "2");
    prefixMap.put('p', "1");
    prefixMap.put('q', "37");
    assertEquals(prefixMap, codeOperation3.getPrefixMap());
  }

  @Test
  public void testEncode() {
    assertEquals("111111011000011101011001011110",
            codeOperation.encode("For here?"));
  }

  @Test
  public void testEncode2() {
    assertEquals("2011212200022102200",
            codeOperation2.encode("For here?"));
  }

  @Test
  public void testEncode3() {
    assertEquals("3823c313a30",
            codeOperation3.encode("fo he!"));
  }

  @Test
  public void testEncodeEmpty() {
    assertEquals("",
            codeOperation3.encode(""));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEncodeInvalid() {
    codeOperation.encode("aaa!");
    codeOperation.encode("bbb!");
    codeOperation.encode("ccc!");
  }

  @Test
  public void testDecode() {
    assertEquals("For here?",
            codeOperation.decode("111111011000011101011001011110"));
  }

  @Test
  public void testDecode2() {
    assertEquals("For here?",
            codeOperation2.decode("2011212200022102200"));
  }

  @Test
  public void testDecode3() {
    assertEquals("fo he!",
            codeOperation3.decode("3823c313a30"));
  }

  @Test
  public void testDecodeEmpty() {
    assertEquals("",
            codeOperation3.decode(""));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDecodeInvalid() {
    codeOperation.decode("11100");
    codeOperation.decode("xxx11100");
    codeOperation.decode("00~~");
    codeOperation2.decode("0011");
    codeOperation3.decode("5f9c");
  }

  @Test
  public void testEncodeDecode() {
    String encoded = codeOperation.encode("For here or to go?");
    String decoded = codeOperation.decode(encoded);
    assertEquals("For here or to go?", decoded);
  }

  @Test
  public void testEncodeDecode2() {
    CodeOperation codeOperation4 = new CodeOperationImpl("I am a apple, pear, banana," +
            " green grape, red grape, orange, tomato, carrot, brocolli, kale, pineapple, pear, and"
            + " so on!", 16);
    String encoded = codeOperation4.encode("I am a apple, pear, banana!");
    String decoded = codeOperation4.decode(encoded);
    assertEquals("I am a apple, pear, banana!", decoded);
  }

  @Test
  public void testGetPrefixCoding() {
    System.out.println(codeOperation.getPrefixCoding());
    assertEquals("The following shows the prefix code for each character in the message\n"
            + "sp: 00, r: 110, t: 1110, e: 010, F: 11111, g: 0110, h: 0111, ?: 11110," +
            " o: 10", codeOperation.getPrefixCoding());
  }
}
