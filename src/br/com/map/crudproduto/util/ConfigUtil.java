/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudproduto.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author natan
 */
public class ConfigUtil {
    
    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static final String CONFIG_JDBC_URL = "config.jdbc.url";
    public static final String CONFIG_JDBC_USUARIO = "config.jdbc.usuario";
    public static final String CONFIG_JDBC_SENHA = "config.jdbc.senha";
    
    public static String getConfig(String key){
        return bundle.getString(key);
    }
}
