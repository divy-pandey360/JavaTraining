import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name (with path): ");
        String fileName = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            System.out.println("Enter text to write to the file (type 'exit' to finish):");
            String input;
            while (!(input = scanner.nextLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(input + System.lineSeparator());
            }
            System.out.println("File written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
