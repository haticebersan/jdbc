import java.sql.*;

public class PreparedStatements {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user","password");
        Statement statement = con.createStatement();

        //TASK-1. Update pass_grade to 475 of Mathematics department (use PreparedStatement)

        //Normal
        // String query1="UPDATE departments SET pass_grade =475 WHERE department ILIKE 'mathematics'";

        //parameterized Query

        //Create Stamens with Parm...

        System.out.println("-----------Task 1------------------");
        String query2="UPDATE departments SET pass_grade =? WHERE department ILIKE ?";
        PreparedStatement prs= con.prepareStatement(query2);
        prs.setInt(1,480);
        prs.setString(2,"mathematics");
        int numOfUpdateRows = prs.executeUpdate();
        System.out.println("numOfUpdateRows "+numOfUpdateRows);

        //TASK-2. Update pass_grade to 455 of Literature department (use PreparedStatement)

        prs.setString(2,"Literature");
        prs.setInt(1,455);//ctrl+D or Shift +D to duplicate code

        int numOfUpdateRows2 = prs.executeUpdate();
        System.out.println("numOfUpdateRows "+numOfUpdateRows2);


        statement.close();
        prs.close();
        con.close();


    }
}
