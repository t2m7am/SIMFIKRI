/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package badrut.tamam.Algoritma;

/**
 *
 * @author NabilTa
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;


public class Encrypter{
    private boolean crypt;
    private String Pass;
    private String NewFile;
    
      InputStream inStream = null;
      OutputStream outStream = null;
    
    public Encrypter(String aKey) { 
        mKey = KeyValue(aKey); 
    }
    
    static final String key = "Encrypt";
    
    private static int KeyValue(String str){
        IntValue = 0;
        Len = str.length();
        for(int i=Len-1; i>=0; i--){
            IntValue = IntValue * Len + (byte)str.charAt(i);
            if (IntValue > 255) IntValue /= Len;
        }return IntValue; 
    }
    
    static int Len;
    static int IntValue;
    static int mKey;
    
    private static String encryptPassword(String str){
        str = str + "$";
        StringBuffer sb = new StringBuffer(str);
        int lenStr = str.length();
        int lenKey = "Encrypt".length();
        int i = 0; 
        for (int j = 0; i < lenStr; j++){
            if (j >= lenKey) j = 0;
            sb.setCharAt(i, (char)(str.charAt(i) ^ "Encrypt".charAt(j)));
            str = sb.toString();
            int KeyChar = mKey ^ (byte)str.charAt(i);
            sb.setCharAt(i, (char)KeyChar);i++;
    }return sb.toString();
  }

public void encryptFile(String FileUrl, String Password) throws java.io.IOException {
    java.io.InputStream in = null;
    OutputStream out = null;
    String inFile = "E:\\Badrut Tamam\\Data\\1. Encript"+Password+FileUrl.substring(25);
    System.out.println("hasil Encrypt Document = "+inFile);
    String outFile = inFile + ".crys";
    Pass = encryptPassword(Password);

    
    try{
      in = new java.io.BufferedInputStream(new java.io.FileInputStream(FileUrl));
      out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outFile));
     
      encryptStream(in, out, inFile);
      
     }finally {
        if (in != null){
        in.close();
        
        }if (out != null){
            out.flush();
            out.close();
            
      }
    }
  }

public boolean CekFile(String inFile) {
    boolean Stat = true;
    try{
        FileReader CheckedFile = new java.io.FileReader(inFile);
        
    }catch (java.io.FileNotFoundException e){
        java.io.FileReader CheckedFile;
        javax.swing.JOptionPane.showMessageDialog(null, "Operasi Error \nCek File", "Error", 0);
        Stat = false;
    }return Stat;
}
  
public void decryptFile(String inFile, String Password) throws java.io.IOException {
    java.io.InputStream in = null;
    OutputStream out = null;
    
    String outFile = inFile.substring(0, inFile.length() - 4);
    String hslFile = "E:\\project\\Document\\Data\\2. Descript\\"+outFile.substring(39);
    System.out.println(hslFile);
    Pass = encryptPassword(Password);
    try{
      in = new java.io.BufferedInputStream(new java.io.FileInputStream(inFile));
      
      out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(hslFile));
      decryptStream(in, out);
    }finally{
        if(in != null){
            in.close();
        }
        if (out != null){
            out.flush();
            out.close();
        }
    }
}
  
public void encryptStream(java.io.InputStream in, OutputStream out, String inFile) throws java.io.IOException {
    boolean done = false;
    for (int i=0; i<Pass.length(); i++){
        out.write((byte)Pass.charAt(i));
    
    }
    while (!done){
        int next = in.read();
        if (next == -1){
            try {
                   
                    /*File afile = new File(inFile+".cry");
                    File bfile = new File("E:\\project\\Document\\Data\\1. Encript\\"+afile.getName()); //pindah dengan nama asli
                    //afile.getName();
                   
                    //Files.move(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
                    inStream = new FileInputStream(afile);
                    System.out.println("berhasilllll");
                    outStream = new FileOutputStream(bfile);

                    byte[] buffer = new byte[2048];
                    
                    int length;
                    //copy the file content in bytes 
                    while ((length = inStream.read(buffer)) > 0){
                        outStream.write(buffer, 0, length);
                    }

                    

                    //delete the original file
                    if(afile.delete()){
                            System.out.println(afile.getName() + " is deleted!");
                    }else{
                            System.out.println("Delete operation is failed.");
                    }
                    inStream.close();
                    outStream.close();
                    
                    System.out.println("File is copied successful!");
                    * */
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Gagal copi","ytyuy", 1);
            }
            done = true;
            javax.swing.JOptionPane.showMessageDialog(null, "Enkripsi File Sukses", "Sukses", 1);
            javax.swing.JOptionPane.showMessageDialog(null, "Deleted File Asli", "Sukses", 1);
      }else{
            byte b = (byte)next;
            byte c = encrypt(b);
            out.write(c);
        }
    }
}

public void decryptStream(java.io.InputStream in, OutputStream out) throws java.io.IOException {
    boolean done = false;
    String textPass = "";
    
    for (int i=0; i<Pass.length(); i++)
        textPass = textPass + (char)in.read();
    if (textPass.equals(Pass)){
        while(!done){
            int next = in.read();
            if (next == -1){
                done = true;
                javax.swing.JOptionPane.showMessageDialog(null, "Deskripsi File Sukses", "Sukses", 1);
            }else{
                byte b = (byte)next;
                byte c = encrypt(b);
                out.write(c);
                
                    //javax.swing.JOptionPane.showMessageDialog(null, "Password Salah \n Atau File Salah", "Process Failed", 2);

            }
        }
    }
    
}
  
  public byte encrypt(int b){
      String KeyStr = "";
      int LenKey = "Encrypt".length();
      for (int i = 0; i < LenKey; i++){
          KeyStr = KeyStr + "Encrypt".charAt(i);
          b ^= KeyValue(KeyStr);
      
      }return (byte)(b ^ mKey);
  }

}

