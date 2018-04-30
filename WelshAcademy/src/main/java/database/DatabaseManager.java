package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * manages database requests
 * @version 1
 * @author Jack
 */
public class DatabaseManager {
    
    Connection conn;
    
    public DatabaseManager() throws IOException,ClassNotFoundException, SQLException{
        InputStream stream = DatabaseManager.class.getResourceAsStream("/database.properties");
        SimpleDataSource.init(stream);
        conn = SimpleDataSource.getConnection();
    }
    
    public boolean closeConnection() throws SQLException{
        conn.close();
        return true;
    }
    /**
     * add a row to a table
     * @param table
     * @param columnNames name of column for inputData[]
     * @param inputData
     * @return if successful
     * @throws SQLException 
     */
    public int add(String table,String[] columnNames,Object[] inputData)throws SQLException{
        int changes;
        
        //create command string
        StringBuilder strB = new StringBuilder();
        strB.append("INSERT INTO ").append(table).append("(");
        int i = 0;
        for(String s : columnNames){
            strB.append(s);
            if(inputData.length != ++i){
                strB.append(",");
            }
        }
        
        strB.append(") VALUE (");
        
        i = 0;
        for(Object s :inputData){
            strB.append("?");
            if(inputData.length != ++i){
                strB.append(",");
            }
        }
        strB.append(")");
        
        String cmnd = strB.toString();
        
        try (PreparedStatement st = conn.prepareStatement(cmnd)) {
            //add params to insert
            i = 1;
            for(Object s : inputData){
                st.setObject(i, s);
                i++;
            }   
            changes = st.executeUpdate();
        }
        return changes;
    }
    
    /**
     * add data to a table
     * @param table the table to add to
     * @param inputData data to add
     * @return where was successful
     * @throws SQLException 
     */
    public int add(String table,String[] inputData)throws SQLException{
        int added;
        //create command string
        StringBuilder strB = new StringBuilder();
        strB.append("INSERT INTO ").append(table).append(" VALUE (");
        int i = 0;
        for(String s :inputData){
            strB.append("?");
            if(inputData.length != ++i){
                strB.append(",");
            }
        }
        strB.append(")");
        
        String cmnd = strB.toString();
        
        try (PreparedStatement st = conn.prepareStatement(cmnd)) {
            //add params to insert
            i = 1;
            for(String s : inputData){
                st.setObject(i, s);
                i++;
            }   
            added = st.executeUpdate();
            
        }
        
        return added;
    }
    /**
     * remove an item from table
     * @param table table to remove from
     * @param primaryKey primary key of table
     * @param pkValue the value of the primary key
     * @return 
     * @throws java.sql.SQLException 
     */
    public int delete(String table,String primaryKey,String pkValue) throws SQLException{
        int removed;
        
        String command = ("DELETE FROM " + table + " WHERE " + primaryKey + " = ?");
        
        try(PreparedStatement st = conn.prepareStatement(command)) {
            if(table.equals("Users")){
                st.setString(1, pkValue);
            }else{
                st.setInt(1,Integer.parseInt(pkValue));
            }
            removed = st.executeUpdate();
            
        }
        
        return removed;
    }
    /**
     * update a field in table
     * @param table
     * @param conditionCol column with a condition being checked
     * @param conditionValue 
     * @param updateAtribute to set
     * @param newValue value to set too
     * @return true if successful
     * @throws SQLException 
     */
    public int update(String table,String conditionCol,String conditionValue,String updateAtribute,String newValue) throws SQLException{
        int updated;
        
        String command = "UPDATE "+ table 
                + " SET "+ updateAtribute +" = ? "
                + "WHERE " + conditionCol + " = ?;";
        try(PreparedStatement st = conn.prepareStatement(command)) {
            
            if(newValue.equalsIgnoreCase("true")){
                st.setBoolean(1, true);
            }
            else if(newValue.equalsIgnoreCase("false")){
                st.setBoolean(1, false);
            }
            else if(newValue.matches("-?\\d+")){
                st.setInt(1, Integer.parseInt(newValue));
            }
            else{
                st.setString(1,newValue);
            }
            
            if(conditionValue.equalsIgnoreCase("true")){
                st.setBoolean(2, true);
            }
            else if(conditionValue.equalsIgnoreCase("false")){
                st.setBoolean(2, false);
            }
            else if(conditionValue.matches("-?\\d+")){
                st.setInt(2, Integer.parseInt(conditionValue));
            }
            else{
                st.setString(2,conditionValue);
            }
            
            updated = st.executeUpdate();
        }
        
        return updated;
    }
    /**
     * update multiple fields with multiple conditions
     * @param table
     * @param updateFields
     * @param newValues
     * @param conditions
     * @param conditionValues
     * @return number of rows updated
     * @throws java.sql.SQLException
     */
    public int complexUpdate(String table,String[] updateFields,String[] newValues,String[] conditions,String[] conditionValues) throws SQLException{
        int updated = 0;
        //create statement
        StringBuilder strB = new StringBuilder();
        strB.append("UPDATE ").append(table).append(" SET ");
        
        for(String str : updateFields){
            strB.append(str);
            strB.append(" = ? ");
            if(!updateFields[updateFields.length-1].equals(str)){
                strB.append(", ");
            }
            
        }
        strB.append("WHERE ");
        int i = 0;
        while(i<conditions.length){
            strB.append(conditions[i]);
            strB.append(" = ? ");
            i++;
            if(i < conditions.length){
                strB.append("AND ");
            }
        }
        String cmd = strB.toString();
        
        PreparedStatement st = conn.prepareStatement(cmd);
        //insert parameters
        i = 1;
        for(String str : newValues){
            if(str.equalsIgnoreCase("true")){
                st.setBoolean(i, true);
            }
            else if(str.equalsIgnoreCase("false")){
                st.setBoolean(i, false);
            }
            else if(str.matches("-?\\d+")){
                st.setInt(i, Integer.parseInt(str));
            }
            else{
                st.setString(i,str);
            }
            i++;
        }
        for(String str : conditionValues){
            if(str.equalsIgnoreCase("true")){
                st.setBoolean(i, true);
            }
            else if(str.equalsIgnoreCase("false")){
                st.setBoolean(i, false);
            }
            else if(str.matches("-?\\d+")){
                st.setInt(i, Integer.parseInt(str));
            }
            else{
                st.setString(i,str);
            }
            i++;
        }
        System.out.println(st.toString());
        
        updated = st.executeUpdate();

        
        return updated;
    }
    /**
     * get a column
     * @param table
     * @param column
     * @return array of column
     * @throws SQLException 
     */
    public String[] getColumn(String table,String column) throws SQLException{
        
        String[] result;
        
        String command = "SELECT "+ column +" FROM "+ table;
        Statement st = conn.createStatement();
        
//        st.setString(1, column);
        ResultSet rs = st.executeQuery(command);
//        ResultSetMetaData rsmd = rs.getMetaData();
        
        
//        result = (String[]) rs.getArray(column).getArray();
        
        ArrayList<String> list = new ArrayList();
        if(rs.isBeforeFirst())
            rs.next();
            
//        int col = rs.findColumn(column);
        
        try{
            do{
                String str = rs.getString(column);
                list.add(str);
            }while(rs.next());
            result = new String[list.size()];
            result = list.toArray(result);
        }finally{
            st.close();
        }
        
        return result;
    }
    
    /**
     * get a single element from a row
     * @param table
     * @param column field wanted
     * @param pk name of primary key column
     * @param pkValue value of the primary key
     * @return element requested
     * @throws java.sql.SQLException
     */
    public String getElement(String table,String column,String pk,String pkValue) throws SQLException{
        String result;
        String command = ("SELECT " + column +" FROM "+ table +" WHERE "+ pk +" = ?");
        try(PreparedStatement st = conn.prepareStatement(command)) {
            
            if(pkValue.equalsIgnoreCase("true")){
                st.setBoolean(1, true);
            }
            else if(pkValue.equalsIgnoreCase("false")){
                st.setBoolean(1, false);
            }
            else if(pkValue.matches("-?\\d+")){
                st.setInt(1, Integer.parseInt(pkValue));
            }
            else{
                st.setString(1,pkValue);
            }

            
            ResultSet rs  = st.executeQuery();
            if(rs.isBeforeFirst())
                rs.next();
            
            result = rs.getString(column);
        }
        return result;
    }
    /**
     * gets a 2d array representation of result of search
     * @param table
     * @param searchTerms field name followed by value alternating for search
     * @return
     * @throws SQLException 
     */
    public String[][] search(String table,String[] searchTerms) throws SQLException{
        String[][] result;
        if(searchTerms.length % 2 != 0)
            return null;
        
        //create statement
        StringBuilder strB = new StringBuilder();
        strB.append("SELECT * FROM ").append(table).append(" WHERE ");
        
        int i = 0;
        String[] inputs = new String[searchTerms.length/2];
        while(i<searchTerms.length){
            strB.append(searchTerms[i]);
            strB.append(" = ? ");
            i++;
            inputs[i/2] = searchTerms[i];
            i++;
            if(i < searchTerms.length){
                strB.append("AND ");
            }
        }
        String cmd = strB.toString();
        
        PreparedStatement st = conn.prepareStatement(cmd);
        //insert parameters
        i = 1;
        for(String str : inputs){
            if(str.equalsIgnoreCase("true")){
                st.setBoolean(i, true);
            }
            else if(str.equalsIgnoreCase("false")){
                st.setBoolean(i, false);
            }
            else if(str.matches("-?\\d+")){
                st.setInt(i, Integer.parseInt(str));
            }
            else{
                st.setString(i,str);
            }
            i++;
        }
        System.out.println(st.toString());
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            //turns results table into 2d array
            
            LinkedList<String[]> res;
            res = new LinkedList<>();
            i = 0;
            int rows = 0;
            do{
                String[] resRow = new String[cols];
                for(int j = 1;j<=cols;j++){
                     resRow[j-1] = rs.getString(j);
                }
                res.add(resRow);
                rows++;
                i++;
            }while(rs.next());

            result = new String[rows][cols];
            for(i=0;i<res.size();i++){
                result[i] = res.get(i);
            }

            return result;
        }else{
            return null; //empty result set
        }
    }
    /**
     * gets a row from the database matching search
     * @param table to get row from
     * @param searchTerms field name followed by field value alternating
     * @return array of the row
     * @throws SQLException 
     */
    public String[] getRow(String table,String[] searchTerms) throws SQLException{
        String[] row = null;
        
        if(searchTerms.length % 2 != 0)
            return null;
        
        //create statement
        String cmd = "SELECT * FROM " + table + " WHERE " + searchTerms[0] + " = ?";
        PreparedStatement st = conn.prepareStatement(cmd);
        
        if(searchTerms[1].equalsIgnoreCase("true")){
            st.setBoolean(1, true);
        }
        else if(searchTerms[1].equalsIgnoreCase("false")){
            st.setBoolean(1, false);
        }
        else if(searchTerms[1].matches("-?\\d+")){
            st.setInt(1, Integer.parseInt(searchTerms[1]));
        }
        else{
            st.setString(1,searchTerms[1]);
        }
        
        System.out.println(st.toString());
        ResultSet rs = st.executeQuery();
        
        if(rs.next()){
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            
            row = new String[cols];
            for(int i = 0; i < cols; i++){
                row[i] = rs.getString(i+1);
            }
        
        
        }
        return row;
    }
    /**
     * gets the size of a table
     * @param table
     * @return number of rows counted
     * @throws java.sql.SQLException
     */
    public int count(String table) throws SQLException{
        int count = 0;
        
        String cmd = "SELECT COUNT(*) FROM " + table;
        
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(cmd);
            
            //read the single cell with count
            rs.next();
            count = rs.getInt(1);
        }
        
        return count;
    }
    
//    /**
//     * run a custom made sql command
//     * @param command sql to run
//     * @return string formatted roughly as table
//     * @throws SQLException 
//     */
//    public String customSelect(String command) throws SQLException{
//        Statement st = conn.createStatement();
//        ResultSet rs  = st.executeQuery(command); 
//        ResultSetMetaData rsmd = rs.getMetaData();
//        int columns = rsmd.getColumnCount();
//        
//        StringBuilder strB  = new StringBuilder();
//        try{
//            while(rs.next())
//            {
//                for(int i = 1;i <= columns;i++){
//                     strB.append(rs.getString(i)).append("\t\t");
//                }
//               strB.append("\n");
//            }
//        }finally{
//            st.close();
//        }
//        
//        return strB.toString();
//    }
}
