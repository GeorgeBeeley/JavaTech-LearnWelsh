package questions;

import java.io.Serializable;

/**
 * a question and answer
 * @author Jack
 */
public class Question implements Serializable{
    
    private final String rightAnswer;
    private final String question;
    private String givenAnswer;
    
    
    public Question(String question,String rightAnswer){
        this.question = question;
        this.rightAnswer = rightAnswer;
    }
    
    public void recieveAnswer(String givenAnswer){
        this.givenAnswer = givenAnswer;
    }
    
    public String getRightAnswer(){
        return rightAnswer;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public boolean checkAnswer(){
        return givenAnswer.equalsIgnoreCase(rightAnswer);
    }
}
