import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * This Driver class enables user to read a message from either the keyboard or from a file, and it
 * enables users to do the encoding and decoding operations as well as write messages to the screen
 * or to a file.
 */
public class Driver {
  public static void instruction() {
    System.out.println("Instructions by the following: ");
    System.out.println("Step 1: Input 0 for reading from keyboard, 1 for reading from file.");
    System.out.println("Step 2: Input your message if you choose keyboard reading option " +
            "in step 1. Input your full file path if you choose file reading option in step 1.");
    System.out.println("Step 3: Input 2 for binary encoding, 16 for hexadecimal encoding.");


  }

  public static void main(String[] args) throws URISyntaxException, MalformedURLException {
    Scanner sc = new Scanner(System.in);
    String message = "";
    int symbolNum = 0;
    System.out.println("1. Choose the way to read a message: ");
    int readWay = sc.nextInt();
    if (readWay == 0) {
      System.out.println("2. Input your message: ");
      message = sc.nextLine();
    } else {
      System.out.println("2. Input your file path: ");
      String filePath = sc.nextLine();
      StringBuilder sb = new StringBuilder();
      try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
        stream.forEach(sb::append);
      } catch (IOException e) {
        e.printStackTrace();
      }
      message = sb.toString();
    }
    System.out.println("3. Choose binary encoding or hexadecimal encoding: ");
    symbolNum = sc.nextInt();

  }
}
