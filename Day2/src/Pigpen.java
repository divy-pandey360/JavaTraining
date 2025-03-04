import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pigpen {

    private static final Map<Character, String> encodeMap = new HashMap<>();
    private static final Map<String, Character> decodeMap = new HashMap<>();

    static {

        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        String[] symbols = {"\u1401", "\u1402", "\u1403", "\u1404", "\u1405", "\u1406", "\u1407", "\u1408", "\u1409", "\u140A", "\u140B", "\u140C", "\u140D", "\u140E", "\u140F", "\u1410", "\u1411", "\u1412", "\u1413", "\u1414", "\u1415", "\u1416", "\u1417", "\u1418", "\u1419", "\u141A", "\u141B"};

        for (int i = 0; i < letters.length; i++) {
            encodeMap.put(letters[i], symbols[i]);
            decodeMap.put(symbols[i], letters[i]);
        }

    }

    public static String encode(String text) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isUpperCase = Character.isUpperCase(c);
                char upperChar = Character.toUpperCase(c);
                String symbol = encodeMap.get(upperChar);
                encoded.append(isUpperCase ? symbol : symbol.toLowerCase());
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

    public static String decode(String text) {
        StringBuilder decoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            String symbol = String.valueOf(c).toUpperCase();
            Character letter = decodeMap.get(symbol);
            if (letter != null) {
                decoded.append(Character.isUpperCase(c) ? letter : Character.toLowerCase(letter));
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();

        System.out.println("Choose mode: (1) Encode (2) Decode");
        int mode = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (mode == 1) {
            System.out.println("Encoded text: " + encode(text));
        } else if (mode == 2) {
            System.out.println("Decoded text: " + decode(text));
        } else {
            System.out.println("Invalid mode selected.");
        }

        scanner.close();
    }
}
