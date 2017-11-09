package bot.db;

import java.sql.*;

import static bot.db.DBConstants.*;

public class DBUtils {

    public static void main(String[] args) {
        Connection con = null ;
        DatabaseMetaData dbmd = null ;

        try {
            Class.forName(driver) ;
            con = DriverManager.getConnection(url);
            Statement statement = con.createStatement();
            dbmd = con.getMetaData();
            statement.execute(DROP_CUSTOMER_TABLE);
            statement.execute(CREATE_CUSTOMER_TABLE);
            statement.execute(INSERT_CUSTOMER);
            ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER");
            while (rs.next()){
                System.out.println(rs.getString("FIRSTNAME"));
            }
            // Use the database connection somehow.

        } catch (SQLException se) {
            printSQLException(se) ;
        } catch(ClassNotFoundException e){
            System.out.println("JDBC Driver " + driver + " not found in CLASSPATH") ;
        }finally {
            if(con != null){
                try{
                    con.close() ;
                } catch(SQLException se){
                    printSQLException(se) ;
                }
            }
        }
    }

    private static void printSQLException(SQLException se) {
        while(se != null) {
            System.out.print("SQLException: State:   " + se.getSQLState());
            System.out.println("Severity: " + se.getErrorCode());
            System.out.println(se.getMessage());

            se = se.getNextException();
        }
    }

    private static void printSQLWarning(SQLWarning sw) {
        while(sw != null) {
            System.out.print("SQLWarning: State=" + sw.getSQLState()) ;
            System.out.println(", Severity = " + sw.getErrorCode()) ;
            System.out.println(sw.getMessage());

            sw = sw.getNextWarning();
        }
    }
}
