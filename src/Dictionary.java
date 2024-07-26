import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Dictionary {
    private final String filePath = "C:/Users/Никита/Desktop/russian-mnemonic-words.txt";

    public String randomWord() {
        int length = wordsArray().toArray().length;
        return wordsArray().get((int) (Math.random() * (length - 1) + 1));
    }

    public ArrayList<String> wordsArray() {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 4 && line.length() < 12) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return words;
    }
}