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
    System.out.println("Step 0: Input 0 for writing message to screen, 1 for building a new file" +
            "to write a message. Input message for writing in keyboard; Input your file path and " +
            "message if you choose to write message in a new file.");
    System.out.println("Step 1: Input 0 for reading from keyboard, 1 for reading from file.");
    System.out.println("Step 2: Input 2 for binary encoding, 16 for hexadecimal encoding.");
    System.out.println("Step 3: 0: Input 0 for writing encoded message to screen, 1 for writing " +
            "the encoded message into a new file. Input your file path if you choose " +
            "to write encoded message to a new file.");
    System.out.println("Step 4: Decode message.");
  }

  public static void main(String[] args) throws URISyntaxException, IOException {
    Scanner sc = new Scanner(System.in);
    String message = "";
    int symbolNum = 0;
    System.out.println("0. Choose the way to write a message: ");
    int writeWay = sc.nextInt();
    sc.nextLine();
    System.out.println("Input your message: ");
    message = sc.nextLine();
    if (writeWay == 1) {
      System.out.println("Input the path file for this new file: ");
      String path = sc.nextLine();
      Files.write(Paths.get(path), message.getBytes());
    }
    System.out.println("1. Choose the way to read a message: ");
    int readWay = sc.nextInt();
    sc.nextLine();
    if (readWay == 0) {
      System.out.println(message);
    } else {
      System.out.println("Input your file path: ");
      String filePath = sc.nextLine();
      StringBuilder sb = new StringBuilder();
      try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
        stream.forEach(sb::append);
      } catch (IOException e) {
        e.printStackTrace();
      }
      message = sb.toString();
    }
    System.out.println("2. Choose binary encoding or hexadecimal encoding: ");
    symbolNum = sc.nextInt();
    sc.nextLine();
    CodeOperation codeOperation = new CodeOperationImpl(message, symbolNum);
    System.out.println("3. Choose the method to write the encoded message: ");
    int writeWayEncode = sc.nextInt();
    message = codeOperation.encode(message);
    sc.nextLine();
    if (writeWayEncode == 1) {
      System.out.println("Input the path file for this new file: ");
      String path = sc.nextLine();
      Files.write(Paths.get(path), message.getBytes());
    } else {
      System.out.println(message);
    }
    System.out.println("4. Choose the method to write the decoded message: ");
    int writeWayDecode = sc.nextInt();
    codeOperation.generateHuffmanTree(symbolNum);
    message = codeOperation.decode(message);
    sc.nextLine();
    if (writeWayDecode == 1) {
      System.out.println("Input the path file for this new file: ");
      String path = sc.nextLine();
      Files.write(Paths.get(path), message.getBytes());
    } else {
      System.out.println(message);
    }
  }
}
