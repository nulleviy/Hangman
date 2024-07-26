import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final Dictionary dictionary = new Dictionary();
    private final Scanner scanner = new Scanner(System.in);
    private int failCounter = 0;

    public void start() {
        String word = dictionary.randomWord();
        String wordMask = "*".repeat(word.length());
        System.out.println("Отгадай слово: "+ wordMask);
        boolean winnerFlag = true;
        char[] letters = word.toCharArray();
        char[] lettersInSymbol = wordMask.toCharArray();
        List<Character> symbols = new ArrayList<>();
        List<Character> fail = new ArrayList<>();
        for(Character c: lettersInSymbol){
            symbols.add(c);
        }
        List<Character> revealedLetters = new ArrayList<>();
        while(winnerFlag){
            char letter = scanner.nextLine().charAt(0);
            letter = Character.toLowerCase(letter);
        if (word.contains(String.valueOf(letter))) {
            for(int i = 0; i< word.length(); i++){
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
            if(!fail.contains(letter)) {
                failCounter++;
                fail.add(letter);
                System.out.println("Не угадал, количество ошибок: " + failCounter + "\n" +
                        String.valueOf(lettersInSymbol) + "\n" +
                        "Осталось попыток " + (7 - failCounter));
            }else if(fail.contains(letter)){
                System.out.println("Ты вводил эту букву, ее нет в данном слове! " + "\n" +
                        String.valueOf(lettersInSymbol));
            }
        }
             if(!symbols.contains('*')){
                 System.out.println("Поздравляю с победой, ты полностью отгадал слово: "+ word);
                 winnerFlag=false;
             }
            switch(failCounter){
                case 1 -> System.out.println(ModelStatus.FIRST.getStatus());
                case 2 -> System.out.println(ModelStatus.SECOND.getStatus());
                case 3 -> System.out.println(ModelStatus.THIRD.getStatus());
                case 4 -> System.out.println(ModelStatus.FOURTH.getStatus());
                case 5 -> System.out.println(ModelStatus.FIFTH.getStatus());
                case 6 -> System.out.println(ModelStatus.SIXTH.getStatus());
            }
            if(failCounter==7){
                System.out.println("Ты проиграл, загаданное слово было: "+ word);
        }
        }

    }

}
