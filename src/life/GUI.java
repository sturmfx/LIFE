/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author lordstorm
 */
public class GUI extends JPanel
{
    int x = 60;
    int y = 60;
    Point p;
    Timer t;
    ActionListener al;
    boolean calculate = false;
    public Tile[][] field = new Tile[x][y];
    public GUI()
    {
        setBackground(Color.BLACK);
        setSize(new Dimension(900, 900));
        set_tiles(x, y);
        al = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                calculate();
            }
        };
        t = new Timer(500,al);
        
    }
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        for(int x = 0; x < this.x; x++)
        {
            for(int y = 0; y < this.y; y++)
            {
                field[x][y].draw(g);
                
                
            }
        }
        repaint();
    }
    {
        this.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            public void mousePressed(java.awt.event.MouseEvent evt) 
            {
                p = evt.getPoint();
                if(evt.getButton()==1)
                {
                if((p.x/Tile.width<x)&&(p.y/Tile.height<y))
                {
                    field[p.x/Tile.width][p.y/Tile.height].color = Color.RED;
                    field[p.x/Tile.width][p.y/Tile.height].set_alive(true);
                }
                }
                if(evt.getButton()==3)
                {
                if((p.x/Tile.width<x)&&(p.y/Tile.height<y))
                {
                    field[p.x/Tile.width][p.y/Tile.height].color = Color.GREEN;
                    field[p.x/Tile.width][p.y/Tile.height].set_alive(false);
                }
                }
                if(evt.getButton()==2)
                {
                    
                    if(calculate)
                    {
                        calculate = false;
                        t.start();
                    }
                    else
                    {
                        calculate = true;
                        t.stop();
                    }
                    
                    
                }
            }
        });
    }
    public boolean is_alive(int x, int y)
    {
        int sum = 0;
        if(field[getx(x-1)][gety(y-1)].is_alive())sum++;
        if(field[getx(x-1)][gety(y)].is_alive())sum++;
        if(field[getx(x-1)][gety(y+1)].is_alive())sum++;
        if(field[getx(x)][gety(y-1)].is_alive())sum++;
        if(field[getx(x)][gety(y+1)].is_alive())sum++;
        if(field[getx(x+1)][gety(y-1)].is_alive())sum++;
        if(field[getx(x+1)][gety(y)].is_alive())sum++;
        if(field[getx(x+1)][gety(y+1)].is_alive())sum++;
        if(field[getx(x)][gety(y)].is_alive())
        {
            if((sum == 2)||(sum == 3))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(sum == 3)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
    }
    public void set_tiles(int width, int height)
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                field[x][y] = new Tile(x, y);
                
            }
        }
        
    }
    public void calculate()
    {
        
        
            for(int x = 0; x < this.x; x++)
            {
                for(int y = 0; y < this.y; y++)
                {
                    field[x][y].set_temp_alive(is_alive(x,y));
                }
            }
            for(int x = 0; x < this.x; x++)
            {
                for(int y = 0; y < this.y; y++)
                {
                    field[x][y].set_alive(field[x][y].is_temp_alive());
                    if(field[x][y].is_alive())
                    {
                        field[x][y].color = Color.RED;
                    }
                    else
                    {
                        field[x][y].color = Color.GREEN;
                    }
                }
            }
            
            
                
            
        }
    public int getx(int x)
    {
        if((x>=0)&&(x<this.x))return x;
        if(x==-1)return (this.x-1);
        if(x == this.x)return 0;
        return 1000000;
    }
    public int gety(int y)
    {
        if((y>=0)&&(y<this.y))return y;
        if(y==-1)return (this.y-1);
        if(y == this.y)return 0;
        return 1000000;
    }
    }

