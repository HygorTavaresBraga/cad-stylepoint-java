package telas;

import entidade.Cliente;
import dao.ClienteDao;
import conexao.Conexao;
import dao.FornecedorDao;
import entidade.Fornecedor;
import java.sql.*;
import javax.swing.*;

public class ConsultarFornecedor extends javax.swing.JFrame {

    Connection conexao;
    PreparedStatement linguagem;
    ResultSet linha;

    void novo() {
        jcnpj.setEnabled(true);
        jconsultar.setEnabled(true);
        jcnpj.requestFocus();
    }

    void limpar() {
        jrazaoSocial.setText("");
        jcnpj.setText("");
        jemail.setText("");
        jcodigo.setText("");       
        jendereco.setText("");
        jtelefone.setText("");
        jcnpj.requestFocus();
    }

    public ConsultarFornecedor() {
        initComponents();
        conexao = Conexao.conexao();

    }

    void consultar() {
        try {
            String cnpj = jcnpj.getText();
            FornecedorDao dao = new FornecedorDao();
            Fornecedor fornecedor = dao.consultar(cnpj);
            if (fornecedor == null) {
                JOptionPane.showMessageDialog(null, "Fornecedor não Encontrado");
                limpar();
            }else{
                jcodigo.setText(String.valueOf(fornecedor.getIdFornecedor()));
                jrazaoSocial.setText(fornecedor.getRazaoSocial());
                jcnpj.setText(fornecedor.getCnpj());
                jendereco.setText(fornecedor.getEnderecoFornecedor());
                jtelefone.setText(fornecedor.getTelefoneFornecedor());
                jemail.setText(fornecedor.getEmailFornecedor());
                jeditar1.setEnabled(true);
                jsalvar.setEnabled(true);
                jexcluir.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Fornecedor encontrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro no SQL" + e.getMessage());
        }
    }
    
    void editar(){
        jrazaoSocial.setEnabled(true);
        jtelefone.setEnabled(true);
        jemail.setEnabled(true);
        jendereco.setEnabled(true);
        
    }
    
    void salvar(){
        String cnpj = jcnpj.getText();
        String razaosocial = jrazaoSocial.getText();
        String telefone = jtelefone.getText();
        String email = jemail.getText();
        String endereco = jendereco.getText();
        
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setCnpj(cnpj);
        fornecedor.setRazaoSocial(razaosocial);
        fornecedor.setTelefoneFornecedor(telefone);
        fornecedor.setEmailFornecedor(email);
        fornecedor.setEnderecoFornecedor(endereco);
        
        FornecedorDao dao = new FornecedorDao();
        dao.atualizar(fornecedor);
        JOptionPane.showMessageDialog(null, "Fornecedor Atualizado!");
        limpar();
        jcnpj.setEnabled(true);
        jrazaoSocial.setEnabled(false);
        jtelefone.setEnabled(false);
        jemail.setEnabled(false);
        jendereco.setEnabled(false);
        jcnpj.requestFocus();
        
        
    }
    void excluir(){
        FornecedorDao dao = new FornecedorDao();
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir?", "Exclusão",JOptionPane.YES_NO_OPTION);
        if(confirma ==JOptionPane.YES_OPTION){
            dao.excluir(jcnpj.getText());
            JOptionPane.showMessageDialog(null,"Fornecedor Excluído!");
            limpar();
        }else{jcnpj.requestFocus();
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

        jrazaoSocial = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jendereco = new javax.swing.JTextField();
        jcnpj = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcodigo = new javax.swing.JTextField();
        jmenu = new javax.swing.JButton();
        jnovo = new javax.swing.JButton();
        jeditar1 = new javax.swing.JButton();
        jsalvar = new javax.swing.JButton();
        jexcluir = new javax.swing.JButton();
        jsair = new javax.swing.JButton();
        jconsultar = new javax.swing.JButton();
        jtelefone = new javax.swing.JFormattedTextField();
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

        jrazaoSocial.setEnabled(false);
        getContentPane().add(jrazaoSocial);
        jrazaoSocial.setBounds(210, 150, 184, 30);

        jemail.setEnabled(false);
        jemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jemailActionPerformed(evt);
            }
        });
        getContentPane().add(jemail);
        jemail.setBounds(210, 230, 184, 30);

        jendereco.setEnabled(false);
        jendereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenderecoActionPerformed(evt);
            }
        });
        getContentPane().add(jendereco);
        jendereco.setBounds(210, 270, 184, 30);

        try {
            jcnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jcnpj.setEnabled(false);
        getContentPane().add(jcnpj);
        jcnpj.setBounds(210, 60, 184, 30);

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CONSULTAR FORNECEDOR");
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel9);
        jLabel9.setBounds(160, 10, 220, 30);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("CNPJ:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel12);
        jLabel12.setBounds(50, 60, 150, 24);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Email:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 230, 150, 24);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Endereço:");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel14);
        jLabel14.setBounds(50, 270, 150, 24);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Telefone:");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 190, 150, 24);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Código:");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel13);
        jLabel13.setBounds(50, 110, 150, 24);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Razão Social:");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel17);
        jLabel17.setBounds(50, 150, 150, 24);

        jcodigo.setEditable(false);
        jcodigo.setEnabled(false);
        getContentPane().add(jcodigo);
        jcodigo.setBounds(210, 110, 50, 30);

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

        jeditar1.setText("Editar");
        jeditar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jeditar1.setEnabled(false);
        jeditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeditar1ActionPerformed(evt);
            }
        });
        getContentPane().add(jeditar1);
        jeditar1.setBounds(430, 160, 50, 19);

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
        jconsultar.setEnabled(false);
        jconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jconsultarActionPerformed(evt);
            }
        });
        getContentPane().add(jconsultar);
        jconsultar.setBounds(250, 390, 70, 19);

        try {
            jtelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtelefone.setEnabled(false);
        getContentPane().add(jtelefone);
        jtelefone.setBounds(210, 190, 130, 30);

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

    private void jemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jemailActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new CadCliente().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jenderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenderecoActionPerformed

    private void jmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuActionPerformed

    private void jnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnovoActionPerformed
        novo();
    }//GEN-LAST:event_jnovoActionPerformed

    private void jeditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeditar1ActionPerformed
        editar();
    }//GEN-LAST:event_jeditar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ConsultarFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField jcnpj;
    private javax.swing.JTextField jcodigo;
    private javax.swing.JButton jconsultar;
    private javax.swing.JButton jeditar1;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jendereco;
    private javax.swing.JButton jexcluir;
    private javax.swing.JButton jmenu;
    private javax.swing.JButton jnovo;
    private javax.swing.JTextField jrazaoSocial;
    private javax.swing.JButton jsair;
    private javax.swing.JButton jsalvar;
    private javax.swing.JFormattedTextField jtelefone;
    // End of variables declaration//GEN-END:variables

   

   

}
