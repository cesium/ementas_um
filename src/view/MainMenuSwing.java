/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import src.CCalendar;
import src.CanceledOptionException;
import src.Meal;
import util.FileParser;

/**
 *
 * @author joaorodrigues
 */
public class MainMenuSwing extends javax.swing.JFrame {

    /**
     * Creates new form MainMenuSwing
     */
    public MainMenuSwing() {
        startCalendars();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setResizable(false);
        setTitle("Ementas UM");
        filePath = new javax.swing.JTextField();
        fileDialogButton = new javax.swing.JButton();
        addEventsButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageList = new DefaultListModel();
        estado = new javax.swing.JList(messageList);
        year = new javax.swing.JSpinner();
        month = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filePath.setText("Nenhum ficheiro escolhido");
        filePath.setToolTipText("");
        filePath.setEnabled(false);
        filePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathActionPerformed(evt);
            }
        });

        fileDialogButton.setText("Carregar Ementa");
        fileDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileDialogButtonActionPerformed(evt);
            }
        });

        addEventsButton.setText("Adicionar eventos ao calendário");
        addEventsButton.setEnabled(false);
        addEventsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addEventsButtonMouseClicked(evt);
            }
        });

        jLabel1.setText("Estado");

        jScrollPane1.setViewportView(estado);

        year.setEditor(new javax.swing.JSpinner.NumberEditor(year,"#"));
        year.setValue(2014);
        year.setModel(new javax.swing.SpinnerNumberModel(2014, 2014, 2100, 1));

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        jLabel2.setText("Tipo");

        type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Normal", "Vegetariano", "Rampa B" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEventsButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filePath)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileDialogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileDialogButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addEventsButton)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //used to output status messages
    public void addMessage(String message){
        messageList.addElement(message);
    }
    
    //opens a file chooser when "Carregar Ementa" is pressed
    private void fileDialogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileDialogButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Ficheiros TXT", "txt");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           filePath.setEnabled(true);
           addEventsButton.setEnabled(true);
           filePath.setText(chooser.getSelectedFile().getAbsolutePath());
        }
        
    }//GEN-LAST:event_fileDialogButtonActionPerformed

    
    
    private void filePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathActionPerformed
    
    //Parses the menu in the file and adds it to Google Calendar
    private void addEventsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEventsButtonMouseClicked
        //Used to avoid adding the meal twice
        addEventsButton.setEnabled(false);
        
        FileParser parser = new FileParser(filePath.getText(), year.getValue().toString(), Integer.toString(month.getSelectedIndex() + 1));
        
        ArrayList<Meal> lmeal = null;
        try {
            int t = type.getSelectedIndex();
            lmeal = (ArrayList<Meal>) parser.getParsedMeals(t);
            calendars.commitListMeal(lmeal, this, t);
            this.addMessage("Ementa adicionada com sucesso");
            
        } catch (IOException ex) {
            this.addMessage("Erro de escrita/leitura");
        } catch (ArrayIndexOutOfBoundsException e) {
            this.addMessage("Erro de sintaxe no ficheiro");
        }
	
        
    }//GEN-LAST:event_addEventsButtonMouseClicked

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed
        

    //Creates CCalendar with the calendars in config.properties and user data in environment variables and sets it up
    public void startCalendars(){
        Properties prop = new Properties();
        String client_id = System.getenv("EMENTAS_CLIENT_ID");
        String client_secret = System.getenv("EMENTAS_CLIENT_SECRET");
        if( (client_id == null) || (client_secret == null) ){
            JOptionPane.showMessageDialog(null, "Dados de utilizador Google não encontrados");
            System.exit(0);
        }
        
        try {
            InputStream in = new FileInputStream("config.properties");
            prop.load(in);
            
            String almocoRampaA = prop.getProperty("almocoRampaA");
            String jantarRampaA = prop.getProperty("jantarRampaA");
            String almocoVegetariano = prop.getProperty("almocoVegetariano");
            String jantarVegetariano = prop.getProperty("jantarVegetariano");
            String almocoRampaB = prop.getProperty("almocoRampaB");
            
            if( (almocoRampaA == null)
                || (jantarRampaA == null)
                || (almocoVegetariano == null)
                || (jantarVegetariano == null)
                || (almocoRampaB == null) ){
                JOptionPane.showMessageDialog(null, "Erros no ficheiro de configuração");
                System.exit(0);
            }
            
            
            calendars = new CCalendar(client_id,
                                        client_secret,
                                        prop.getProperty("almocoRampaA"),
                                        prop.getProperty("jantarRampaA"),
                                        prop.getProperty("almocoVegetariano"),
                                        prop.getProperty("jantarVegetariano"),
                                        prop.getProperty("almocoRampaB"));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ficheiro de configuração não foi encontrado");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro a ler ficheiro de propriedades");
            System.exit(0);
        }
        
        try {
            calendars.setUp(this);
        } catch (GeneralSecurityException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Segurança");
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Leitura/Escrita");
            System.exit(0);
        } catch (CanceledOptionException ex) {
            JOptionPane.showMessageDialog(null, "Cancelado");
            System.exit(0);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuSwing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventsButton;
    private javax.swing.JList estado;
    private javax.swing.JButton fileDialogButton;
    private javax.swing.JTextField filePath;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox month;
    private javax.swing.JComboBox type;
    private javax.swing.JSpinner year;
    // End of variables declaration//GEN-END:variables
    private CCalendar calendars;
    private DefaultListModel messageList;
}
