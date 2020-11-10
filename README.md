# HuffmanTree
### Instruction on my program
Command: java -jar hw4.jar

My program basically have 5 steps.
Step 0: (Input original message) Choose the way to write a message.
Step 1: (Read the input message) Choose the way to read a message.
Step 2: (Input the encoding type) Choose binary encoding or hexadecimal encoding.
Step 3: (Encode Message) Choose the method to write the encoded message.
Step 4: (Decode Message) Choose the method to write the decoded message. 
Step 5: (Generate the prefix Encoding file) Input the file name of the prefix encoding.

Instructions by the following: 
Step 0: Input 0 for writing message to screen, 1 for building a new file to write a message. Input the message content. Input your file name if choose to write a new file.
Step 1: Input 0 for reading from keyboard, 1 for reading from file.
Step 2: Input 2 for binary encoding, 16 for hexadecimal encoding.
Step 3: Input 0 for writing encoded message to screen, 1 for writing the encoded message into a new file. Input your file name if you choose to write encoded message to a new file.
Step 4: Input 0 for writing decoded message to screen, 1 for writing the decoded message into a new file. Input your file name if you choose to write decoded message to a new file.
Step 5: Input the file name for the prefix encoding text file.

### Functionalities
All parts of the program are completed.The Driver class enables users to write and read a message from either the keyboard or from a file, and it enables users to do the encoding and decoding operations as well as write the new messages to the screen or to a file.

### Example Description
I attached 2 examples in my res/ folder. The first example input the message "SHE SELLS SEA SHELLS BY THE SEA SHORE" by using keyboard since I input 0 for step 0. I then input 0 for step 1 in order to read the message by screen. I input 2 in step 2 to enforce the binary encoding. I input 0 for the step 3 to read the encoded message by screen. I input 0 for step 4 to write the decoded message on screen. Then, in step 5, I input the name of the prefix encoding file as "prefix1.txt" and it was generated.

The second example input the message "I am a apple, pear, banana, green grape, red grape, orange, tomato, carrot, brocolli, kale, pineapple, pear, and so on!" in a new file since I input 1 for step 0. I input the file name as "message.txt".I input 1 for step 1 in order to read the message by an existing file, and here I input the file name that I just created("message.txt"). I input 16 in step 2 in order to choose the hexadecimal encoding type. Then I choose to write the encoding and decoding message in a file by input 1 in step 3 and step 4. The encoded message is saved in "encodedMessage.txt" and the decoded message is saved in "decodedMessage.txt". I input the name of the prefix encoding file as "prefix2.txt" and it was generated.
