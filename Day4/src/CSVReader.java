import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;
import java.lang.Runnable;

public class CSVReader implements Runnable {
    private final String filePath;
    private final int startIndex;
    private final int endIndex;

    public CSVReader(String filePath, int startIndex, int endIndex) {
        this.filePath = filePath;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        List<String[]> data = readCSV(filePath, startIndex, endIndex);
        for (String[] line : data) {
            for (String value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    private List<String[]> readCSV(String filePath, int startIndex, int endIndex) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int currentIndex = 0;

            while ((line = br.readLine()) != null) {
                if (currentIndex >= startIndex && currentIndex <= endIndex) {
                    String[] values = line.split(",");
                    data.add(values);
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
}
class CSVReaderMain {
    public static void main(String[] args) {
        String filePath = "C:/Users/DivyPrakashPandey/IdeaProjects/Java_Training/Day4/src/stock.csv";
        int totalLines = 800;
        int numberOfThreads = 6;
        int linesPerThread = totalLines / numberOfThreads;

        Thread[] threads = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int startIndex = i * linesPerThread;
            int endIndex = (i == numberOfThreads - 1) ? totalLines - 1 : (startIndex + linesPerThread - 1);

            threads[i] = new Thread(new CSVReader(filePath, startIndex, endIndex));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
