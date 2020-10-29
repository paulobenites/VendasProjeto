/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jdbc;


import java.sql.Connection;
import java.sql.DriverManager;


public class conectionFactory {
    
    public Connection getConnetion(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas","usuario","123");
        }
        catch (Exception erro) {
            throw new RuntimeException(erro);
        }
    }

    
}
