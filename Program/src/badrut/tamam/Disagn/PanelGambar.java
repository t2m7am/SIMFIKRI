/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package badrut.tamam.Disagn;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author FUCK_HIM
 */
public class PanelGambar extends JPanel{
    private Image gam;

    public PanelGambar() {
        setOpaque(false);
       gam=new ImageIcon(getClass().getResource("/badrut/tamam/Image/background.jpg")).getImage();
       
    }

    public void setGambar(String name){
        try{
            gam=new ImageIcon(getClass().getResource("/badrut/tamam/Image/"+name)).getImage();
            repaint();
        }
        catch(Exception z){}
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg=(Graphics2D)g.create();
        gg.drawImage(gam,0,0,getWidth(),getHeight(),null);
        gg.dispose();
    }



}
