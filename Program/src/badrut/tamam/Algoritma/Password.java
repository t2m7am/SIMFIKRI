/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badrut.tamam.Algoritma;

/**
 *
 * @author NabilTa
 */
import java.awt.Container;
import javax.swing.JButton;

public class Password extends javax.swing.JFrame implements java.awt.event.ActionListener{
  javax.swing.JLabel label = new javax.swing.JLabel("Masukkan Password Anda : ");
  javax.swing.JPasswordField pass = new javax.swing.JPasswordField(20);
  JButton ButtOk = new JButton("OK");
  JButton ButtCancel = new JButton("Cancel");
  String FName;
  boolean Crypted;
  
  public Password(String title, String FileName, boolean encrypted) { 
      super(title);
    FName = FileName;
    Crypted = encrypted;
    ButtOk.addActionListener(this);
    ButtOk.setMnemonic(79);
    ButtCancel.addActionListener(this);
    ButtCancel.setMnemonic(67);
    getContentPane().setLayout(new java.awt.FlowLayout(1));
    getContentPane().add(label);
    getContentPane().add(pass);
    getContentPane().add(ButtOk);
    getContentPane().add(ButtCancel);
    setDefaultCloseOperation(2);
    setSize(280, 110);
    show();
  }
  
  public void actionPerformed(java.awt.event.ActionEvent e) { 
      if (e.getActionCommand().equals("OK")) {
      try
      {
        String Pwd = new String(pass.getPassword());
        if ((!Crypted) && (Pwd.length() != 0))
        {
          dispose();
          new Encrypter(Pwd).decryptFile(FName, Pwd);
        }
        else if ((Crypted) && (Pwd.length() != 0))
        {
          dispose();
          new Encrypter(Pwd).encryptFile(FName, Pwd);
        }
        else {
          javax.swing.JOptionPane.showMessageDialog(this, "Password Harus Diisi !", "Password Kosong", 1);
        }
      }
      catch (java.io.IOException err) {
        javax.swing.JOptionPane.showMessageDialog(null, "Operasa Error \nCek File", "Error", 0);
        
        dispose();
      }
      
    } else {
      dispose();
    }
  }
}
  
  
    
