import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        ArrayList<String> words = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        try {
            BufferedReader bf = new BufferedReader(new FileReader("words.txt"));
            String s;

            while ((s = bf.readLine()) != null) {
                words.add(s);
            }
            bf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        String hiddenText = words.get((int) (Math.random() * words.size()));
        char[] textArray = hiddenText.toCharArray();
        char[] myAnswer = new char[textArray.length];
        int n = myAnswer.length;
        for (int i = 0; i < n; i++) {
            myAnswer[i] = '?';
        }
        boolean finished = false;
        int lives = 6;
        while (!finished) {
            System.out.println("*********************************");
            System.out.println('\n');
            boolean done=true;
            for (int i = 0; i < n; i++) {
                if (myAnswer[i] == '?'){
                    System.out.print("_");
                    done=false;
                }
                else
                    System.out.print(myAnswer[i]);
            }
            if(done)break;
            System.out.println("\nLives left= " + lives);
            System.out.println("\nGuess a letter");
            String input = sc.next();
            while (input.length() != 1 || Character.isDigit(input.charAt(0))) {
                System.out.println("Enter only a single alphabet");
                input = sc.next();
            }
            // String character = input.toLowerCase(null);
            char[] charArray = input.toCharArray();
            boolean found = false, complete = true;
            for (int i = 0; i < n; i++) {
                if (textArray[i] == charArray[0] && myAnswer[i] == '?') {
                    myAnswer[i] = charArray[0];
                    found = true;
                    complete = false;
                }
            }
            if (!found) {
                System.out.println("Wrong Guess!");
                lives--;
            }
            drawHangman(lives);
            if (lives == 0) {
                finished = true;
                System.out.println(hiddenText);
            }
            if (found && complete) {
                System.out.println("You Win");
                break;
            }
        }
        sc.close();
    }

    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   / \\");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}