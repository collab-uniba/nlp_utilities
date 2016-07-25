
import java.io.File;
import java.util.Collection;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicole
 */
public class Test {
    
    
    public static void main(String[] args) {
    
//            SentenceSplitting ss = new SentenceSplitting();
//            Collection<String> c = ss.splitSentence(new File("/Users/nicole/Desktop/inputtest"));
//            for (String s: c)
//            {
//                System.out.println(s);
//            }
//            
            LexiconExtraction le = new LexiconExtraction();
            
            
        try {
            //estrazione dizionario unigrammi
            SortedMap<String, Integer> sm = le.getNgramsOccurrences(new File("/Users/nicole/Desktop/outputTokenizer"), 1);
            
            for (String s: sm.keySet())
            {
                
                System.out.println(s + " " + sm.get(s).toString());
                
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            

        
        
    }
    
    
}
