import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;


class Reader {
    // Empty class as per your original code
}

public class Main {
    public static void main(String[] args) {
        try (InputStream inputStream = Main.class.getResourceAsStream("/stock.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
