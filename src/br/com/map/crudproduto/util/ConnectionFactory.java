package br.com.map.crudproduto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author natan cavalcante
 */
public class ConnectionFactory {
    
    private static final String URL = ConfigUtil.getConfig(ConfigUtil.CONFIG_JDBC_URL);
    private static final String USER = ConfigUtil.getConfig(ConfigUtil.CONFIG_JDBC_USUARIO);
    private static final String PASSWORD = ConfigUtil.getConfig(ConfigUtil.CONFIG_JDBC_SENHA);
    
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e){
            System.out.println("Error: "+ e);
            return null;
        }
    }
    
}
