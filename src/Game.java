import javax.management.StringValueExp;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int failCounter = 0;
    private String word;
    private String wordMask;
    public static String randomWord() {
        int length = dictionary.wordsArray().toArray().length;
        String x = dictionary.wordsArray().get((int) (Math.random() * (length - 1) + 1));
        return x;
    }

    public void start() {
        int idx = 0;
        char maskSymbol = '*';
        word = randomWord();
        wordMask = "*".repeat(word.length());
        System.out.println("Отгадай слово: "+wordMask);
        boolean winnerFlag = true;
        char[] letters = word.toCharArray();
        char[] lettersInSymbol = wordMask.toCharArray();
        List<Character> symbols = new ArrayList<>();
        for(Character c: lettersInSymbol){
            symbols.add(c);
        }
        List<Character> revealedLetters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(winnerFlag){
            char letter = scanner.nextLine().charAt(0);
            letter = Character.toLowerCase(letter);
        if (word.contains(String.valueOf(letter))) {
            for(int i = 0; i<word.length();i++){
                if(letters[i]==letter){
                    lettersInSymbol[i]=letter;
                    symbols.set(i,letter);
                    if(!revealedLetters.contains(letter)){
                        revealedLetters.add(letter);
                    }
                }
            }if(revealedLetters.contains(letter)){
                System.out.println("Угадал букву: "+ letter+"\n"+
                String.valueOf(lettersInSymbol)+" угаданные буквы: "+revealedLetters.toString().replaceAll("^\\[|\\]$", ""));
            }
        }else if(letter=='.'){
            System.out.println(word);
        }else{
            failCounter++;
            System.out.println("Не угадал, количество ошибок: "+failCounter+"\n"+
                    String.valueOf(lettersInSymbol)+"\n"+
                    "Осталось попыток "+(7-failCounter));
        }
             if(!symbols.contains('*')){
                 System.out.println("Поздравляю с победой, ты полностью отгадал слово: "+word);
                 winnerFlag=false;
             }
        switch(failCounter){
            case(1):
                System.out.println(ModelStatus.FIRST.getStatus());
                break;
            case(2):
                System.out.println(ModelStatus.SECOND.getStatus());
                break;
            case(3):
                System.out.println(ModelStatus.THIRD.getStatus());
                break;
            case(4):
                System.out.println(ModelStatus.FOURTH.getStatus());
                break;
            case(5):
                System.out.println(ModelStatus.FIFTH.getStatus());
                break;
            case(6):
                System.out.println(ModelStatus.SIXTH.getStatus());
                break;
            case(7):
                System.out.println(ModelStatus.SEVENTH.getStatus()+"\n"+
                "Ты проиграл:( загаданное слово: "+ word);
                winnerFlag = false;
        }
        }

    }

}
