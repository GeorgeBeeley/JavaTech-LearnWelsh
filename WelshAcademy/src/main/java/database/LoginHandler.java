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
     * @param username
     * @param password
     * @return if username and password are valid 
     */
    public Login login(String username,String password){
        
        Login login = Login.FAILED;
        
        try {
            
            //check user exists
            String[] existingUsers = dm.getColumn("Users", "username");
//            System.out.println(existingUsers.length);
            if(existingUsers.length == 0){
                login = Login.FAILED;
                return login;
            }
            boolean exists = false;
            for(String user: existingUsers){
                if(user.equals(username)){
                    exists = true;
                    break;
                }
            }
            
            
            if(!exists){
                login = Login.NO_USER;
                return login;
            }
            
            
            //get required info
            String salt = dm.getElement("Users", "salt", "username", username);
            String saltedPass = SaltAndHash.saltAndHash(password, salt);
            String expectedPass = dm.getElement("Users", "saltedPassword", "username", username);
            
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
     * @param username
     * @param password
     * @param forname
     * @param email
     * @return successful or type of error 
     */
    public Register registerUser(String username,String password,String forname,String email){
        
        Register reg = Register.FAILED;
        
        
        try{
            String salt = SaltAndHash.generateSalt();
            String securePass = SaltAndHash.saltAndHash(password, salt);
            String[] inputData = {username,securePass,salt,forname,null,email,"A2"};
            //check if already user exists
            String[] existingUsers = dm.getColumn("Users", "username");
//            System.out.println(existingUsers.length);
            if(existingUsers.length == 0){
                reg = Register.FAILED;
                return reg;
            }
            boolean exists = false;
            for(String user: existingUsers){
                if(user.equals(username)){
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
    public Register registerUser(String username,String password,String forname,String surname,String email,String permisions){
        
        Register reg = Register.FAILED;
        
        
        try{
            String salt = SaltAndHash.generateSalt();
            String securePass = SaltAndHash.saltAndHash(password, salt);
            String[] inputData = {username,securePass,salt,forname,surname,email,permisions};
            //check if already user exists
            String[] existingUsers = dm.getColumn("Users", "username");
//            System.out.println(existingUsers.length);
            if(existingUsers.length == 0){
                reg = Register.FAILED;
                return reg;
            }
            boolean exists = false;
            for(String user: existingUsers){
                if(user.equals(username)){
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
