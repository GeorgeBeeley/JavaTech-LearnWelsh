package questions;

import java.util.Random;

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
     * @param t the translation object for word being tested
     * @return 
     */
    public static String newQuestion(Translation t){
        int r = RAND.nextInt(3);
        String question = QUESTIONS[r];
        switch(r){
            case 0:
                question = question + t.WELSH;
                break;
            case 1:
                question = question + t.WELSH;
                break;
            case 2:
                question = question + t.ENG;
                break;
        }
        return question;
    }
}
