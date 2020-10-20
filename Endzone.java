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
public class Endzone {
    private int x, y;
    private final int width, height;
    private final boolean isFinish;
    private final static Color Forest = new Color(34,139,34);

    Endzone(int x, int y, int width, int height, boolean isFinish) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isFinish = false;
    }

    public void draw(Graphics g) {
        g.setColor(Forest);
        g.fillRect(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isIsFinish() {
        return isFinish;
    }

}
