import edu.stanford.nlp.util.StringUtils;

import java.util.*;

public class Tokenizer {

    /*
     * Returns a collection of n-grams from an input string
     */
    public Collection<String> getNgramsCollections(String input, int n){
        Collection<String> ss = StringUtils.getNgrams(new ArrayList<>(Arrays.asList(input.split("\\s+"))), n, n);
        if(n>1){
            Iterator<String> iter = ss.iterator();
            ss = new ArrayList<>();
            while(iter.hasNext())
                ss.add(iter.next().replace(" ", "_"));
        }
        return ss;
    }

    /*
     * Returns a string of n-grams separated by spaces from an input string
     */
    public String getNgramsString(String input, int n){
        Collection<String> ss = StringUtils.getNgrams(new ArrayList<>(Arrays.asList(input.split("\\s+"))), n, n);
        if(n>1){
            Iterator<String> iter = ss.iterator();
            ss = new ArrayList<>();
            while(iter.hasNext())
                ss.add(iter.next().replace(" ", "_"));
        }
        String tokens = "";
        for (String s: ss) {
            tokens += s + " ";
        }
        return tokens;
    }
}
