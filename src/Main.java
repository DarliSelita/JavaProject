import java.util.HashMap;
import java.util.Scanner;
import java.util.*;

public class Main {
    // Hashmap to store English Characters and their corresponding Morse code.
    static HashMap<String, String> shkronjat = new HashMap<>();
    // Hashmap to store Morse Code and their corresponding English Character.
    static HashMap<String, String> morse = new HashMap<>();
    public static void main(String[] args) {
    // Scanner object to take input from user.
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Ask the user for choice (1 for Morse to English, 2 for English to Morse)
                System.out.println("Enter 1 for Morse to English or 2 for English to Morse: ");
                int choice = scanner.nextInt();
                // Check if the user entered a valid choice (1 or 2)
                if (choice != 1 && choice != 2) {
                    throw new InputMismatchException("Error: Please enter 1 or 2 for the choice.\n");
                }
                // Initialize the HashMap with English characters and Morse code
                initializeMorseCode();
                // Based on the user's choice, call the appropriate function
                if (choice == 1) {
                    TranslateToMorse();
                } else {
                    TranslateToEnglish();
                }
                // Break out of the loop once the translation is done
                break;
            } catch (InputMismatchException e) {
                // If user enters an invalid choice, print an error message
                System.out.println("Error: Please enter 1 or 2 for the choice.\n");
            }
        }
    }


    // Function to initialize the HashMap with English characters as key and Morse code as values.
    private static void initializeMorseCode() {
        shkronjat.put("a", ".-");
        shkronjat.put("b", "-...");
        shkronjat.put("c", "-.-.");
        shkronjat.put("d", "-..");
        shkronjat.put("e", ".");
        shkronjat.put("f", "..-.");
        shkronjat.put("g", "--.");
        shkronjat.put("h", "....");
        shkronjat.put("i", "..");
        shkronjat.put("j", ".---");
        shkronjat.put("k", "-.-");
        shkronjat.put("l", ".-..");
        shkronjat.put("m", "--");
        shkronjat.put("n", "-.");
        shkronjat.put("o", "---");
        shkronjat.put("p", ".--.");
        shkronjat.put("q", "--.-");
        shkronjat.put("r", ".-.");
        shkronjat.put("s", "...");
        shkronjat.put("t", "-");
        shkronjat.put("u", "..-");
        shkronjat.put("v", "...-");
        shkronjat.put("w", ".--");
        shkronjat.put("x", "-..-");
        shkronjat.put("y", "-.--");
        shkronjat.put("z", "--..");
        shkronjat.put(" ", " | ");

        // Function to initialize the HashMap with Morse Code as key and English Characters as values.
        morse.put(".-", "a");
        morse.put("-...", "b");
        morse.put("-.-.", "c");
        morse.put("-..", "d");
        morse.put(".", "e");
        morse.put("..-.", "f");
        morse.put("--.", "g");
        morse.put("....", "h");
        morse.put("..", "i");
        morse.put(".---", "j");
        morse.put("-.-", "k");
        morse.put(".-..", "l");
        morse.put("--", "m");
        morse.put("-.", "n");
        morse.put("---", "o");
        morse.put(".--.", "p");
        morse.put("--.-", "q");
        morse.put(".-.", "r");
        morse.put("...", "s");
        morse.put("-", "t");
        morse.put("..-", "u");
        morse.put("...-", "v");
        morse.put(".--", "w");
        morse.put("-..-", "x");
        morse.put("-.--", "y");
        morse.put("--..", "z");

    }
    // TranslatetoMorse is a method which uses a scanner input and takes into account a word/sentence/text and converts it into Morse Code.
    private static void TranslateToMorse() {
        Scanner sc = new Scanner(System.in);
        String morse;

        while (true) {
            System.out.print("Enter any text/sentence to translate: ");
            try {
                String word = sc.nextLine();
                if (!word.matches("[a-zA-Z]+")) {
                    throw new IllegalArgumentException("Error: Please enter a valid text\n");
                }
                String[] characters = word.split("");
                for (String character : characters) {
                    morse = shkronjat.get(character);
                    if (morse != null) {
                        System.out.print(morse + " ");
                    }
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Please enter a valid text\n");
            }
        }
    }
   // TranslatetoEnglish is a method which uses a scanner input and takes into account a morse code input and converts it into text
    private static void TranslateToEnglish() {
        Scanner sch = new Scanner(System.in);
        boolean isValidInput=false;
        while (!isValidInput) {
            System.out.print("Vendos nje kod morse: ");
            try {
                String morsi = sch.nextLine();
                String[] morseCode = morsi.split(" ");
                for (String code : morseCode) {
                    if (!morse.containsKey(code)) {
                        throw new IllegalArgumentException("Error: Please enter a valid Morse code\n");
                    }
                    String letter = morse.get(code);
                    System.out.print(letter);
                }
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Please enter a valid Morse code\n");
            }
        }
    }
}
// In both these methods, exceptions are used to make sure that the program doesn't end when an Invalid Input is entered but asks the user to re-enter a Valid Input.