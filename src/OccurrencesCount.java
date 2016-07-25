import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class OccurrencesCount {

    private LexiconExtraction lex = new LexiconExtraction();

    /**
     * Given a input corpus and list of n-grams,
     * @return a map of list's n-grams with their occurrences in the input corpus
     */
    public SortedMap<String, Integer> getOccurrences(File input, int n, File list) throws Exception {
        SortedMap<String, Integer> m = new TreeMap<>();
        SortedMap<String,Integer> map = lex.getNgramsOccurrences(input, n);

        List<String> l = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(list.getPath()));
        String line;
        while((line = br.readLine())!=null){
            l.add(line);
        }
        br.close();

        for (String s:l) {
           if(map.containsKey(s))
               m.put(s, map.get(s));
           else
               m.put(s, 0);
        }
        return m;
    }

}
