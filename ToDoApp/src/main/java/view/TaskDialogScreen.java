/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TaskController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Project;
import model.Task;

/**
 *
 * @author brunoferreira
 */
public class TaskDialogScreen extends javax.swing.JDialog {

    TaskController controller;
    Project project;

    public TaskDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        hideErrorFields();

        controller = new TaskController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolbarTitle = new javax.swing.JLabel();
        jLabelToolbarSave = new javax.swing.JLabel();
        jPanelTask = new javax.swing.JPanel();
        jLabel3Name = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelDescription = new javax.swing.JLabel();
        jScrollPaneDescription = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jLabel5Deadline = new javax.swing.JLabel();
        jLabelNotes = new javax.swing.JLabel();
        jScrollPaneNotes = new javax.swing.JScrollPane();
        jTextAreaNotes = new javax.swing.JTextArea();
        jFormattedTextFieldDeadline = new javax.swing.JFormattedTextField();
        jLabelNameError = new javax.swing.JLabel();
        jLabelDeadlineError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 485));

        jPanelToolBar.setBackground(new java.awt.Color(0, 102, 204));

        jLabelToolbarTitle.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelToolbarTitle.setForeground(java.awt.Color.white);
        jLabelToolbarTitle.setText("Tarefa");

        jLabelToolbarSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelToolbarSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelToolbarSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelToolbarSaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelToolbarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(jLabelToolbarSave, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolbarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelToolbarSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelTask.setBackground(java.awt.Color.white);
        jPanelTask.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3Name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3Name.setText("Nome");

        jTextFieldName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabelDescription.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelDescription.setText("Descri��o");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTextAreaDescription.setRows(5);
        jScrollPaneDescription.setViewportView(jTextAreaDescription);

        jLabel5Deadline.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5Deadline.setText("Prazo");

        jLabelNotes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelNotes.setText("Notas");

        jTextAreaNotes.setColumns(20);
        jTextAreaNotes.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTextAreaNotes.setRows(5);
        jScrollPaneNotes.setViewportView(jTextAreaNotes);

        jFormattedTextFieldDeadline.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabelNameError.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelNameError.setForeground(new java.awt.Color(204, 0, 0));
        jLabelNameError.setText("Campo de nome obrigat�rio");

        jLabelDeadlineError.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabelDeadlineError.setForeground(new java.awt.Color(204, 0, 0));
        jLabelDeadlineError.setText("Campo de prazo obrigat�rio");

        javax.swing.GroupLayout jPanelTaskLayout = new javax.swing.GroupLayout(jPanelTask);
        jPanelTask.setLayout(jPanelTaskLayout);
        jPanelTaskLayout.setHorizontalGroup(
            jPanelTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaskLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldName)
                    .addComponent(jLabelDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(jLabelNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPaneNotes)
                    .addComponent(jFormattedTextFieldDeadline)
                    .addGroup(jPanelTaskLayout.createSequentialGroup()
                        .addGroup(jPanelTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNameError)
                            .addComponent(jLabel5Deadline)
                            .addComponent(jLabelDeadlineError))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelTaskLayout.setVerticalGroup(
            jPanelTaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNameError)
                .addGap(28, 28, 28)
                .addComponent(jLabelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel5Deadline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDeadlineError)
                .addGap(26, 26, 26)
                .addComponent(jLabelNotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneNotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldNameActionPerformed

    private void jLabelToolbarSaveMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelToolbarSaveMouseClicked
        // TODO add your handling code here:

//        Esse trecho era usado na semana 6; antes das valida��es        
//        try {
//            
//            Task task = new Task();
//
//            //pegando o id do projeto na qual a tarefa pertence
//            task.setIdProject(project.getId());
//            task.setName(jTextFieldName.getText());
//            task.setDescription(jTextAreaDescription.getText());
//            task.setNotes(jTextAreaNotes.getText());
//            task.setIsCompleted(false);
//
//            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            Date deadline = null;
//
//            deadline = df.parse(jFormattedTextFieldDeadline.getText());
//            task.setDeadline(deadline);
//
//            task.setUpdatedAt(new Date());
//
//            controller.save(task);
//            JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso");

//        Forma n�o muito correta de tratar os dados, pois n�o deixa claro qual o campo est� faltando
//        try { //n�o usei o operador de nega��o s� pra ficar um pouco diferente
//            if (jTextFieldName.getText().isEmpty() || jFormattedTextFieldDeadline.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(rootPane, "A Tarefa n�o foi salva,"
//                        + " pois existem campos obrigat�rios a serem preenchidos");
//
//            } else {
//                Task task = new Task();
//
//                //pegando o id do projeto na qual a tarefa pertence
//                task.setIdProject(project.getId());
//                task.setName(jTextFieldName.getText());
//                task.setDescription(jTextAreaDescription.getText());
//                task.setNotes(jTextAreaNotes.getText());
//                task.setIsCompleted(false);
//
//                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//                Date deadline = null;
//
//                deadline = df.parse(jFormattedTextFieldDeadline.getText());
//                task.setDeadline(deadline);
//
//                task.setUpdatedAt(new Date());
//
//                controller.save(task);
//                JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso");
//                this.dispose();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e.getMessage());
//        }
        //this.dispose(); executava aqui at� a semana 6
        
         try { 
            if (isFieldsValis()) {
               Task task = new Task();

                //pegando o id do projeto na qual a tarefa pertence
                task.setIdProject(project.getId());
                task.setName(jTextFieldName.getText());
                task.setDescription(jTextAreaDescription.getText());
                task.setNotes(jTextAreaNotes.getText());
                task.setIsCompleted(false);

                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date deadline = null;

                deadline = df.parse(jFormattedTextFieldDeadline.getText());
                task.setDeadline(deadline);

                task.setUpdatedAt(new Date());

                controller.save(task);
                JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso");
                this.dispose();

            } else {
                //qdo acontecer um erro, a gente vai esconder todos os campos de erro
                //e depois mostrar o label de erro somente nos campos no qual o usu�rio tentou salvar
                hideErrorFields();
                
                if (jTextFieldName.getText().isEmpty()){
                    jLabelNameError.setVisible(true);
                }
                
                if (jFormattedTextFieldDeadline.getText().isEmpty()){
                    jLabelDeadlineError.setVisible(true);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }// GEN-LAST:event_jLabelToolbarSaveMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TaskDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaskDialogScreen dialog = new TaskDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFormattedTextFieldDeadline;
    private javax.swing.JLabel jLabel3Name;
    private javax.swing.JLabel jLabel5Deadline;
    private javax.swing.JLabel jLabelDeadlineError;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JLabel jLabelNameError;
    private javax.swing.JLabel jLabelNotes;
    private javax.swing.JLabel jLabelToolbarSave;
    private javax.swing.JLabel jLabelToolbarTitle;
    private javax.swing.JPanel jPanelTask;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneDescription;
    private javax.swing.JScrollPane jScrollPaneNotes;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaNotes;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    public void setProject(Project project) {
        this.project = project;
    }

    //Escondendo as labels que mostram msg de erro
    //chamo l� no construtor pra esconder esses campos
    public void hideErrorFields() {
        jLabelNameError.setVisible(false);
        jLabelDeadlineError.setVisible(false);
    }

    public boolean isFieldsValis() {
        
        if((!jTextFieldName.getText().isEmpty())  && (!jFormattedTextFieldDeadline.getText().isEmpty())){
            return true;
        } else {
            return false;
        }
    }

}
