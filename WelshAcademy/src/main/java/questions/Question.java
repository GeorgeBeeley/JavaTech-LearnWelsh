package questions;

import java.io.Serializable;
import java.util.Random;

/**
 * a question and answer
 * @author Jack
 */
public class Question implements Serializable{
    
    private final String rightAnswer;
    private final String wrongA1;
    private final String wrongA2;
    private final String wrongA3;
    private final String question;
    private String givenAnswer;
    
    /**
     * create question
     * @param question
     * @param rightAnswer
     * @param wrong1
     * @param wrong2
     * @param wrong3 
     */
    public Question(String question,String rightAnswer,String wrong1,String wrong2,String wrong3){
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongA1 = wrong1;
        this.wrongA2 = wrong2;
        this.wrongA3 = wrong3;
    }
    /**
     * 
     * @param givenAnswer 
     */
    public void recieveAnswer(String givenAnswer){
        this.givenAnswer = givenAnswer;
    }
    /**
     * 
     * @return the right answer
     */
    public String getRightAnswer(){
        return rightAnswer;
    }
    /**
     * 
     * @return the question
     */
    public String getQuestion(){
        return question;
    }
    /**
     * 
     * @return true if correct answer given
     */
    public boolean checkAnswer(){
        return givenAnswer.equalsIgnoreCase(rightAnswer);
    }

    /**
     * @return the wrongA1
     */
    public String getWrongA1() {
        return wrongA1;
    }

    /**
     * @return the wrongA2
     */
    public String getWrongA2() {
        return wrongA2;
    }

    /**
     * @return the wrongA3
     */
    public String getWrongA3() {
        return wrongA3;
    }
    /**
     * turns the question into a string that can be used for JSON
     * @return 
     */
    public String makeJson(){
        String json = null;
        Random rand = new Random();
        //randomise answer order
        
        String a1 = null;
        String a2 = null;
        String a3 = null;
        String a4 = null;
        
        if(wrongA2 == null){ //2 answers male or female
            int r = rand.nextInt(2);
            if(r == 0){ //right answer first
                a1 = rightAnswer;
                a2 = wrongA1;
            } else{ //right answer second
                a1 = wrongA1;
                a2 = rightAnswer;
            }
        }else{ //4 answers translations
            int r = rand.nextInt(4);
            switch(r){
                case 0:
                    a1 = rightAnswer;
                    a2 = wrongA1;
                    a3 = wrongA2;
                    a4 = wrongA3;
                    break;
                case 1:
                    a1 = wrongA1;
                    a2 = rightAnswer;
                    a3 = wrongA2;
                    a4 = wrongA3;
                    break;
                case 2:
                    a1 = wrongA2;
                    a2 = wrongA1;
                    a3 = rightAnswer;
                    a4 = wrongA3;
                    break;
                case 3:
                    a1 = wrongA3;
                    a2 = wrongA1;
                    a3 = wrongA2;
                    a4 = rightAnswer;
                    break;
            }
        }
        
        //make the string
        StringBuilder strB = new StringBuilder();
        strB.append("{\"Question\": \"").append(question).append("\",");
        strB.append("\"Correct\": \"").append(rightAnswer).append("\",");
        strB.append("\"A1\": \"").append(a1).append("\",");
        strB.append("\"A2\": \"").append(a2).append("\",");
        strB.append("\"A3\": \"").append(a3).append("\",");
        strB.append("\"A4\": \"").append(a4).append("\"}");
        json = strB.toString();
        
        return json;
    }
}
