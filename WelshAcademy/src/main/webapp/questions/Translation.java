package questions;

import java.util.Random;

/**
 *
 * @author Jack
 */
public class Translation {
    
    public final String ENG;
    public final Gender GENDER;
    public String WELSH;
    
    private final String WELSH_M;
    private final String WELSH_F;
    
    
    /**
     * create a translation object from info about it
     * @param english
     * @param welshM
     * @param welshF
     * @param gender 
     */
    public Translation(String english,String welshM,String welshF,Gender gender){
        ENG = english;
        WELSH_M = welshM;
        WELSH_F = welshF;
        GENDER = gender;
        WELSH = null; 
        
        //select which gendered version will be put in question
        if(null != gender)switch (gender) {
            case EITHER:
                Random Rand = new Random();
                int r = Rand.nextInt(2);
                if(r==0){
                    WELSH = WELSH_M;
                }else{
                    WELSH = WELSH_F;
                }   break;
            case MASCULINE:
                WELSH = WELSH_M;
                break;
            case FEMANINE:
                WELSH = WELSH_F;
                break;
            default:
                WELSH = null; //shouldn't happen
                break;
        }
    }
    
    /**
     * Uses values from array to create a translation object
     * @param dbRow information about the translation from database
     */
    public Translation(String[] dbRow){
        ENG = dbRow[0];
        WELSH_M = dbRow[1];
        WELSH_F = dbRow[2];
        
        //select which gendered version will be put in question
        if(dbRow[3].equalsIgnoreCase("masculine")){
            GENDER = Gender.MASCULINE;
            WELSH = WELSH_M;
        } else if(dbRow[3].equalsIgnoreCase("feminine")){
            GENDER = Gender.FEMANINE;
            WELSH = WELSH_F;
        }else {
            GENDER = Gender.EITHER;
            Random Rand = new Random();
            int r = Rand.nextInt(2);
            if(r==0){
                WELSH = WELSH_M;
            }else{
                WELSH = WELSH_F;
            }
        }
    }
}
