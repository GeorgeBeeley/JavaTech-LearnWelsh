package database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

/**
 * salts and hashes passwords
 * @author Jack
 * @version 0.3
 */
public class SaltAndHash {
    
    private SaltAndHash() {
    }
    
    public static SaltAndHash getInstance() {
        return SaltAndHashHolder.INSTANCE;
    }
    
    private static class SaltAndHashHolder {
        private static final SaltAndHash INSTANCE = new SaltAndHash();
    }
    /**
     * creates a random string to salt a password with
     * @return random salt
     */
    public static String generateSalt(){
        Random r = new Random();
        byte[] bytes = new byte[16];
        
        r.nextBytes(bytes);
        return Arrays.toString(bytes);
    }
    
    /**
     * adds a salt to password the secure hashes it
     * @param password
     * @param salt
     * @return a salted and hash secure password
     * @throws NoSuchAlgorithmException
     */
    public static String saltAndHash(String password,String salt) throws NoSuchAlgorithmException{
        String salted = salt + password; //salt password
        
        //secure hash
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salted.getBytes());
        byte byteData[] = md.digest();
        
        //put hashed into string format
        StringBuilder hexString = new StringBuilder();
        for(int i=0;i<byteData.length;i++){
            String hex = Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
