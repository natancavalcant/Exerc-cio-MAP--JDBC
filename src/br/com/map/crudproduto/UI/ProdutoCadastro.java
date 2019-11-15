/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.crudproduto.UI;

import br.com.map.crudproduto.dao.ProdutoDao;
import br.com.map.crudproduto.model.Especificacao;
import br.com.map.crudproduto.model.Produto;
import br.com.map.crudproduto.util.MensagensUtil;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class ProdutoCadastro extends javax.swing.JFrame {
    
    private HomeScreen parent;
    private ProdutoDao produtoDao;
    private Produto produto;
    /**
     * Creates new form ProdutoCadastro
     */
    public ProdutoCadastro(HomeScreen parent, Produto p) {
        this.parent = parent;
        this.produto = p;
        this.produtoDao = new ProdutoDao();
        
        initComponents();
        
        this.ProdutoJFameTitle.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_TITULO_PRODUTO));
        this.jLabel3.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_TITULO_ESPECIFICACAO));
        this.LabelNome.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_NOME));
        this.LabelCodigoP.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_CODIGO));
        this.LabelPreco.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_PRECO));
        this.LabelFabricante.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_FABRICANTE));
        this.LabelCor.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_COR));
        this.LabelSistema.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_SISTEMA));
        this.LabelDetalhes.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_LABEL_DETALHES));
        this.CancelarButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_CANCELAR));
        this.CadastrarButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_SALVAR));
        
        if(p == null){
            this.CodigoPText.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_TEXT_CODIGO));
            this.CodigoPText.setEditable(false);
            
            this.LabelOP.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_TITULO_INSERIR));
        }else{
            this.LabelOP.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_TITULO_EDITAR));
            
            CodigoPText.setEditable(false);
            CodigoPText.setText(""+p.getCodigo());
            NomeText.setText(p.getNome());
            PrecoText.setText(""+p.getPreco());
            FabricanteText.setText(p.getEspecificacao().getFabricante());
            CorText.setText(p.getEspecificacao().getCor());
            SistemaText.setText(p.getEspecificacao().getSistema());
            DetalhesText.setText(p.getEspecificacao().getDetalhes());
            
            CadastrarButton.setText(MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_BUTTON_ALTERAR));
        }
        //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    public boolean validarCampos(){
        if(NomeText.getText() == null || NomeText.getText().trim().equals("")){
            return true;
        }
        if(PrecoText.getText() == null || PrecoText.getText().trim().equals("")){
            return true;
        }
        if(FabricanteText.getText()== null || FabricanteText.getText().trim().equals("")){
            return true;
        }
        if(CorText.getText() == null || CorText.getText().trim().equals("")){
            return true;
        }
        if(SistemaText.getText() == null || SistemaText.getText().trim().equals("")){
            return true;
        }
        
        return false;
    }
    
    public void cadastrar_Editar()throws NullPointerException, SQLException, NumberFormatException{
        //try{
            if(produto == null){
                try{
                    produto = new Produto();
                    produto.setNome(NomeText.getText());
                    produto.setCodigo(-1);
                    produto.setPreco(Float.parseFloat(PrecoText.getText()));
                    Especificacao e = new Especificacao();
                    e.setFabricante(FabricanteText.getText());
                    e.setCor(CorText.getText());
                    e.setSistema(SistemaText.getText());
                    e.setDetalhes(DetalhesText.getText());
                    produto.setEspecificacao(e);
                }catch (NumberFormatException e){
                    produto = null;
                }
                
                produtoDao.inserir(produto);
            }else{
                produto.setNome(NomeText.getText());
                produto.setPreco(Float.parseFloat(PrecoText.getText()));
                produto.getEspecificacao().setFabricante(FabricanteText.getText());
                produto.getEspecificacao().setCor(CorText.getText());
                produto.getEspecificacao().setSistema(SistemaText.getText());
                produto.getEspecificacao().setDetalhes(DetalhesText.getText());
                
                produtoDao.editar(produto.getCodigo(), produto);
           // }
        }
        /*catch (NullPointerException |NumberFormatException | SQLException e){
            JOptionPane.showMessageDialog( this, "Error: "+ e);            
        }*/
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelCadastro = new javax.swing.JPanel();
        LabelNome = new javax.swing.JLabel();
        LabelPreco = new javax.swing.JLabel();
        LabelFabricante = new javax.swing.JLabel();
        CadastrarButton = new javax.swing.JButton();
        LabelCodigoP = new javax.swing.JLabel();
        ProdutoJFameTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelCor = new javax.swing.JLabel();
        LabelSistema = new javax.swing.JLabel();
        LabelDetalhes = new javax.swing.JLabel();
        CodigoPText = new javax.swing.JTextField();
        NomeText = new javax.swing.JTextField();
        PrecoText = new javax.swing.JTextField();
        FabricanteText = new javax.swing.JTextField();
        CorText = new javax.swing.JTextField();
        SistemaText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DetalhesText = new javax.swing.JTextArea();
        CancelarButton = new javax.swing.JButton();
        PanelNome = new javax.swing.JPanel();
        LabelOP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Informações");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 100));

        LabelNome.setText("Nome:");

        LabelPreco.setText("Preço");

        LabelFabricante.setText("Fabricante:");

        CadastrarButton.setText("Cadastrar");
        CadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarButtonActionPerformed(evt);
            }
        });

        LabelCodigoP.setText("Código:");

        ProdutoJFameTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ProdutoJFameTitle.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Especificações:");

        LabelCor.setText("Cor:");

        LabelSistema.setText("Sistema:");

        LabelDetalhes.setText("Detalhes(*):");

        DetalhesText.setColumns(20);
        DetalhesText.setRows(5);
        jScrollPane1.setViewportView(DetalhesText);

        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCadastroLayout = new javax.swing.GroupLayout(PanelCadastro);
        PanelCadastro.setLayout(PanelCadastroLayout);
        PanelCadastroLayout.setHorizontalGroup(
            PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCadastroLayout.createSequentialGroup()
                .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProdutoJFameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelCadastroLayout.createSequentialGroup()
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelNome)
                                .addComponent(LabelPreco))
                            .addComponent(LabelCodigoP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CodigoPText, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(NomeText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PrecoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCadastroLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PanelCadastroLayout.createSequentialGroup()
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelFabricante)
                            .addComponent(LabelCor)
                            .addComponent(LabelSistema)
                            .addComponent(LabelDetalhes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FabricanteText)
                            .addComponent(CorText)
                            .addComponent(SistemaText)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CancelarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CadastrarButton)
                        .addGap(11, 11, 11)))
                .addContainerGap())
        );
        PanelCadastroLayout.setVerticalGroup(
            PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProdutoJFameTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCadastroLayout.createSequentialGroup()
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFabricante)
                            .addComponent(FabricanteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCor)
                            .addComponent(CorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelSistema)
                            .addComponent(SistemaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelCadastroLayout.createSequentialGroup()
                                .addComponent(LabelDetalhes)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CadastrarButton)
                            .addComponent(CancelarButton))
                        .addGap(15, 15, 15))
                    .addGroup(PanelCadastroLayout.createSequentialGroup()
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCodigoP)
                            .addComponent(CodigoPText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelNome)
                            .addComponent(NomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelPreco)
                            .addComponent(PrecoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );

        LabelOP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelOP.setText("TitleOP");

        javax.swing.GroupLayout PanelNomeLayout = new javax.swing.GroupLayout(PanelNome);
        PanelNome.setLayout(PanelNomeLayout);
        PanelNomeLayout.setHorizontalGroup(
            PanelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNomeLayout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(LabelOP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNomeLayout.setVerticalGroup(
            PanelNomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelOP, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 13, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarButtonActionPerformed
        if(validarCampos()){
            JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_VALIDACAO));
        }else{
            try{
                cadastrar_Editar();
                parent.preencheTable(null);
                this.dispose();
            }catch (NullPointerException | NumberFormatException e){
                JOptionPane.showMessageDialog(this, MensagensUtil.getMensagem(MensagensUtil.MENSAGEM_ERRO_IMCOMPATIBILIDADE));
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoCadastro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        
    }//GEN-LAST:event_CadastrarButtonActionPerformed

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarButton;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JTextField CodigoPText;
    private javax.swing.JTextField CorText;
    private javax.swing.JTextArea DetalhesText;
    private javax.swing.JTextField FabricanteText;
    private javax.swing.JLabel LabelCodigoP;
    private javax.swing.JLabel LabelCor;
    private javax.swing.JLabel LabelDetalhes;
    private javax.swing.JLabel LabelFabricante;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelOP;
    private javax.swing.JLabel LabelPreco;
    private javax.swing.JLabel LabelSistema;
    private javax.swing.JTextField NomeText;
    private javax.swing.JPanel PanelCadastro;
    private javax.swing.JPanel PanelNome;
    private javax.swing.JTextField PrecoText;
    private javax.swing.JLabel ProdutoJFameTitle;
    private javax.swing.JTextField SistemaText;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
