import java.sql.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class JDBCTest {
    public static void main(String[] args){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false";
        String usrname = "root";
        String password = "20090375";
        Connection cnn = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("can't find dirver");
        }
        try {
            cnn = DriverManager.getConnection(url,usrname,password);
            System.out.println("successed connect");
            String sql = "SELECT * FROM employees WHERE employeeNumber < 1400";
            String sql2 = "SELECT * from tasks";
            String sql3 = "SELECT count(*) FROM tasks";
            String sql4 = "INSERT INTO  tasks VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = cnn.prepareStatement(sql4);
            preparedStatement.setInt(1,5);
            preparedStatement.setString(2,"task-4");
            preparedStatement.setDate(3,new Date(System.currentTimeMillis()));
            preparedStatement.setDate(4,new Date(System.currentTimeMillis() + 2000));
            preparedStatement.setString(5,"use preparedStatement");
            Statement statement = cnn.createStatement();
            ResultSet resultSet= statement.executeQuery(sql2);
            ResultSet resultSet1 = statement.executeQuery(sql3);
            preparedStatement.executeUpdate();
            while(resultSet1.next()){
                System.out.println(resultSet1.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("sql error mysql");
        }
    }
}
