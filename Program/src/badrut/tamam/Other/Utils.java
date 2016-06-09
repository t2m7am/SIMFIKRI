/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badrut.tamam.Other;

import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 *
 * @author Nabila S Faddia
 */
public class Utils {

  public static final String format(long l) {

    String s = String.valueOf(l);
    int digits = 0;
    while (s.length() > 3) {
        s = s.substring(0, s.length() - 3);
        digits++;
    }
    StringBuffer buffer = new StringBuffer();
    buffer.append(s);
    if ((s.length() == 1) && (String.valueOf(l).length() >= 3)) {
        buffer.append(".");
        buffer.append(String.valueOf(l).substring(1, 3));
    } else if ((s.length() == 2) && (String.valueOf(l).length() >= 3)) {
        buffer.append(".");
        buffer.append(String.valueOf(l).substring(2, 3));
    }
    if (digits == 0) {
        buffer.append(" B");
    } else if (digits == 1) {
        buffer.append(" KB");
    } else if (digits == 2) {
        buffer.append(" MB");
    } else if (digits == 3) {
        buffer.append(" GB");
    } else if (digits == 4) {
        buffer.append(" TB");
    }
    return buffer.toString();

}
  public static void main(String arString){
  
      
  }
    
  

}
