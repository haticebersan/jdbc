import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        //Create Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user","password");
         Statement statement = con.createStatement();
        //TASK-1. GET/SELECT  "country_name" from countries table with ID between 5 and 10

        System.out.println("---------------------Task1-----------------");
        String query1 = " SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10";
         boolean sql1 = statement.execute(query1);
        System.out.println("sql1 = " + sql1);

         ResultSet resultSet =statement.executeQuery(query1);
        System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println(resultSet.getString("country_name"));
        }
        //TASK - 2: Get "phone_code" and "country_name" from countries table,
        // whose phone code is greater than 200
        System.out.println("----------------Task 2-----------------");

        String query2="SELECT phone_code ,country_name FROM countries WHERE phone_code >200";

        ResultSet resultSet2=   statement.executeQuery(query2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getInt("phone_code")+"---"+
                    resultSet2.getString("country_name"));
        }

        System.out.println("---------------Task 4----------------------");
        String query4 ="SELECT name,grade FROM students WHERE grade > (SELECT AVG(pass_grade) FROM Departments)";
        ResultSet resultSet4 =statement.executeQuery(query4);
        while (resultSet4.next()){
            System.out.println(resultSet4.getString("name")+" -- "+resultSet4.getInt("grade"));
        }

        statement.close();
        con.close();
    }
}
