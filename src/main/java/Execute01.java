import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.step : Register Driver
        Class.forName("org.postgresql.Driver");
        //2.Step : Create a connection to get Database

        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user","password");

       //3.Step: Create a statements to execute SQL queries

       Statement statement =  con.createStatement();
        if ( con != null) {
            System.out.println("Connection is successfully");
        }else {
            System.out.println("Connection is not successfully");
        }

        //4.step: Execute SQL query
        //TASK: create a table named "employee" with column names of :
        // "employee_id", "employee_name", "salary"
       // boolean sql1 = statement.execute("CREATE TABLE employee (employee_id INT,employee_name VARCHAR(50),salary REAL)");
        //System.out.println("sql1 :" + sql1);


        /*
          //execute () returns boolean value and can be used for DDL data definition language or Data Query Language
          execute() method can be used in DDL(Data Definition Language --> Crate Table,
                Drop Table, Alter Table) and DQL (Data Query Language --> Select)
            1) If you use execute() method with DDL everytime you will get false.
            2) If you use execute() method with DQL  you will get false or true.
            If you get the resultSet object as return you will get true otherwise you will get false.
         */
        //TASK 2: add Varchar (20) column name "city" to employee table
         //String query = "ALTER TABLE employee ADD COLUMN city VARCHAR(20)";
        // boolean sql2 =statement.execute(query);
        //System.out.println("sql2 = " + sql2);
        String query = "DROP TABLE employee";
        boolean sql3 = statement.execute(query);
        System.out.println("sql3: " + sql3);

        //5.step
        statement.close();
        con.close();// it is used realized the resource from memory

    }
}
