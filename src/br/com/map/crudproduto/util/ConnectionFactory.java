package br.com.map.crudproduto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author natan cavalcante
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/atividade-map";
    private static final String USER = "postgres";
    private static final String PASSWORD= "admin";
    
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            System.out.println("Error: "+ e);
            return null;
        }
    }
    
}
