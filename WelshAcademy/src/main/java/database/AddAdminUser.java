package database;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * adds an admin user to the database.
 * for use when database is first set up / reset
 * @author Jack
 */
public class AddAdminUser {

    /**
     * adds admin user to database throws various exception if there is an error causing failure
     * @param args the command line arguments
     * @throws java.sql.SQLException if error
     * @throws java.io.IOException if error
     * @throws java.lang.ClassNotFoundException if error
     * @throws java.security.NoSuchAlgorithmException if error
     */
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, NoSuchAlgorithmException {
        DatabaseManager dm = new DatabaseManager();
        String table = "Users";
        String salt = SaltAndHash.generateSalt();
        String saltedPass = SaltAndHash.saltAndHash("admin", salt);
        String forename = "Jack";
        String surname = "Tindall";
        String email = "eeu872@bangor.ac.uk";
        String[] data = {"0",saltedPass,salt,forename,surname,email,"Admin","0"};
        dm.add(table, data);
        dm.closeConnection();
    }
    
}
