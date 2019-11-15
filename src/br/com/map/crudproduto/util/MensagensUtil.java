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
public class MensagensUtil {
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale FR_FR = new Locale("fr", "FR");
    public static final Locale DE_DE = new Locale("de", "DE");
    public static final Locale EN_US = new Locale("en", "US");
    
    private static ResourceBundle resource = ResourceBundle.getBundle("mensagens", PT_BR);
    
    public static final String MENSAGEM_TITULO_INSERIR = "msn.titulo.inserir";
    public static final String MENSAGEM_TITULO_EDITAR = "msn.titulo.editar";
    public static final String MENSAGEM_TITULO_PRODUTO = "msn.titulo.produto";
    public static final String MENSAGEM_TITULO_ESPECIFICACAO = "msn.titulo.especificacao";
    
    public static final String MENSAGEM_ERRO_VALIDACAO = "msn.erro.validacao";
    public static final String MENSAGEM_ERRO_ALTERAR = "msn.erro.alterar";
    public static final String MENSAGEM_ERRO_IMCOMPATIBILIDADE = "msn.erro.imcompatibilidade";
    public static final String MENSAGEM_ERRO_INSERIR = "msn.erro.inserir";
    public static final String MENSAGEM_ERRO_PESQUISAR = "msn.erro.pesquisar";
    public static final String MENSAGEM_ERRO_TABELA = "msn.erro.tabela";
    
    public static final String MENSAGEM_LABEL_NOME = "msn.label.nome";
    public static final String MENSAGEM_LABEL_CODIGO = "msn.label.codigo";
    public static final String MENSAGEM_LABEL_PRECO = "msn.label.preco";
    public static final String MENSAGEM_LABEL_FABRICANTE = "msn.label.fabricante";
    public static final String MENSAGEM_LABEL_COR = "msn.label.cor";
    public static final String MENSAGEM_LABEL_SISTEMA = "msn.label.sistema";
    public static final String MENSAGEM_LABEL_DETALHES = "msn.label.detalhes";
    public static final String MENSAGEM_LABEL_MENSAGEM_EXCLUIR = "msn.label.mensagem.Excluir";
    public static final String MENSAGEM_LABEL_PESQUISA = "msn.label.pesquisa";
    
    public static final String MENSAGEM_TEXT_CODIGO = "msn.text.codigo";
    
    public static final String MENSAGEM_BUTTON_INSERIR = "msn.button.inserir";
    public static final String MENSAGEM_BUTTON_EDITAR = "msn.button.editar";
    public static final String MENSAGEM_BUTTON_ALTERAR = "msn.button.alterar";
    public static final String MENSAGEM_BUTTON_REMOVER = "msn.button.remover";
    public static final String MENSAGEM_BUTTON_EXIBIR = "msn.button.exibir";
    public static final String MENSAGEM_BUTTON_SAIR = "msn.button.sair";
    public static final String MENSAGEM_BUTTON_CANCELAR = "msn.button.cancelar";
    public static final String MENSAGEM_BUTTON_SALVAR = "msn.button.salvar";
    public static final String MENSAGEM_BUTTON_PESQUISA = "msn.button.pesquisa";
    
    
    public static String getMensagem(String key){
        return resource.getString(key);
    }
    
    public static void setLocale(Locale local){
        resource = ResourceBundle.getBundle("mensagens", local);
    }
}
