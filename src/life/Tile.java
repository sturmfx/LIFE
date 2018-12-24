/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.CYAN;
import static java.awt.Color.ORANGE;
import static java.awt.Color.RED;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;


public class Tile 
{
    static int width = 15;
    static int height = 15;
    
    public int x;
    public int y;
    Color color =Color.GREEN;
    boolean alive = false;
    boolean temp_alive = false;

    public Tile(int x, int y)
    {
        this.x = x * width;
        this.y = y * height;
    }
    public boolean is_alive()
    {
        return alive;
    }
    public void set_alive(boolean b)
    {
        alive = b;
    }
     public void set_temp_alive(boolean b)
    {
        temp_alive = b;
    }
     public boolean is_temp_alive()
    {
        return temp_alive;
    }


    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double tile = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.fill(tile);
    }
}