
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicole
 */
public class TokenizeCorpus {

    public static void main(String[] args) throws IOException {
        String line = new String("");
        String outfile = new String("/Users/nicole/Desktop/outputTokenizer");
        FileWriter out = new FileWriter(outfile);

        for (String arg : args) {
            // option #1: By sentence.
            DocumentPreprocessor dp = new DocumentPreprocessor(arg);
            for (List<HasWord> sentence : dp) {
                for (HasWord word : sentence) {
                    line = line.concat(word + " ");
                }

                System.out.println(sentence);
                out.append(line);
                out.append(System.lineSeparator());
                line = "";
                
            }

            out.flush();
            out.close();
        }
    }

}
