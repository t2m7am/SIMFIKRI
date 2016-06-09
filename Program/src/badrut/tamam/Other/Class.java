/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badrut.tamam.Other;

/**
 *
 * @author Nabila S Faddia
 */

public class Class {
    public static void main(String[] args) {
    final String FPATH = "/home/mem/index.html";
    Class file = new Class(FPATH, '/', '.');
    System.out.println("Extension = " + file.extension());
    System.out.println("Filename = " + file.filename());
    System.out.println("Path = " + file.path());
  }
    private String fullPath;
  private char pathSeparator, extensionSeparator;
  
       public Class(String str, char sep, char ext) {
           fullPath = str;
           pathSeparator = sep;
           extensionSeparator = ext;
       }
       
       public String extension() {
           int dot = fullPath.lastIndexOf(extensionSeparator);
           return fullPath.substring(dot + 1);
       }
       
       public String filename() { // gets filename without extension
           int dot = fullPath.lastIndexOf(extensionSeparator);
           int sep = fullPath.lastIndexOf(pathSeparator);
           return fullPath.substring(sep + 1, dot);
       }
       
       public String path() {
           int sep = fullPath.lastIndexOf(pathSeparator);
           return fullPath.substring(0, sep);
  }
    
}

