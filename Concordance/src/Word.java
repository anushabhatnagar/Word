import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent the count and line numbers for each word encountered  by the Tokenizer
 */
public class Word {
    public List getLineCount() {
        return lineCount;
    }

    public void setLineCount(List<Integer> lineCount) {
        this.lineCount = lineCount;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    List lineCount = new ArrayList();
    int wordCount =0;

    public void appendToList(int i){
        lineCount.add(i);

    }

    Word(List list, int wordCount){
          this. lineCount = list;
          this.wordCount = wordCount;

    }

}
