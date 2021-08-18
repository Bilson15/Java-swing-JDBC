/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ConexaoBanco {
    public static Connection ConexaoBanco(){
        try {
          String url = "jdbc:oracle:thin:@localhost:1521:XE";
          String username = "bilson";
          String password = "bilson";
          return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            return null;
        }
    }
}
