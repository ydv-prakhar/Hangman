import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws Exception {
        ArrayList<String> words = new ArrayList<
        >();
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
        String hiddenText= words.get((int)(Math.random()*words.size()));
        System.out.println(hiddenText);
    }
}