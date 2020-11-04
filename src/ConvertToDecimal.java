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

  public static char convertToChar(int num) {
    char c;
    if (num >= 10) {
      c = (char)('a' + (num - 10));
    }else{
      c = (char)('0' + num);
    }
    return c;
  }
}
