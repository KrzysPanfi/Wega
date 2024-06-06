import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath = "sygnaly 1.txt";
        ArrayList<String> slowa = Download(filepath);
        System.out.println(Zad1(slowa));

    }

    public static ArrayList<String> Download(String filepath) {
        ArrayList<String> Wynik = new ArrayList<>();
        Wynik.add("");
        try {
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Wynik.add(line);
            }
            bufferedReader.close();
            return Wynik;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static StringBuilder Zad1(ArrayList<String> slowa) {
        StringBuilder newstring = new StringBuilder();
        for (int i = 1; i < slowa.size(); i++) {
            if (i % 40 == 0) {
                try {
                    String str = slowa.get(i);
                    char[] znaki = str.toCharArray();
                    newstring.append(znaki[9]);
                } catch (Exception e) {
                    System.out.println(slowa.get(i));
                    System.out.println(i);
                }
            }
        }

        return newstring;
    }
    public static ArrayList<String>Zad2(ArrayList<String>slowa){
        
    }

}