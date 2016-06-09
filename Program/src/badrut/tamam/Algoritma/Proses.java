/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NabilTa
 */
package badrut.tamam.Algoritma;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Proses extends javax.swing.JFrame implements java.awt.event.ActionListener{
  JLabel label = new JLabel("  Masukkan Password Anda : ");
  javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout());
  JLabel labPersen = new JLabel("0%");
  String FName;
  boolean Crypted;
  
  public Proses(String title, long LenF) { super(title);
    getContentPane().setLayout(new java.awt.FlowLayout(1));
    getContentPane().add(label);
    setDefaultCloseOperation(2);
    setSize(180, 80);
    show();
    dispose();
  }
  
  public void actionPerformed(ActionEvent e) {
      
  }
}
  
  

