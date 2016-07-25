
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;
import java.io.FileReader;
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
public class TokenizerDemo {
    
     public static void main(String[] args) throws IOException {
    for (String arg : args) {
      // option #1: By sentence.
      DocumentPreprocessor dp = new DocumentPreprocessor(arg);
      for (List<HasWord> sentence : dp) {
        System.out.println(sentence);
      }
      // option #2: By token
      PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<>(new FileReader(arg), new CoreLabelTokenFactory(), "");
      while (ptbt.hasNext()) {
        CoreLabel label = ptbt.next();
        System.out.println(label);
      }
    }
  }
}
