package proyecto_Grafos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestProyecto extends javax.swing.JFrame {

    public TestProyecto() throws AlfabetoInvalido, PalabraInvalidad {
        initComponents();
        List<Character> alfabeto = new ArrayList<>();
        for (char letra = 'a'; letra < 'z'; ++letra) {
            alfabeto.add(letra);
        }
        for (char letra = 'A'; letra < 'Z'; ++letra) {
            alfabeto.add(letra);
        }       
        System.out.println("" + alfabeto);
        List<String> lenguaje = new ArrayList<>();
        lenguaje.add("int");
        lenguaje.add("float");
        lenguaje.add("String");
        lenguaje.add("char");
        lenguaje.add("Integer");
        lenguaje.add("Character");
        lenguaje.add("public");
        lenguaje.add("private");
        lenguaje.add("static");
        lenguaje.add("final");
        lenguaje.add("class");
        System.out.println(""+lenguaje);
        Lenguaje miLenguaje=new Lenguaje(alfabeto, lenguaje);
        AFD automata=new AFD(miLenguaje);
        Detector miDetector=new Detector(entrada, palabra, automata);
        Thread hilo=new Thread(miDetector);
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        entrada = new javax.swing.JTextField();
        palabra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        entrada.setBackground(new java.awt.Color(0, 0, 0));
        entrada.setForeground(new java.awt.Color(0, 0, 0));

        palabra.setBackground(new java.awt.Color(0, 0, 51));
        palabra.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        palabra.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(palabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(palabra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(TestProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TestProyecto().setVisible(true);
                } catch (AlfabetoInvalido ex) {
                    Logger.getLogger(TestProyecto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PalabraInvalidad ex) {
                    Logger.getLogger(TestProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entrada;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel palabra;
    // End of variables declaration//GEN-END:variables
}
