package br.com.map.crudproduto.UI;

import br.com.map.crudproduto.model.Produto;
import br.com.map.crudproduto.util.ConnectionFactory;
import br.com.map.crudproduto.model.Especificacao;
import br.com.map.crudproduto.dao.ProdutoDao;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Main{
    private static Scanner TextInput = new Scanner(System.in);

    public static void main(String[] args) throws SQLException{
        int alt;
        while(true){
            System.out.println("Digite:\n1- Cadastrar\n2- Editar\n3- Exibir cadastros\n4- pesquisar produto\n5- Excluir");
            alt = Integer.parseInt(TextInput.nextLine());
            switch(alt){
                case 1:
                    Cadastrar();
                    break;
                case 2:
                    Editar();
                    break;
                case 3:
                    Exibir();
                    break;
                case 4:
                    Buscar();
                    break;
                case 5:
                    Excluir();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        
            while(true){
                System.out.println("Sair? 1-sim 2-não");
                alt = Integer.parseInt(TextInput.nextLine());
                if(alt != 1 && alt != 2){
                    System.out.println("Error:");
                    continue;
                }
                break;
            }
            if(alt == 1){
                break;
            }else if(alt ==  2){
                continue;    
            }
        }
    }
    public static void Cadastrar()throws SQLException{
        ProdutoDao BD = new ProdutoDao();
        Produto p = setProduto();

        BD.inserir(p);
    }

    public static void Editar()throws SQLException{
        ProdutoDao BD = new ProdutoDao();
        int cod;
        Produto p;
        System.out.println("Digite o codigo do produto: ");
        cod = Integer.parseInt(TextInput.nextLine());
        System.out.println("_____Entre as novas informações_____\n");
        
        p = setProduto();

        BD.editar(cod, p);
    }

    private static Produto setProduto(){
        Produto p = new Produto();
        Especificacao e = new Especificacao();
        System.out.println("Digite o codigo do produto: ");
        p.setCodigo(Integer.parseInt(TextInput.nextLine()));
        System.out.println("Digite o nome: ");
        p.setNome(TextInput.nextLine());
        System.out.println("digite o preco: ");
        p.setPreco(Float.parseFloat(TextInput.nextLine()));
        System.out.println("Digite o codigo da especificação: ");
        e.setCodigo(Integer.parseInt(TextInput.nextLine()));
        System.out.println("Digite o nome do fabricante: ");
        e.setFabricante(TextInput.nextLine());
        System.out.println("Digite a cor do produto: ");
        e.setCor(TextInput.nextLine());
        System.out.println("Digite o sistema: ");
        e.setSistema(TextInput.nextLine());
        System.out.println("Digite os detalhes do produto: ");
        e.setDetalhes(TextInput.nextLine());

        p.setEspecificacao(e);

        return p;
    }

    public static void Exibir() throws SQLException{
        ProdutoDao BD = new ProdutoDao();

        List<Produtos> produtos = new ArrayList<>();
        produtos = BD.listProdutos();

        for(Produto p: produtos){
            imprimeProduto(p);
        }
    }

    public static void Buscar() throws SQLException{
        ProdutoDao BD = new ProdutoDao();
        int cod;
        System.out.println("Digite o codigo: ");
        cod = Integer.parseInt(TextInput.nextLine());
    
        imprimeProduto(BD.getProduto(cod));
    }

    private static void imprimeProduto(Produto p){
        System.out.println("--------------------------------------");
        System.out.println("Codigo: " + p.getCodigo);
        System.out.println("Nome: " + p.getNome);
        System.out.println("Preço: "eu + p.getPreco);
        System.out.println("Código: " + p.getEspecificacao().getCodigo());
        System.out.println("Fabricante: " + p.getEspecificacao().getFabricante());
        System.out.println("Cor: " + p.getEspecificacao().getCor());
        System.out.println("Sistema: " + p.getEspecificacao().getSistema());
        System.out.println("Detalhes: " + p.getEspecificacao().getDetalhes());
    }

    public static void Excluir() throws SQLException{
        ProdutoDao BD = new ProdutoDao();
        int cod;
        System.out.println("Digite o codigo: ");
        cod = Integer.parseInt(TextInput.nextLine());

        BD.deletar(cod);
    }
}

