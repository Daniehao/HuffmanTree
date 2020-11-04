import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class CodeOperationTest {
  private CodeOperation codeOperation;

  @Before
  public void setup() {
    codeOperation = new CodeOperationImpl("For here or to go?", 2);
  }

  @Test
  public void testFreqMap() {
    HashMap<String, Integer> map = new HashMap<>();
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
    System.out.println(codeOperation.getPrefixMap());
  }
}
