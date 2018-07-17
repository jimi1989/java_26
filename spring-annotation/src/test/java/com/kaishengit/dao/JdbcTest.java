package com.kaishengit.dao;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author jinjianghao
 * @date 2018/7/17
 */
public class JdbcTest {

    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db_26","root","rootroot");
        PreparedStatement preparedStatement = null;
        // 设置手动提交
        conn.setAutoCommit(false);

        try {
            String sql = "insert into product (product_name, product_inventory) values (?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "ikbc 键盘");
            preparedStatement.setInt(2, 99);

            preparedStatement.executeUpdate();

            // ... update delete insert
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        } finally {
            preparedStatement.close();
            conn.close();
        }

    }

}
