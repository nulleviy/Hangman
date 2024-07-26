import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("[н]ачать новую игру или [з]авершить?");
            Scanner sc = new Scanner(System.in);
            char choice = sc.nextLine().charAt(0);
            choice = Character.toLowerCase(choice);
            if(choice=='н'){
                System.out.println("Начинаю новую игру...");
                Game game = new Game();
                game.start();
            }else if(choice=='з'){
                System.out.println("Завершаю программу");
                break;
            }else{
                System.out.println("Неверный ввод");
            }
        }
    }
}