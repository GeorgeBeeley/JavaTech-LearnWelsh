package questions;

/**
 * stores the english, welsh and gender of a word. for use with question generator
 * @author Jack
 */
public class Translation {
    
    public final String ENG;
    public final Gender GENDER;
    public final String WELSH;
    
    
    /**
     * create a translation object from info about it
     * @param english
     * @param welsh
     * @param gender 
     */
    public Translation(String english,String welsh,Gender gender){
        ENG = english;
        WELSH = welsh;
        GENDER = gender;
    }
    
    /**
     * Uses values from array to create a translation object
     * @param dbRow information about the translation from database
     */
    public Translation(String[] dbRow){
        ENG = dbRow[0];
        WELSH = dbRow[1];
        
        //select which gendered version will be put in question
        if(dbRow[3].equalsIgnoreCase("masculine")){
            GENDER = Gender.MASCULINE;
        } else {
            GENDER = Gender.FEMANINE;
        }
    }
}
