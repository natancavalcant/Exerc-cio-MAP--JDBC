package br.com.map.crudproduto.model;

public class Especificacao{
    private int codigo;
    private String fabricante, cor, sistema, detalhes;
    
    public Especificacao(){
        
    }
    
    public Especificacao(int codigo, String fabricante, String cor, String sistema, String detalhes){
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.cor = cor;
        this.sistema = sistema;
        this.detalhes = detalhes;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setSistema(String sistema){
        this.sistema = sistema;
    }
    public void setDetalhes(String detalhes){
        this.detalhes = detalhes;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getFabricante(){
        return fabricante;
    }
    public String getCor(){
        return cor;
    }
    public String getSistema(){
        return sistema;
    }
    public String getDetalhes(){
        return detalhes;
    }
}