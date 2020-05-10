/**
 *
 * @author Osman Karadeniz
 */

package picaptcha;

import java.math.BigInteger;
import java.util.Random;
import javax.swing.JOptionPane;


public class PiCaptcha extends javax.swing.JFrame {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final BigInteger FOUR = BigInteger.valueOf(4);
    private static final BigInteger SEVEN = BigInteger.valueOf(7);

    private static BigInteger q = BigInteger.ONE;
    private static BigInteger r = BigInteger.ZERO;
    private static BigInteger t = BigInteger.ONE;
    private static BigInteger k = BigInteger.ONE;
    private static BigInteger n = BigInteger.valueOf(3);
    private static BigInteger l = BigInteger.valueOf(3);
    
    
    public PiCaptcha() {
        initComponents();
        String captcha = sayi_uret(31) + sayi_uret(12) + sayi_uret(99);
        kod.setText("769845");
        // YUKARDAKİ İÇERİĞİ DEĞİŞTİREREK İSTEDİĞİMİZ İLE BAŞLATARAK DAHA RAHAT ÇIKTI GÖREBİLİRİZ.
        bekle.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baslik = new javax.swing.JLabel();
        dogrula = new javax.swing.JButton();
        kod = new javax.swing.JLabel();
        dog_kod_button = new javax.swing.JButton();
        dog_kod_onay = new javax.swing.JTextField();
        dog_kod1 = new javax.swing.JLabel();
        dog_kod_label = new javax.swing.JLabel();
        kod1 = new javax.swing.JLabel();
        dog_kod = new javax.swing.JLabel();
        yeni_uret = new javax.swing.JButton();
        bekle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pİ CAPTCHA");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        baslik.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        baslik.setText("ROBOT OLMADIĞINIZI KANITLAYIN !");
        getContentPane().add(baslik, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        dogrula.setText("DOĞRULAMA KODUNU ÜRET");
        dogrula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dogrulaActionPerformed(evt);
            }
        });
        getContentPane().add(dogrula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, 40));

        kod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(kod, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 60, 30));

        dog_kod_button.setText("ONAYLA");
        dog_kod_button.setEnabled(false);
        dog_kod_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dog_kod_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(dog_kod_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 80, 30));

        dog_kod_onay.setEnabled(false);
        getContentPane().add(dog_kod_onay, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 150, 30));

        dog_kod1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dog_kod1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(dog_kod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 140, 50));

        dog_kod_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dog_kod_label.setText("Doğrulama Kodu :");
        dog_kod_label.setEnabled(false);
        getContentPane().add(dog_kod_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, 30));

        kod1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kod1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kod1.setText("Üretilen Captcha Kodu :");
        getContentPane().add(kod1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 160, 30));

        dog_kod.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        getContentPane().add(dog_kod, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 190, 50));

        yeni_uret.setText("Yeni Üret");
        yeni_uret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeni_uretActionPerformed(evt);
            }
        });
        getContentPane().add(yeni_uret, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, -1, 30));

        bekle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bekle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bekle.setText("İŞLEM DEVAM ETMEKTE LÜTFEN BEKLEYİNİZ !");
        getContentPane().add(bekle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 340, 60));

        setSize(new java.awt.Dimension(406, 297));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public int pibasamakdonder(String captcha) {
        int basamak = 0;

        try {

            basamak = new PiCaptcha().Pibasamakhesapla(captcha);
            dog_kod1.setText("Doğrulama Kodu : ");
            dog_kod.setText("" + basamak);
            dog_kod_label.setEnabled(true);
            dog_kod_button.setEnabled(true);
            dog_kod_onay.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "HATA !");
        }

        return basamak;
    }
    
    public static String sayi_uret(int aralik) {

        String captcha;

        Random rnd = new Random();
        int rasgele_sayi;

        rasgele_sayi = rnd.nextInt(aralik) + 1;

        if (rasgele_sayi >= 1 && rasgele_sayi < 10) {
            captcha = "0" + rasgele_sayi;
        } else {
            captcha = "" + rasgele_sayi;
        }

        return captcha;

    }

    public static int Pibasamakhesapla(String captcha) {

        int basamak;
        BigInteger nn;
        BigInteger nr;
        boolean first = true;
        String pi_sayi = "";

        String kontrol_eleman = "";

        while (true) {

            if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                pi_sayi += n;
                if (first) {
                    //kontrol_eleman+=n+".";
                    pi_sayi += ".";
                    first = false;
                } else {

                    kontrol_eleman += "" + n;

                    if (kontrol_eleman.length() >= 6) {

                        if (kontrol_eleman.substring(kontrol_eleman.length() - 6, kontrol_eleman.length()).equals(captcha)) {
                            // Çıkarttığım 6 digit 6 basamaklı sayının kendisidir.
                            // Eklediğim 2 digit  (3.) ifadesinin basamak sayısıdır.

                            basamak = kontrol_eleman.length() - 6 + 2;

                            break;

                        }
                    }

                }
                nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t)));
                n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t)
                        .subtract(BigInteger.TEN.multiply(n));
                q = q.multiply(BigInteger.TEN);
                r = nr;
                System.out.flush();

            } else {
                nr = TWO.multiply(q).add(r).multiply(l);
                nn = q.multiply(SEVEN.multiply(k)).add(TWO).add(r.multiply(l))
                        .divide(t.multiply(l));
                q = q.multiply(k);
                t = t.multiply(l);
                l = l.add(TWO);
                k = k.add(BigInteger.ONE);
                n = nn;
                r = nr;
            }

        }

        return basamak;
    }
    
    
    private void dogrulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogrulaActionPerformed
        bekle.setVisible(true);
        JOptionPane.showMessageDialog(null, "Bu işlem işlemci gücünüze bağlı olarak uzun sürebilir lütfen bekleyiniz !");

        long startTime = System.currentTimeMillis();

        pibasamakdonder(kod.getText());

        long endTime = System.currentTimeMillis();
        long estimatedTime = endTime - startTime;
        double seconds = (double) estimatedTime / 1000;
        bekle.setVisible(false);
        JOptionPane.showMessageDialog(null, "Kodun Üretim Süresi : " + seconds);
        dogrula.setEnabled(false);

    }//GEN-LAST:event_dogrulaActionPerformed

    private void dog_kod_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dog_kod_buttonActionPerformed

        String girilen = dog_kod_onay.getText();
        String bulunan = dog_kod.getText();

        if (girilen.equals(bulunan)) {
            JOptionPane.showMessageDialog(null, "Robot Olmadığınız kanıtlanmıştır TEBRİKLER !");
        } else {
            JOptionPane.showMessageDialog(null, "MALESEF ! Robot Olmadığınız kanıtlanamamıştır !");
        }


    }//GEN-LAST:event_dog_kod_buttonActionPerformed

    private void yeni_uretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeni_uretActionPerformed

        String captcha = sayi_uret(31) + sayi_uret(12) + sayi_uret(99);
        kod.setText(captcha);
        dogrula.setEnabled(true);
        dog_kod1.setEnabled(false);
        dog_kod.setEnabled(false);
        dog_kod.setText("");
        dog_kod1.setText("");
        dog_kod_label.setEnabled(false);
        dog_kod_button.setEnabled(false);
        dog_kod_onay.setEnabled(false);
    }//GEN-LAST:event_yeni_uretActionPerformed



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
            java.util.logging.Logger.getLogger(PiCaptcha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PiCaptcha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PiCaptcha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PiCaptcha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PiCaptcha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel baslik;
    private javax.swing.JLabel bekle;
    private javax.swing.JLabel dog_kod;
    private javax.swing.JLabel dog_kod1;
    private javax.swing.JButton dog_kod_button;
    private javax.swing.JLabel dog_kod_label;
    private javax.swing.JTextField dog_kod_onay;
    private javax.swing.JButton dogrula;
    private javax.swing.JLabel kod;
    private javax.swing.JLabel kod1;
    private javax.swing.JButton yeni_uret;
    // End of variables declaration//GEN-END:variables
}
