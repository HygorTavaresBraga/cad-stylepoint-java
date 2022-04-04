package telas;

import entidade.Cliente;
import dao.ClienteDao;
import conexao.Conexao;
import dao.EstoqueDao;
import entidade.Estoque;
import java.sql.*;
import javax.swing.*;

public class ConsultarEstoque extends javax.swing.JFrame {

    Connection conexao;
    PreparedStatement linguagem;
    ResultSet linha;

    void novo() {
        jnome.setEnabled(true);
        jconsultar.setEnabled(true);
        jnome.requestFocus();
    }

    void limpar() {
        jnome.setText("");
        jcodigo.setText("");
        jdescricao.setText("");
        jtamanho.setText("");
        jpreco.setText("");
        jcor.setText("");
        
        jdescricao.requestFocus();
    }

    public ConsultarEstoque() {
        initComponents();
        conexao = Conexao.conexao();

    }

    void consultar() {
        try {
            String nomeRoupa = jnome.getText();
            EstoqueDao dao = new EstoqueDao();
            Estoque estoque = dao.consultar(nomeRoupa);
            if (estoque == null) {
                JOptionPane.showMessageDialog(null, "Roupa não encontrada!");
                limpar();
            }else{
                jcodigo.setText(String.valueOf(estoque.getIdRoupa()));
                jnome.setText(estoque.getNomeRoupa());
                jtamanho.setText(estoque.getTamanho());
                jpreco.setText(String.valueOf(estoque.getPreco()));
                jdescricao.setText(estoque.getDescricao());
                jcor.setText(estoque.getCor());
                jeditar.setEnabled(true);
                jsalvar.setEnabled(true);
                jexcluir.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Roupa encontrada!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro no SQL" + e.getMessage());
        }
    }
    
    void editar(){
        jdescricao.setEnabled(true);
        jtamanho.setEnabled(true);
        jpreco.setEnabled(true);
        jcor.setEnabled(true);
    }
    
    void salvar(){

        String nome = jnome.getText();
        String descricao = jdescricao.getText();
        String tamanho = jtamanho.getText();
        Double preco = Double.parseDouble(jpreco.getText());
        String cor = jcor.getText();
        
        Estoque estoque = new Estoque();
        

        estoque.setNomeRoupa(nome);
        estoque.setDescricao(descricao);
        estoque.setTamanho(tamanho);
        estoque.setPreco(preco);
        estoque.setCor(cor);
        
        EstoqueDao dao = new EstoqueDao();
        dao.atualizar(estoque);

        JOptionPane.showMessageDialog(null, "Cliente Atualizado!");
        limpar();
        jdescricao.setEnabled(false);
        jtamanho.setEnabled(false);
        jpreco.setEnabled(false);
        jcor.setEnabled(false);
        
        
    }
    void excluir(){
        EstoqueDao dao = new EstoqueDao();
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir?", "Exclusão",JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            dao.excluir(jnome.getText());
            JOptionPane.showMessageDialog(null,"Excluído");
            limpar();
        }else{jnome.requestFocus();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtamanho = new javax.swing.JTextField();
        jdescricao = new javax.swing.JTextField();
        jcor = new javax.swing.JTextField();
        jpreco = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jcodigo = new javax.swing.JTextField();
        jnome = new javax.swing.JTextField();
        jmenu = new javax.swing.JButton();
        jnovo = new javax.swing.JButton();
        jeditar = new javax.swing.JButton();
        jsalvar = new javax.swing.JButton();
        jexcluir = new javax.swing.JButton();
        jsair = new javax.swing.JButton();
        jconsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consultar Cliente");
        setMinimumSize(new java.awt.Dimension(513, 477));
        setResizable(false);
        getContentPane().setLayout(null);

        jtamanho.setEnabled(false);
        jtamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtamanhoActionPerformed(evt);
            }
        });
        getContentPane().add(jtamanho);
        jtamanho.setBounds(210, 190, 50, 30);

        jdescricao.setEnabled(false);
        getContentPane().add(jdescricao);
        jdescricao.setBounds(210, 150, 184, 30);

        jcor.setEnabled(false);
        jcor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcorActionPerformed(evt);
            }
        });
        getContentPane().add(jcor);
        jcor.setBounds(210, 270, 110, 30);

        jpreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jpreco.setEnabled(false);
        getContentPane().add(jpreco);
        jpreco.setBounds(210, 230, 110, 30);

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CONSULTAR ROUPA");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel8);
        jLabel8.setBounds(160, 10, 190, 30);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Código:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel12);
        jLabel12.setBounds(50, 110, 150, 24);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Descrição:");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel11);
        jLabel11.setBounds(50, 150, 150, 24);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Nome:");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel13);
        jLabel13.setBounds(50, 60, 150, 24);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tamanho:");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 190, 150, 24);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Preço:");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 230, 150, 24);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cor:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 270, 150, 24);

        jcodigo.setEditable(false);
        jcodigo.setEnabled(false);
        getContentPane().add(jcodigo);
        jcodigo.setBounds(210, 110, 50, 30);

        jnome.setEnabled(false);
        getContentPane().add(jnome);
        jnome.setBounds(210, 60, 169, 30);

        jmenu.setText("Menu");
        jmenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuActionPerformed(evt);
            }
        });
        getContentPane().add(jmenu);
        jmenu.setBounds(430, 70, 50, 19);

        jnovo.setText("Novo");
        jnovo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnovoActionPerformed(evt);
            }
        });
        getContentPane().add(jnovo);
        jnovo.setBounds(430, 100, 50, 19);

        jeditar.setText("Editar");
        jeditar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jeditar.setEnabled(false);
        jeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeditarActionPerformed(evt);
            }
        });
        getContentPane().add(jeditar);
        jeditar.setBounds(430, 160, 50, 19);

        jsalvar.setText("Salvar");
        jsalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jsalvar.setEnabled(false);
        jsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jsalvar);
        jsalvar.setBounds(430, 190, 50, 19);

        jexcluir.setText("Excluir");
        jexcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jexcluir.setEnabled(false);
        jexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jexcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jexcluir);
        jexcluir.setBounds(430, 250, 50, 19);

        jsair.setText("Sair");
        jsair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsairActionPerformed(evt);
            }
        });
        getContentPane().add(jsair);
        jsair.setBounds(430, 390, 50, 19);

        jconsultar.setText("Consultar");
        jconsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(jconsultar);
        jconsultar.setBounds(250, 390, 70, 19);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, -20, 520, 460);

        jMenuBar1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N

        jMenu1.setText("Sistema");

        jMenuItem1.setText("Cadastrar Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem6.setText("Sair");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtamanhoActionPerformed

    private void jcorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new CadCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuActionPerformed

    private void jnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnovoActionPerformed
        novo();
    }//GEN-LAST:event_jnovoActionPerformed

    private void jeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeditarActionPerformed
        editar();
    }//GEN-LAST:event_jeditarActionPerformed

    private void jsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsalvarActionPerformed
        salvar();
    }//GEN-LAST:event_jsalvarActionPerformed

    private void jexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jexcluirActionPerformed
        excluir();
    }//GEN-LAST:event_jexcluirActionPerformed

    private void jsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jsairActionPerformed

    private void jconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jconsultarActionPerformed
        consultar();
    }//GEN-LAST:event_jconsultarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jcodigo;
    private javax.swing.JButton jconsultar;
    private javax.swing.JTextField jcor;
    private javax.swing.JTextField jdescricao;
    private javax.swing.JButton jeditar;
    private javax.swing.JButton jexcluir;
    private javax.swing.JButton jmenu;
    private javax.swing.JTextField jnome;
    private javax.swing.JButton jnovo;
    private javax.swing.JFormattedTextField jpreco;
    private javax.swing.JButton jsair;
    private javax.swing.JButton jsalvar;
    private javax.swing.JTextField jtamanho;
    // End of variables declaration//GEN-END:variables

   

   

}
