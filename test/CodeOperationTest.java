import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CodeOperationTest {
  private CodeOperation codeOperation;
  private CodeOperation codeOperation2;

  @Before
  public void setup() {
    codeOperation = new CodeOperationImpl("For here or to go?",
            2);
    codeOperation2 = new CodeOperationImpl("For here or to go?",
            3);
  }

  @Test
  public void testConstructor(){
    codeOperation = new CodeOperationImpl("For here or to go?", 2);
    assertEquals(true, true);
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
    prefixMap.put(' ', "000");
    prefixMap.put('r', "0110");
    prefixMap.put('t', "01110");
    prefixMap.put('e', "0010");
    prefixMap.put('F', "011111");
    prefixMap.put('g', "00110");
    prefixMap.put('h', "00111");
    prefixMap.put('?', "011110");
    prefixMap.put('o', "010");
    assertEquals(codeOperation.getPrefixMap(), prefixMap);
  }

  @Test
  public void testPrefixMap2() {
    Map<Character, String> prefixMap = new HashMap<>();
    prefixMap.put(' ', "022");
    prefixMap.put('r', "021");
    prefixMap.put('t', "001");
    prefixMap.put('e', "002");
    prefixMap.put('F', "0201");
    prefixMap.put('g', "0202");
    prefixMap.put('h', "000");
    prefixMap.put('?', "0200");
    prefixMap.put('o', "01");
    assertEquals(codeOperation2.getPrefixMap(), prefixMap);
  }

  @Test
  public void testEncode() {
    assertEquals("011111010011000000111001001100010011110",
            codeOperation.encode("For here?"));
  }

  @Test
  public void testEncode2() {
    assertEquals("0201010210220000020210020200",
            codeOperation2.encode("For here?"));
  }

  @Test
  public void testDecode(){
    codeOperation.generateHuffmanTree(2);
  assertEquals("For here?",
          codeOperation.decode("011111010011000000111001001100010011110"));
  }

  @Test
  public void testDecode2() {
    codeOperation2.generateHuffmanTree(3);
    assertEquals("For here?",
            codeOperation2.decode("0201010210220000020210020200"));
  }
}
