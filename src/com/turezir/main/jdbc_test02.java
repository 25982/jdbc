package com.turezir.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_test02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        String password = sc.next();
        boolean flag = new jdbc_test02().login(id, password);
        if (flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }


    //    登陆方法
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public boolean login(int id, String password) {
        try {
            conn = JDBCUtils.getConnection();
            String sql = " select * from user where id='" + id + "' and password='" + password + "' ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }
}
