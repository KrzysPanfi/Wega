import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String filepath = "sygnaly 1.txt";
        ArrayList<String> slowa = Download(filepath);
        System.out.println(Zad1(slowa));
        for(String i:Zad2(slowa)){
            System.out.println(i);
        }
        for(String i:Zad3(slowa)){
            System.out.println(i);
        }
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
        for (int i = 40; i < slowa.size(); i++) {
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
        int count=0;
        ArrayList<String>wynik=new ArrayList<>();
        String najwiekszy="";
        for(String i:slowa){
            HashSet<Character> set=new HashSet<>();
            char[] chars=i.toCharArray();
            for(char j:chars){
                set.add(j);
            }
            if(set.size()>count){
                count=set.size();
                najwiekszy=i;
            }
        }
        wynik.add("Największy");
        wynik.add(najwiekszy);
        wynik.add("Dlugość");
        wynik.add(Integer.toString(count));
        return wynik;
    }
    public static ArrayList<String>Zad3(ArrayList<String>slowa){
        String alfabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<String>wynik=new ArrayList<>();
        for(String i:slowa){
            char[]chars=i.toCharArray();
            boolean difflowerthan10=true;
            for(int j=1;j<chars.length;j++){
                char znak=chars[j];
                char znak1=chars[j-1];
                int diff=alfabet.indexOf(znak)-alfabet.indexOf(znak1);
                if(diff>10){
                    difflowerthan10=false;
                }
            }
            if(difflowerthan10){
                wynik.add(i);
            }
        }
        return wynik;
    }
}