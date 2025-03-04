import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fetcher {

    public static List<String> readFile(String filePath, int startIndex, int endIndex) {
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentIndex = 0;

            while ((line = br.readLine()) != null) {
                if (currentIndex >= startIndex && currentIndex <= endIndex) {
                    data.add(line);
                }
                currentIndex++;
                if (currentIndex > endIndex) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String[] args) {
        String filePath = "C:/Users/DivyPrakashPandey/IdeaProjects/Java_Training/Day4/src/stock.csv";
        int startIndex = 1;
        int endIndex = 5;

        List<String> data = readFile(filePath, startIndex, endIndex);

        for (String line : data) {
            System.out.println(line);
        }
    }
}
