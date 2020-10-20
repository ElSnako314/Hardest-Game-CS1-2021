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
 * @author ElSnako
 */
public class Enemy {
    private int x, y, vx, vy;
    private final static int SPEED = 3;
    private final static int WIDTH = 25, HEIGHT = 25;
    private final static Color Blue = new Color(30,144,255);
    private final static Color Outline = Color.BLACK;

    Enemy(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void draw(Graphics g) {
        g.setColor(Outline);
        g.fillOval(x-2, y-2, WIDTH+4, HEIGHT+4);
        g.setColor(Blue);
        g.fillOval(x, y, WIDTH, HEIGHT);
    }
    
    //6.a. implement method collideWorldBounds
    /**
     * Checks if enemy hits border, if so, turns around
     * @param border Boundaries of the room
     */
    public void collideWorldBounds(Border border) {
        if (this.y < border.getY()) {
            vy *= -1;
        }
        else if (border.getY() + border.getHeight() < this.y + this.HEIGHT) {
            vy *= -1;
        }
    }
    
    public void move() {
        y += vy * SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }
    
}
