/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author parab
 */
public class TicTacToeFrame extends javax.swing.JFrame {
    private boolean isPaused = false;

    private String whoseTurn="X";
    private String playerOne="player one";
    private String playerTwo="player two";
    private int playerOneScore=0;
    private int playerTwoScore=0;
    
    JLabel score1Lbl = new JLabel();
JLabel score2Lbl = new JLabel();
JButton pauseBtn = new JButton("⏸");
JButton backBtn = new JButton("b");

private void pauseButtons(boolean disable) {
    JButton[] buttons = { jButton1, jButton2, jButton3,
                          jButton4, jButton5, jButton6,
                          jButton7, jButton8, jButton9 };

    for (JButton btn : buttons) {
        if (btn.getText().equals("")) {
            btn.setEnabled(!disable);
        }
    }
}

    public TicTacToeFrame() {
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        getPlayerNames();
    JPanel topPanel = new JPanel();
// أولاً: إنشاء بانل علوي رئيسي
JPanel topMainPanel = new JPanel(new BorderLayout());

// ثانياً: إنشاء بانل للزر الخلفي (يسار)
JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
backBtn = new JButton("←");
backBtn.setFont(new Font("Arial", Font.BOLD, 20));
backPanel.add(backBtn);

// ثالثاً: إنشاء بانل للنقاط وزر الإيقاف (مركز) - كما هو عندك
JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
score1Lbl.setText(playerOne.toUpperCase() + " score: " + playerOneScore);
score2Lbl.setText(playerTwo.toUpperCase() + " score: " + playerTwoScore);

pauseBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        isPaused = !isPaused;
        pauseBtn.setText(isPaused ? "▶" : "⏸");
        pauseButtons(isPaused);
    }
});
backBtn.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        new Start().setVisible(true);
        this.dispose();
    }

            private void dispose() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

backBtn.setContentAreaFilled(false); // إزالة خلفية الزر
backBtn.setBorderPainted(false); // إزالة الحدود
centerPanel.add(score1Lbl);
centerPanel.add(pauseBtn);
centerPanel.add(score2Lbl);
pauseBtn.setContentAreaFilled(false); // إزالة خلفية الزر
pauseBtn.setBorderPainted(false); // إزالة الحدود
// رابعاً: تجميع المكونات
topMainPanel.add(backPanel, BorderLayout.WEST); // الزر الخلفي على اليسار
topMainPanel.add(centerPanel, BorderLayout.CENTER); // النقاط وزر الإيقاف في الوسط

// أخيراً: إضافة البانل الرئيسي للواجهة
add(topMainPanel, BorderLayout.NORTH);
    }
    
    private void getPlayerNames(){
        playerOne=JOptionPane.showInputDialog(this,"Enter player one name :","Player Name",JOptionPane.INFORMATION_MESSAGE);
        playerTwo=JOptionPane.showInputDialog(this,"Enter player two name :","Player Name",JOptionPane.INFORMATION_MESSAGE);
        
        if(playerOne.equals("")){
            playerOne="Player One";
        }
        if(playerTwo.equals("")){
            playerTwo="Player Two";
        }
        
    }
    
    private void detDraw(){
        String one=jButton1.getText();
        String two=jButton2.getText();
        String three=jButton3.getText();
        String four=jButton4.getText();
        String five=jButton5.getText();
        String six=jButton6.getText();
        String seven=jButton7.getText();
        String eight=jButton8.getText();
        String nine=jButton9.getText();
       
        if(one != "" && two !="" && three !="" && four !="" && five !="" && six !="" && seven !="" && eight !="" && nine !="" ){
            JOptionPane.showMessageDialog(this,"The match has been drawn !!!","Match result",JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
        
    }
    private void determineWhoseTurn(){
        if(whoseTurn.equalsIgnoreCase("X")){
            whoseTurn="O";
        }else{
            whoseTurn="X";
        }
        
    }
   
    private void xWins(){
        JOptionPane.showMessageDialog(this, playerOne.toUpperCase()+" WINS","Winner",JOptionPane.INFORMATION_MESSAGE);
        playerOneScore++;
        resetGame();
    }
    private void oWins(){
        JOptionPane.showMessageDialog(this,playerTwo.toUpperCase()+" WINS","Winner",JOptionPane.INFORMATION_MESSAGE);
        playerTwoScore++;
        resetGame();
    }
    private void determineIfWin(){
        
        String one=jButton1.getText();
        String two=jButton2.getText();
        String three=jButton3.getText();
        String four=jButton4.getText();
        String five=jButton5.getText();
        String six=jButton6.getText();
        String seven=jButton7.getText();
        String eight=jButton8.getText();
        String nine=jButton9.getText();
        
        
        if(one=="X" && two=="X" && three=="X"  ){
            xWins();
        }
        if(four=="X" && five=="X" && six=="X"  ){
            xWins();
        }
        if(seven=="X" && eight=="X" && nine=="X"  ){
            xWins();
        }
    
        
        if(one=="X" && four=="X" && seven=="X"  ){
            xWins();
        }
        if(two=="X" && five=="X" && eight=="X"  ){
            xWins();
        }
        if(three=="X" && six=="X" && nine=="X"  ){
            xWins();
        }
        if(one=="X" && five=="X" && nine=="X"  ){
            xWins();
        }
        if(seven=="X" && five=="X" && three=="X"  ){
            xWins();
        }
        
        // if o wins 
        if(one=="O" && two=="O" && three=="O"  ){
            oWins();
        }
        if(four=="o" && five=="O" && six=="O"  ){
             oWins();
        }
        if(seven=="O" && eight=="O" && nine=="O"  ){
             oWins();
        }
      
        if(one=="O" && four=="O" && seven=="O"  ){
            oWins();
        }
        if(two=="O" && five=="O" && eight=="O"  ){
             oWins();
        }
        if(three=="O" && six=="O" && nine=="O"  ){
             oWins();
        }
        if(one=="O" && five=="O" && nine=="O"  ){
             oWins();
        }
        if(seven=="O" && five=="O" && three=="O"  ){
             oWins();
        }
        
        
    }
    
    
    private void resetGame(){
        jButton1.setText("");
        jButton1.setEnabled(true);
        jButton2.setText("");
        jButton2.setEnabled(true);
        jButton3.setText("");
        jButton3.setEnabled(true);
        jButton4.setText("");
        jButton4.setEnabled(true);
        jButton5.setText("");
        jButton5.setEnabled(true);
        jButton6.setText("");
        jButton6.setEnabled(true);
        jButton7.setText("");
        jButton7.setEnabled(true);
        jButton8.setText("");
        jButton8.setEnabled(true);
        jButton9.setText("");
        jButton9.setEnabled(true);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        scorelbl = new javax.swing.JLabel();
        jPanel_Grid = new javax.swing.JPanel();
        jPanel_1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel_2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel_3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel_4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel_5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel_6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel_7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel_8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel_9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");

        jPanel4.setBackground(java.awt.Color.gray);
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.BorderLayout());

        scorelbl.setBackground(java.awt.Color.white);
        scorelbl.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        scorelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scorelbl.setOpaque(true);
        jPanel4.add(scorelbl, java.awt.BorderLayout.PAGE_END);

        jPanel_Grid.setBackground(java.awt.Color.gray);
        jPanel_Grid.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jPanel_1.setBackground(java.awt.Color.white);
        jPanel_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_1.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(java.awt.Color.black);
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_1);

        jPanel_2.setBackground(java.awt.Color.white);
        jPanel_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_2.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(java.awt.Color.black);
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel_2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_2);

        jPanel_3.setBackground(java.awt.Color.white);
        jPanel_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_3.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(java.awt.Color.black);
        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel_3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_3);

        jPanel_4.setBackground(java.awt.Color.white);
        jPanel_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_4.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(java.awt.Color.black);
        jButton4.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel_4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_4);

        jPanel_5.setBackground(java.awt.Color.white);
        jPanel_5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_5.setLayout(new java.awt.BorderLayout());

        jButton5.setBackground(java.awt.Color.black);
        jButton5.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel_5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_5);

        jPanel_6.setBackground(java.awt.Color.white);
        jPanel_6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_6.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(java.awt.Color.black);
        jButton6.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton6.setOpaque(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel_6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_6);

        jPanel_7.setBackground(java.awt.Color.white);
        jPanel_7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_7.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(java.awt.Color.black);
        jButton7.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton7.setOpaque(true);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel_7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_7);

        jPanel_8.setBackground(java.awt.Color.white);
        jPanel_8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_8.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(java.awt.Color.black);
        jButton8.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel_8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_8);

        jPanel_9.setBackground(java.awt.Color.white);
        jPanel_9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_9.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(java.awt.Color.black);
        jButton9.setFont(new java.awt.Font("Ubuntu", 1, 100)); // NOI18N
        jButton9.setOpaque(true);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel_9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel_Grid.add(jPanel_9);

        jPanel4.add(jPanel_Grid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jButton1.setText(whoseTurn);
        
        if(whoseTurn.equalsIgnoreCase("X")){
            jButton1.setForeground(Color.red);
        }
        else{
            jButton1.setForeground(Color.BLUE);
        }
        jButton1.setEnabled(false);
        determineWhoseTurn();
        determineIfWin();
        detDraw();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jButton2.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton2.setForeground(Color.red);
        }
        else{
            jButton2.setForeground(Color.BLUE);
        }
         jButton2.setEnabled(false);
        determineWhoseTurn();
        determineIfWin();detDraw();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jButton3.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton3.setForeground(Color.red);
        }
        else{
            jButton3.setForeground(Color.BLUE);
        }
         jButton3.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
         jButton4.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton4.setForeground(Color.red);
        }
        else{
            jButton4.setForeground(Color.BLUE);
        }
         jButton4.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jButton5.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton5.setForeground(Color.red);
        }
        else{
            jButton5.setForeground(Color.BLUE);
        }
         jButton5.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jButton6.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton6.setForeground(Color.red);
        }
        else{
            jButton6.setForeground(Color.BLUE);
        }
         jButton6.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jButton7.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton7.setForeground(Color.red);
        }
        else{
            jButton7.setForeground(Color.BLUE);
        }
         jButton7.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jButton8.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton8.setForeground(Color.red);
        }
        else{
            jButton8.setForeground(Color.BLUE);
        }
         jButton8.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jButton9.setText(whoseTurn);
         if(whoseTurn.equalsIgnoreCase("X")){
            jButton9.setForeground(Color.red);
        }
        else{
            jButton9.setForeground(Color.BLUE);
        }
         jButton9.setEnabled(false);
        determineWhoseTurn();determineIfWin();detDraw();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JPanel jPanel_2;
    private javax.swing.JPanel jPanel_3;
    private javax.swing.JPanel jPanel_4;
    private javax.swing.JPanel jPanel_5;
    private javax.swing.JPanel jPanel_6;
    private javax.swing.JPanel jPanel_7;
    private javax.swing.JPanel jPanel_8;
    private javax.swing.JPanel jPanel_9;
    private javax.swing.JPanel jPanel_Grid;
    private javax.swing.JLabel scorelbl;
    // End of variables declaration//GEN-END:variables
}
