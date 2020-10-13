/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardestgame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 802913
 */
public class Player {
    private int x, y;
    //"final" means that this variable cannot be changed, while "static" means that color does not change from one player to another
    private final static int WIDTH = 15, HEIGHT = 15;
    private final static Color INNERCOLOR = Color.RED;
    private final static Color COLOR = Color.BLACK;
    
    public Player (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.fillRect(x, y, WIDTH, HEIGHT);
        
        g.setColor(INNERCOLOR);
        g.fillRect(x+2, y+2, WIDTH-4, HEIGHT-4);
        
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }
    
}