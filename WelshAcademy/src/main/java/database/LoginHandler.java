package database;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * handles the logins
 * @author Jack
 * @version 0.3
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
     * @throws NoSuchAlgorithmException 
     */
    public boolean login(String username,String password) throws NoSuchAlgorithmException{
        boolean validUser;
        
        try {
            //get required info
            String salt = dm.getElement("Users", "salt", "username", username);
            String saltedPass = SaltAndHash.saltAndHash(password, salt);
            String expectedPass = dm.getElement("Users", "saltedPassword", "username", username);
            
            //check password
            validUser = saltedPass.equals(expectedPass);
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.INFO, ex.getMessage());
            validUser = false;
        }
        
        return validUser;
    }
    /**
     * register a new user
     * @param username
     * @param password
     * @return true if successful
     * @throws NoSuchAlgorithmException 
     */
    public boolean registerUser(String username,String password) throws NoSuchAlgorithmException{
        boolean registered;
        
        String salt = SaltAndHash.generateSalt();
        String securePass = SaltAndHash.saltAndHash(password, salt);
        String[] inputData = {username,securePass,salt,null,null,"A2"};
        try {
            dm.add("Users", inputData);
            registered = true;
        } catch (SQLException ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.INFO, ex.getMessage());
            registered = false;
        }
        
        return registered;
    }
}
