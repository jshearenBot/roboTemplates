package test.java.roboUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;

/**
 * Created by JShearen7 on 10/25/2016.
 */

public class PostgresDbConnect {

    @Test
    void test(){
        Assert.assertTrue(runSqlStatmentAndVerifyData("SELECT id FROM users;", "2"));
        Assert.assertFalse(runSqlStatmentAndVerifyData("SELECT id FROM users;", "3"));
    }

    public boolean runSqlStatmentAndVerifyData(String sqlQuery, String dataToVerify){
        Boolean dataCheck = null;
        String dbUrl = "jdbc:postgresql://localhost:5432/indy";

        //Query to Execute
        String query = sqlQuery;

        //Load mysql jdbc driver
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            //Create Connection to DB
            Connection connection = DriverManager.getConnection(dbUrl, "postgres", "postgres");
            //Create Statement Object
            Statement statment = connection.createStatement();

            // Execute the SQL Query. Store results in ResultSet
            ResultSet rs = statment.executeQuery(query);

            // While Loop to iterate through all data and print results
            while (rs.next()) {
                String dataResult = rs.getString(1);
                if (dataToVerify.equals(dataResult)) {
                    dataCheck = true;
                    System.out.println("Database check passed: " + dataToVerify + " was found.");
                }
            }
            if (dataCheck == null) {
                dataCheck = false;
                System.out.println("Database check FAILED: " + dataToVerify + " WAS NOT found!!!");
            }

            // closing DB Connection
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dataCheck;
    }
}