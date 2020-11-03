public class ConvertToDecimal {
  public static int convert(Character c) {
    if (c >= '0' && c <= '9') {
      return c - '0';
    }
    if (c >= 'a' && c <= 'z'){
      return c - 'a' + 10;
    }
    return c - 'A' + 10;
  }
}
