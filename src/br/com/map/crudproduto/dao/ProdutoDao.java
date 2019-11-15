package br.com.map.crudproduto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.map.crudproduto.model.Produto;
import br.com.map.crudproduto.model.Especificacao;
import br.com.map.crudproduto.util.ConnectionFactory;

/**
 *
 * @author natan
 * @version 1.0
 */

public class ProdutoDao{
    private Connection con;
    private PreparedStatement st;
    private String sql;

    /**
     * Método insere um produto no BD.
     * @param p Produto - Objeto do tipo produto
     * @throws SQLException
     */
    public void inserir(Produto p) throws SQLException {
        con = ConnectionFactory.getConnection();
        sql = "insert into especificacoes (fabricante, cor, sistema, detalhes) values (?, ?, ?, ?)";
        
        st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, p.getEspecificacao().getFabricante());
        st.setString(2, p.getEspecificacao().getCor());
        st.setString(3, p.getEspecificacao().getSistema());
        st.setString(4, p.getEspecificacao().getDetalhes());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();
        int codEspecificacao = 0;
        if(rs.next()){
            codEspecificacao = rs.getInt(1);
        }

        sql = "insert into produtos(nome, preco, cod_especificacao) values(?, ?, ?)";

        st = con.prepareStatement(sql);

        st.setString(1, p.getNome());
        st.setFloat(2, p.getPreco());
        st.setInt(3, codEspecificacao);

        st.executeUpdate();

        con.close();
    }

    /**
     * Método edita toda as colunas correspondente a um produto. 
     * @param codigo int - recebe o codigo do produto a ser editado
     * @param p Produto - recebe um objeto do tipo Produto
     * @throws SQLException
     */
    public void editar(int codigo, Produto p) throws SQLException {
        con = ConnectionFactory.getConnection();

        sql = "update produtos set nome = ?, preco = ? where id = ?";
        
        st = con.prepareStatement(sql);
        st.setString(1, p.getNome());
        st.setFloat(2, p.getPreco());
        st.setInt(3, codigo);
        
        st.executeUpdate();

        sql = "update especificacoes set fabricante = ?, cor = ?, sistema = ?, detalhes = ? where id = (select cod_especificacao from produtos where id = ?)";
        
        st = con.prepareStatement(sql);

        st.setString(1, p.getEspecificacao().getFabricante());
        st.setString(2, p.getEspecificacao().getCor());
        st.setString(3, p.getEspecificacao().getSistema());
        st.setString(4, p.getEspecificacao().getDetalhes());
        st.setInt(5, codigo);

        st.executeUpdate();
        
        con.close();
    }

    /**
     * Método obtém um produto através do codigo.
     * @param codigo int - Codigo correspondente a o produto.
     * @return Produto
     * @throws SQLException
     */

    public Produto getProduto(int codigo) throws SQLException{
        Produto produto = null;
        Especificacao especificacao = null;
        ResultSet rs;
        con = ConnectionFactory.getConnection();

        sql = "select * from produtos where id = ?";

        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        rs = st.executeQuery();
        if(rs.next()){
            produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getFloat("preco"), null);
        }

        int codEspecificacao = rs.getInt("cod_especificacao");

        sql = "select * from especificacoes where id = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, codEspecificacao);
        rs = st.executeQuery();
        if(rs.next()){
            especificacao = new Especificacao(rs.getInt("id"), rs.getString("fabricante"), rs.getString("cor"), rs.getString("sistema"), rs.getString("detalhes"));
        }

        produto.setEspecificacao(especificacao);

        con.close();

        return produto;
    }
    
    public List<Produto> getProdutosbyText(String text) throws SQLException{
        sql = "select * from produtos where nome iLike ?";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        st.setString(1, text);
        
        ResultSet rs = st.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while(rs.next()){
            String nome = rs.getString("nome");
            int codigo = rs.getInt("id");
            float preco = rs.getFloat("preco");
            sql = "select * from especificacoes where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, rs.getInt("cod_especificacao"));
            ResultSet rs2 = st.executeQuery();
            Especificacao especificacao = null;
            if(rs2.next()){
                especificacao = new Especificacao(rs2.getInt("id"), rs2.getString("fabricante"), rs2.getString("cor"), rs2.getString("sistema"), rs2.getString("detalhes"));
            }
            produtos.add(new Produto(codigo, nome, preco, especificacao));
        }

        
        con.close();
        return produtos;
    }

    /**
     * Metodo obtém uma lista de todos os produtos do BD.
     * @return List - lista de Objetos do tipo Produto.
     * @throws SQLException
     */

    public List<Produto> listProdutos() throws SQLException{
        sql = "select * from produtos";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<Produto> produtos = new ArrayList<>();
        while(rs.next()){
            String nome = rs.getString("nome");
            int codigo = rs.getInt("id");
            float preco = rs.getFloat("preco");
            sql = "select * from especificacoes where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, rs.getInt("cod_especificacao"));
            ResultSet rs2 = st.executeQuery();
            Especificacao especificacao = null;
            if(rs2.next()){
                especificacao = new Especificacao(rs2.getInt("id"), rs2.getString("fabricante"), rs2.getString("cor"), rs2.getString("sistema"), rs2.getString("detalhes"));
            }
            produtos.add(new Produto(codigo, nome, preco, especificacao));
        }

        
        con.close();
        return produtos;
    }

    /**
     * Método deleta um produto através do codigo.
     * @param codigo int - codigo do produto.
     * @throws SQLException
     */
    public void deletar(int codigo) throws SQLException{
        ResultSet rs;
        int codEspecificacao = 0;
        
        con = ConnectionFactory.getConnection();
        sql = "select cod_especificacao from produtos where id = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        rs = st.executeQuery();
        
        if(rs.next()){
            codEspecificacao = rs.getInt("cod_especificacao");
        }        

        sql = "delete from produtos where id = ?";
        
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);

        st.executeUpdate();

        if(codEspecificacao != 0){
            sql = "delete from especificacoes where id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, codEspecificacao);
            st.executeUpdate();
        }

        con.close();

    }
    
}
