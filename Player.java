/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardestgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author 802913
 */
public class Player {
    private int x, y;
    private boolean isInEndzone;
    //"final" means that this variable cannot be changed, while "static" means that color does not change from one player to another
    private final static int WIDTH = 20, HEIGHT = 20, SPEED = 2;
    private final static Color Crimson = new Color(220,20,60);
    private final static Color Outline = Color.BLACK;
    
    public Player (int x, int y) {
        this.x = x;
        this.y = y;
        this.isInEndzone = false;
    }
    
    public void draw(Graphics g) {
        g.setColor(Outline);
        g.fillRect(x, y, WIDTH, HEIGHT);
        
        g.setColor(Crimson);
        g.fillRect(x+1, y+1, WIDTH-2, HEIGHT-2);
        
    }
    
     //7. implement method playerVsEnemy
    /**
     * Checks if player collides with an enemy
     * and respawns player if it does
     * @param enemy the enemy to check for collision against
     * @param start the player respawns in middle of start if collides with enemy
     */
    public void playerVsEnemy(Enemy enemy, Endzone start) {
        Rectangle playerBounds = new Rectangle(x, y, WIDTH, HEIGHT);
        Rectangle enemyBounds = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWIDTH(), enemy.getHEIGHT());
        if (playerBounds.intersects(enemyBounds)) {
            System.out.println("You have died. Try again :|");
            this.x = (int) (.5*start.getWidth()) + start.getX() - (int) (.5*this.WIDTH);
            this.y = (int) (.5*start.getHeight()) + start.getY() - (int) (.5*this.HEIGHT);
        }
    }
    
    public void isInBounds(Border border) {
        Rectangle borderBounds = new Rectangle(border.getX()+10, border.getY()+10, border.getWidth()-this.WIDTH-10, border.getHeight()-this.HEIGHT-10);
        Rectangle playerBounds = new Rectangle(x, y, WIDTH, HEIGHT);
        if (borderBounds.contains(playerBounds)) {
            this.x = x;
            this.y = y;
        }
        else if (this.x < border.getX() + 10) {
            this.x = border.getX() + 10;
        }
        else if (this.x > border.getX() + border.getWidth() - this.WIDTH - 10) {
            this.x = border.getX() + border.getWidth() - this.WIDTH - 10;
        }
        else if (this.y < border.getY() + 10) {
            this.y = border.getY() + 10;
        }
        else if (this.y > border.getY() + border.getHeight() - this.HEIGHT - 10) {
            this.y = border.getY() + border.getHeight() - this.HEIGHT - 10;
        }
    }
    
    public boolean playerVsEndzone(Endzone finish) {
        Rectangle endzoneBounds = new Rectangle(finish.getX(), finish.getY(), finish.getWidth(), finish.getHeight());
        Rectangle playerBounds = new Rectangle(x, y, WIDTH, HEIGHT);
        if (endzoneBounds.contains(playerBounds) && isInEndzone == false) {
            System.out.println("YOU DID IT YOU WIN!!!");
            System.out.println("Game's pretty hard huh?");
            return isInEndzone = true;
        }
        else if (endzoneBounds.contains(playerBounds) && isInEndzone == true) {
            return isInEndzone = true;
        }
        else {
            return isInEndzone = false;
        }
    }
    
    public void move(int dx, int dy) {
        x += SPEED * dx;
        y += SPEED * dy;

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
