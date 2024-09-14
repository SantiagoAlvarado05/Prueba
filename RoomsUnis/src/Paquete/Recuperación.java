/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Paquete;
import javax.swing.JOptionPane;
import java.util.UUID;


public class Recuperación extends javax.swing.JFrame {

    
    public Recuperación() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void Button_Enviar_CorreoActionPerformed(java.awt.event.ActionEvent evt) {
        String correo = jTextField_Recuperacion.getText();
        if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su correo electrónico.");
            return;
        }

        if (!esCorreoValido(correo)) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un correo electrónico válido.");
            return;
        }

        if (usuarioExiste(correo)) {
            String token = generarToken();
            guardarTokenParaUsuario(correo, token);
            enviarCorreoRecuperacion(correo, token);
            JOptionPane.showMessageDialog(this, "Se ha enviado un correo de recuperación a su dirección.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna cuenta asociada a este correo electrónico.");
        }
    }

    private boolean esCorreoValido(String correo) {
        String patronCorreo = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return correo.matches(patronCorreo);
    }

    private boolean usuarioExiste(String correo) {
        // Aquí deberías implementar la lógica para verificar si el usuario existe en tu base de datos
        // Por ahora, siempre devolveremos true para fines de demostración
        return true;
    }

    private String generarToken() {
        return UUID.randomUUID().toString();
    }

    private void guardarTokenParaUsuario(String correo, String token) {
        // Aquí deberías implementar la lógica para guardar el token asociado al usuario en tu base de datos
        // Por ahora, simplemente imprimiremos el token para fines de demostración
        System.out.println("Token generado para " + correo + ": " + token);
    }

    private void enviarCorreoRecuperacion(String correo, String token) {
        String subject = "Recuperación de contraseña - Rooms Unis";
        String body = "Para recuperar su contraseña, por favor haga clic en el siguiente enlace:\n\n" +
                      "http://tudominio.com/reset-password?token=" + token + "\n\n" +
                      "Si usted no solicitó este cambio de contraseña, por favor ignore este correo.";

        try {
            EmailSender.sendEmail(correo, subject, body);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Hubo un error al enviar el correo. Por favor, intente más tarde.");
        }
    }
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_Recuperacion = new javax.swing.JTextField();
        Button_Enviar_Correo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Recuperación");

        jLabel2.setText("Ingrese su correo electrónico:");

        Button_Enviar_Correo.setText("Enviar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(Button_Enviar_Correo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Recuperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Recuperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Button_Enviar_Correo)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(Recuperación.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recuperación.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recuperación.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recuperación.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recuperación().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Enviar_Correo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField_Recuperacion;
    // End of variables declaration//GEN-END:variables
}
