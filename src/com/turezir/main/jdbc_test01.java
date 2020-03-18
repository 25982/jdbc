package com.turezir.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_test01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/20200315test","root","Cz2598239836:");
            conn = JDBCUtils.getConnection();
            String sql = "update test_demo set bal = 300 where id = 20";
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);
            System.out.print(count);
//            stmt.close();
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            释放资源
            JDBCUtils.close(stmt, conn);
        }

    }
}
