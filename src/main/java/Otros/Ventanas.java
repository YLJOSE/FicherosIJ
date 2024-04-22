package Otros;

import javax.swing.*;
import java.awt.*;

public class Ventanas extends JFrame{
    public Ventanas()
    {
        setBounds(600, 200, 300, 300);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        int[] coordenadasX={150,170,230,180,200,150,100,120,70,130};
        int[] coordenadasY={40,110,110,150,220,180,220,150,110,110};
        int nPuntos=10;
        g.setColor(new Color(241, 237, 10));
        g.drawPolygon(coordenadasX, coordenadasY, nPuntos);
    }

    public static void main(String[] args) {
        Ventanas ventana=new Ventanas();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
