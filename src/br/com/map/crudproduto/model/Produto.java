//Produto (codigo, nome, preco, especificacao)

package br.com.map.crudproduto.model;

import br.com.map.crudproduto.model.Especificacao;

public class Produto{
    private int codigo;
    private String nome;
    private float preco;
    private Especificacao especificacao;

    public Produto(){
    }

    public Produto(int codigo, String nome, float preco, Especificacao especificacao){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.especificacao = especificacao;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }
    public void setEspecificacao(Especificacao especificacao){
        this.especificacao = especificacao;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public float getPreco(){
        return preco;
    }
    public Especificacao getEspecificacao(){
        return especificacao;
    }
}