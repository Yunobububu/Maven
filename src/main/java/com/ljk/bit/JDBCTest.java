package com.ljk.bit;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.sql.*;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class JDBCTest {
    public static void test(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/yiibaidb?useSSL=false";
        String usrname = "root";
        String password = "root";
        Connection cnn = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("can't find dirver");
        }
        try {
            //System.out.println("successed connect");
            cnn = DriverManager.getConnection(url,usrname,password);
            System.out.println(cnn);
            String sql = "SELECT * FROM employees WHERE employeeNumber < 1400";
//            String sql2 = "SELECT * from tasks";
//            String sql3 = "SELECT count(*) FROM tasks";
//            String sql4 = "INSERT INTO  tasks VALUES(?,?,?,?,?)";
//            PreparedStatement preparedStatement = cnn.prepareStatement(sql4);
//            preparedStatement.setInt(1,5);
//            preparedStatement.setString(2,"task-4");
//            preparedStatement.setDate(3,new Date(System.currentTimeMillis()));
//            preparedStatement.setDate(4,new Date(System.currentTimeMillis() + 2000));
//            preparedStatement.setString(5,"use preparedStatement");
              Statement statement = cnn.createStatement();
              ResultSet resultSet= statement.executeQuery(sql);
//            ResultSet resultSet1 = statement.executeQuery(sql3);
//            preparedStatement.executeUpdate();
//            java.sql.ResultSetMetaData rsmd = resultSet.getMetaData();
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
//            for(int i = 1;i <= rsmd.getColumnCount();i++){
//                System.out.println(rsmd.getColumnName(i));
//                System.out.println(rsmd.getColumnTypeName(i));
//            }

        } catch (SQLException e) {
            System.out.println("sql error mysql");
        }
    }
}
