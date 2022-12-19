import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter file path:");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        File file=new File(path);
        ArrayList<String> wordsArrayList = new ArrayList<>();

        try (Scanner sc2 = new Scanner(file)){

         while (sc2.hasNextLine()){
             String line = sc2.nextLine();
             String[] wordsArray = line.split("[ ()+-/_,]+");
             for (String word: wordsArray) {
                 wordsArrayList.add(word);
             }
         }
        } catch (FileNotFoundException exception){
            System.out.println( "File not found");
        }
        Collections.sort(wordsArrayList);
        wordsArrayList.forEach((e -> System.out.println(e)));

        Map<String,Integer> wordsMap = wordsArrayList.stream().collect(Collectors.toMap(e->e, e->1, Integer::sum));
        wordsMap.forEach((k, v) -> System.out.println(k + " - " + v + " ( " + (100*v/wordsArrayList.size()) + "% )"));
        int max = 0;
        String rep = "";

        for (String word:
             wordsArrayList) {
            if (wordsMap.get(word)>max){
                max = wordsMap.get(word);
                rep = word;
            }
        }
        String rep1 = "";
        for (String word:
                wordsArrayList) {
            if ((wordsMap.get(word) == max) && !(rep.equals(word))){
                 rep1 = word;
            }
        }
        System.out.println("Maximum number of repetitions - " + max + " word - " + rep + " " + rep1 );




    }
}