package hardestgame;

import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author ElSnako
 */
public class Border {
    private final int x, y, width, height;
    private final static Color LighterGray = new Color(105,105,105);
    private final static Color Silver = new Color(192,192,192);
    
    Border(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void draw(Graphics g) {
        g.setColor(Silver);
        g.fillRect(x-5, y-5, width+10, height+10);
        
        g.setColor(LighterGray);
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
    
    
        
}
