import java.io.*;
import java.util.*;

/**
 ** Main class that would read the file sample.txt and print the count and line number for each word  read
 * from the file
 */
public class Main {

    public static void main(String[] args){
        String strLine;
        int count = 1;
        TreeMap<String, Word> wordStat = new TreeMap<String, Word>();

        try{
            FileReader input = new FileReader(new File("sample.txt"));
            BufferedReader bufRead = new BufferedReader(input);

            /*Tokenize the string read from the file based on delimiters like ',', ';',':', '.', ' '  or '-'
            * and enter it into a TreeMap that will maintain the alphabetical order of words read.
            * The Key will be the word and value will be the Object Word thatcontains the count and list of occurences for the word
            * */
            while ((strLine = bufRead.readLine()) != null)   {
                System.out.print("\n"+strLine);
                String delims = " ,;:.-";
                StringTokenizer tokenizer = new StringTokenizer(strLine, delims);
                while (tokenizer.hasMoreTokens()) {
                    String word =  tokenizer.nextToken().toLowerCase();
                    if(wordStat.containsKey(word))
                    {
                        Word temp = wordStat.get(word);

                        temp.setWordCount(temp.getWordCount() + 1);
                        temp.appendToList(count);
                    }  else
                    {
                        List list = new ArrayList();
                        list.add(count);
                        wordStat.put(word, new Word(list ,1));
                    }
                }
                count ++;
            }

            for(Map.Entry entry : wordStat.entrySet()){
                 Word w = (Word) entry.getValue();
                System.out.print("\n"+entry.getKey()+ "\t"+w.getWordCount() + "\t"+ w.getLineCount());

            }



        }
        catch(IOException e){
            System.out.print("Error reading file"+ e.getMessage());
            e.printStackTrace();
        }



    }
}