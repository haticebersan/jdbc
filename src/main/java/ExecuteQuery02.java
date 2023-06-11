import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user","password");
        Statement statement =con.createStatement();
        //Task-1: Print department name and grade of department which has second highest pass_grade
        System.out.println("------------------------Task -1 ---------------");

        String query1="SELECT department ,pass_grade FROM departments ORDER BY pass_grade DESC OFFSET 1 LIMIT 1";
        ResultSet rs1=  statement.executeQuery(query1);
        while (rs1.next()){
            System.out.println("Department : "+rs1.getString("department")  +" --" +rs1.getInt("pass_grade"));
        }
        System.out.println("------------------------Task -2 ---------------");
        String query2="SELECT department ,pass_grade FROM departments WHERE pass_grade =(SELECT max(pass_grade)"+
                "FROM departments WHERE pass_grade <(SELECT max(pass_grade) FROM departments))";

        ResultSet rs2=  statement.executeQuery(query1);
        while (rs2.next()){
            System.out.println("Department : "+rs2.getString("department")  +" --" +rs2.getInt("pass_grade"));
        }
        //Task-3: List department name, campus and highest grades of students from every department

        System.out.println("-----------------------Task 3 ------------------");
        String query3 ="SELECT department ,campus, (SELECT max(grade)" +
                " FROM students s WHERE d.department = s.department) pass_grade FROM departments d";
        ResultSet rs3 = statement.executeQuery(query3);
        while (rs3.next()){
            System.out.println(rs3.getString("department")+"--"+
                    rs3.getString("campus")+"--"+
                    rs3.getInt("pass_grade"));
        }






        statement.close();
        con.close();

    }
}
