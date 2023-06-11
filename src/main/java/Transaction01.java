import java.sql.*;

public class Transaction01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.    getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user","password");
        //Statement statement= con.createStatement();

        //TASK-1. Using prepared statement, delete students who are from Mathematics department, from students table.
        System.out.println("-------------------TASK-1 --------------------");
        String query1 ="DELETE FROM students WHERE department ILIKE ? ";
        PreparedStatement prs = con.prepareStatement(query1);
        prs.setString(1,"Mathematics");
        prs.setString(1,"Psychology");
        int numDeletedRows =  prs.executeUpdate();

        System.out.println("Deleted ROws :"+numDeletedRows);
        //TASK-2. Insert software engineering department using prepared statement into departments table.
        // (id = 5006, name =engineering department , pass_grade=475, campus='South')
        System.out.println("----------------------- Task 2 --------------");

        String query2 ="INSERT INTO departments VALUES(?,?,?,?)";
        PreparedStatement psr2= con.prepareStatement(query2);
        psr2.setInt(1,5007);
        psr2.setString(2,"hard_engineering");
        psr2.setString(4,"south");
        psr2.setInt(3,480);

        int insertRows = psr2.executeUpdate();
        System.out.println("inserted Row :"+insertRows);



        //  statement.close();
        prs.close();
        con.close();

    }
}
