import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class dictionary {

    public static ArrayList<String> wordsArray() {
        ArrayList<String> words = new ArrayList<>();
        try {
            ArrayList<String> arrayList = new ArrayList<String>(Files.readAllLines(Paths.get("C:/Users/Никита/Desktop/russian-mnemonic-words.txt"), StandardCharsets.UTF_8));
            for(String word: arrayList){
                if(word.length()>4 && word.length()<12){
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.out.println("У тебя проблема с файлом!");
        }
        return words;
    }
}