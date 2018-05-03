package questions;

import database.DatabaseManager;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * generates random questions using a translated pair of words (1 welsh, 1 English)
 * @author Jack
 */
public final class QuestionGenerator {
    
    private static final String[] QUESTIONS = 
        {"What is the gender of the Welsh noun ",
        "What is the meaning of the Welsh noun ",
        "What is the Welsh noun for the English word "};
    private static final Random RAND = new Random();
    
    /**
     * randomly generate a question from a translations
     * @param correctTranslation the translation object for word being tested
     * @param t1 wrong translation
     * @param t2 wrong translation
     * @param t3 wrong translation
     * @return 
     */
    public static Question newQuestion(Translation correctTranslation,Translation t1,Translation t2,Translation t3){
        int r = RAND.nextInt(3);
        String question = QUESTIONS[r];
        String answer = null;
        String wrong1 = null;
        String wrong2 = null;
        String wrong3 = null;
        
        switch(r){
            case 0:
                question = question + correctTranslation.WELSH;
                answer = correctTranslation.GENDER.toString();
                switch(correctTranslation.GENDER){
                    case MASCULINE:
                        wrong1 = Gender.FEMANINE.toString();
                        break;
                    case FEMANINE:
                        wrong1 = Gender.MASCULINE.toString();
                        break;
                }
                break;
            case 1:
                question = question + correctTranslation.WELSH;
                answer = correctTranslation.ENG;
                wrong1 = t1.ENG;
                wrong2 = t2.ENG;
                wrong3 = t3.ENG;
                break;
            case 2:
                question = question + correctTranslation.ENG;
                answer = correctTranslation.WELSH;
                wrong1 = t1.WELSH;
                wrong2 = t2.WELSH;
                wrong3 = t3.WELSH;
                break;
        }
        Question q = new Question(question,answer,wrong1,wrong2,wrong3);
        return q;
    }
    /**
     * make 20 questions
     * @return a JSON as a string with 20 questions
     */
    public String questionSet(){
        String json = null;
        StringBuilder strB = new StringBuilder();
        try {
            //get database
            DatabaseManager dbm = new DatabaseManager();
            int numWords = dbm.count("Words");
            Random rand = new Random();
            
            strB.append("{\"Questions\": [");
            //make 20 questions make array of json strings
            for(int i=0;i<20;i++){
                int r = rand.nextInt(numWords)+1;
                String[] aRow = dbm.getRow("Words", r);
                Translation correctTranslation = new Translation(aRow);
                
                Translation[] translationSet = new Translation[4];
                translationSet[0] = correctTranslation;
                
                //get wrong answers
                for(int j=1;j<=3;j++){
                    r = rand.nextInt(numWords)+1;
                    String[] anoutherRow = dbm.getRow("Words", r);
                    Translation t = new Translation(anoutherRow);
                    translationSet[j] = t;
                }
                
                //create question
                Question q = newQuestion(translationSet[0],translationSet[1],translationSet[2],translationSet[3]);
                String qJson = q.makeJson();
                strB.append(qJson);
                if(i<19){
                    strB.append(",");
                }
            }
            strB.append("]}");
            json = strB.toString();
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            Logger.getLogger(QuestionGenerator.class.getName()).log(Level.SEVERE, null, ex);
            json = null;
        }
        
        return json;
    }
}
