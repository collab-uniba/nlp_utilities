
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.PTBTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class LexiconExtraction {

    private CreateNGrams t = new CreateNGrams();

    /**
     * Counts the occurrences of every Ngrams of the input text.
     *
     * @return a map of n-grams and occurrences
     *
     */
    public SortedMap<String, Integer> getNgramsOccurrences(File f, int n) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        int temp;
        Map<String, Integer> ngramsLine;
        SortedMap<String, Integer> ngramsText = new TreeMap<>();
        while ((line = br.readLine()) != null) {
            temp = 0;
            ngramsLine = getNgramsOccurrences(line.toLowerCase(), 1);
            for (String s : ngramsLine.keySet()) {
                if (ngramsText.get(s) == null) {
                    ngramsText.put(s, 1);
                } else {
                    temp = ngramsText.get(s);
                    ngramsText.remove(s);
                    ngramsText.put(s, temp + 1);
                }
            }
        }
        return ngramsText;
    }

    /**
     * Counts the occurrences of every Ngrams of the input string.
     *
     * @return a map of n-grams and occurrences
     */
    private Map<String, Integer> getNgramsOccurrences(String input, int n) {
        int occurrences;
        Map<String, Integer> mapOccurences = new HashMap<>();
        Collection<String> ss = t.getNgramsCollections(input, n);
        for (String string : ss) {
            occurrences = 0;
            if (mapOccurences.keySet().contains(string)) {
                occurrences = mapOccurences.get(string);
                occurrences++;
                mapOccurences.put(string, occurrences);
            } else {
                mapOccurences.put(string, 1);
            }
        }
        return mapOccurences;
    }
}
