package database;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * handles the logins
 * @author Jack
 * @version 1
 */
public class LoginHandler {
    
    private final DatabaseManager dm;
    
    public LoginHandler(DatabaseManager dm){
        this.dm = dm;
    }
    /**
     * check for user that exists and if the password is correct
     * @param email
     * @param password
     * @return if username and password are valid 
     */
    public Login login(String email,String password){
        
        Login login = Login.FAILED;
        
        try {
            
            //check user exists
            String[] existingUsers = dm.getColumn("Users", "email");
//            System.out.println(existingUsers.length);
            if(existingUsers.length == 0){
                login = Login.FAILED;
                return login;
            }
            boolean exists = false;
            for(String user: existingUsers){
                if(user.equals(email)){
                    exists = true;
                    break;
                }
            }
            
            
            if(!exists){
                login = Login.NO_USER;
                return login;
            }
            
            
            //get required info
            String salt = dm.getElement("Users", "salt", "email", email);
            String saltedPass = SaltAndHash.saltAndHash(password, salt);
            String expectedPass = dm.getElement("Users", "saltedPassword", "email", email);
            
            //check password
            boolean validUser = saltedPass.equals(expectedPass);
            if(validUser){
                login = Login.SUCCESS;
            }else{
                login = Login.WRONG_PASS;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.INFO, ex.getMessage());
            login = Login.FAILED;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, ex.getMessage());
            login = Login.FAILED;
        }
        
        return login;
    }
    /**
     * register a new user
     * @param password
     * @param forname
     * @param email
     * @return successful or type of error 
     */
    public Register registerUser(String email,String password,String forname,String surname){
        
        Register reg = Register.FAILED;
        
        
        try{
            String salt = SaltAndHash.generateSalt();
            String securePass = SaltAndHash.saltAndHash(password, salt);
            String[] inputData = {"0",securePass,salt,forname,surname,email,"Student"};
            //check if already user exists
            String[] existingUsers = dm.getColumn("Users", "email");
            if(existingUsers.length == 0){ //problem accessing database or table is empty due to some error
                reg = Register.FAILED;
                return reg;
            }
            boolean exists = false;
            for(String userEmail: existingUsers){
                if(userEmail.equals(email)){
                    exists = true;
                    break;
                }
            }
            
            if(exists){
                reg = Register.ALREADY_EXISTS;
                return reg;
            }
            
            dm.add("Users", inputData);
            reg = Register.REGISTERED;
        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.INFO, ex.getMessage());
            reg = Register.FAILED;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
            reg = Register.FAILED;
        }
        
        return reg;
    }
    /**
     * register new user with specific rank
     * @param username
     * @param password
     * @param forname
     * @param surname
     * @param email
     * @param permisions
     * @return successful or type of error 
     */
    public Register registerUser(String password,String forname,String surname,String email,String permisions){
        
        Register reg = Register.FAILED;
        
        
        try{
            String salt = SaltAndHash.generateSalt();
            String securePass = SaltAndHash.saltAndHash(password, salt);
            String[] inputData = {"0",securePass,salt,forname,surname,email,permisions};
            //check if already user exists
            String[] existingUsers = dm.getColumn("Users", "email");
//            System.out.println(existingUsers.length);
            if(existingUsers.length == 0){ //error either table empty or unable to access
                reg = Register.FAILED;
                return reg;
            }
            boolean exists = false;
            for(String user: existingUsers){
                if(user.equals(email)){
                    exists = true;
                    break;
                }
            }
            
            if(exists){
                reg = Register.ALREADY_EXISTS;
                return reg;
            }
            
            dm.add("Users", inputData);
            reg = Register.REGISTERED;
        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.INFO, ex.getMessage());
            reg = Register.FAILED;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
            reg = Register.FAILED;
        }
        
        return reg;
    }
}
