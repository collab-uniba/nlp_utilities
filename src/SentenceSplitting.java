import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.io.File;
import java.util.*;

public class SentenceSplitting {

    /**
     * Divide a text into sentences.
     * @return a list of sentences extracted from the input text
     */
    public Collection splitSentence(File input){
        Collection<String> sentences = new ArrayList<>();
        DocumentPreprocessor dp = new DocumentPreprocessor(input.getPath());
        for (List<HasWord> sentence : dp) {
            String s = "";
            for (HasWord ss: sentence) {
                s += ss + " ";
            }
            sentences.add(s.substring(0, s.length()-1));
        }
        return sentences;
    }

}
